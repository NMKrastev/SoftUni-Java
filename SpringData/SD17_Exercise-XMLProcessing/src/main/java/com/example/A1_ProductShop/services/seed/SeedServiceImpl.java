package com.example.A1_ProductShop.services.seed;

import com.example.A1_ProductShop.entities.Category;
import com.example.A1_ProductShop.entities.Product;
import com.example.A1_ProductShop.entities.User;
import com.example.A1_ProductShop.entities.dto.category.CategoriesImportWrapperDTO;
import com.example.A1_ProductShop.entities.dto.product.wrapper.ProductsImportWrapperDTO;
import com.example.A1_ProductShop.entities.dto.user.wrapper.UsersImportWrapperDTO;
import com.example.A1_ProductShop.repositories.CategoryRepository;
import com.example.A1_ProductShop.repositories.ProductRepository;
import com.example.A1_ProductShop.repositories.UserRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.example.A1_ProductShop.constants.Constants.*;
import static com.example.A1_ProductShop.constants.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(ModelMapper mapper, UserRepository userRepository,
                           CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String seedUsers() throws IOException, JAXBException {

        if (this.userRepository.count() != 0) {
            return USER_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(USER_XML_FILE_PATH.toFile());
        final JAXBContext context = JAXBContext.newInstance(UsersImportWrapperDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final UsersImportWrapperDTO usersDTO = (UsersImportWrapperDTO) unmarshaller.unmarshal(reader);

        try {

            final List<User> users = usersDTO.getUsers()
                    .stream()
                    .map(userDTO -> this.mapper.map(userDTO, User.class))
                    .toList();

            this.userRepository.saveAllAndFlush(users);

            users.forEach(this::setRandomFriends);

            this.userRepository.saveAllAndFlush(users);

        } catch (Exception e) {

            return e.getMessage();
        }

        reader.close();

        return USER_DATA_SEEDED_SUCCESSFULLY;
    }

    @Override
    public String seedCategories() throws IOException, JAXBException {

        if (this.categoryRepository.count() != 0) {
            return CATEGORY_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(CATEGORIES_XML_FILE_PATH.toFile());
        final JAXBContext context = JAXBContext.newInstance(CategoriesImportWrapperDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final CategoriesImportWrapperDTO categoriesDTO = (CategoriesImportWrapperDTO) unmarshaller.unmarshal(reader);

        try {

            final List<Category> categories = categoriesDTO.getCategories()
                    .stream()
                    .map(dto -> this.mapper.map(dto, Category.class))
                    .toList();

            this.categoryRepository.saveAllAndFlush(categories);

        } catch (Exception e) {

            return e.getMessage();
        }

        reader.close();

        return CATEGORY_DATA_SEEDED_SUCCESSFULLY;
    }

    @Override
    public String seedProducts() throws IOException, JAXBException {

        if (this.productRepository.count() != 0) {
            return PRODUCT_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(PRODUCTS_XML_FILE_PATH.toFile());
        final JAXBContext context = JAXBContext.newInstance(ProductsImportWrapperDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final ProductsImportWrapperDTO productsDTO = (ProductsImportWrapperDTO) unmarshaller.unmarshal(reader);

        try {

            final List<Product> products = productsDTO.getProducts()
                    .stream()
                    .map(product -> this.mapper.map(product, Product.class))
                    .map(this::setRandomSeller)
                    .map(this::setRandomBuyer)
                    .map(this::setRandomCategories)
                    .toList();

            this.productRepository.saveAllAndFlush(products);

        } catch (Exception e) {

            return e.getMessage();
        }

        reader.close();

        return PRODUCT_DATA_SEEDED_SUCCESSFULLY;
    }

    private Product setRandomCategories(Product product) {

        Set<Category> categories =
                this.categoryRepository.getRandomEntity().orElseThrow(NoSuchFieldError::new);

        product.setCategories(categories);

        return product;
    }

    private Product setRandomBuyer(Product product) {

        if (product.getSeller().getId() % 4 != 0) {

            User buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

            while (Objects.equals(buyer.getId(), product.getSeller().getId())) {

                buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }

            product.setBuyer(buyer);

        } else {

            product.setBuyer(null);
        }

        return product;
    }

    private Product setRandomSeller(Product product) {

        final User seller = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

        product.setSeller(seller);

        return product;
    }

    private User setRandomFriends(User user) {

        final Set<User> friends = new HashSet<>();

        User friendOne = this.userRepository.getRandomEntity().get();

        while (Objects.equals(user.getId(), friendOne.getId())) {
            friendOne = this.userRepository.getRandomEntity().get();
        }

        User friendTwo = this.userRepository.getRandomEntity().get();

        while (Objects.equals(user.getId(), friendTwo.getId())
                && (Objects.equals(friendOne.getId(), friendTwo.getId()))) {
            friendTwo = this.userRepository.getRandomEntity().get();
        }

        friends.add(friendOne);
        friends.add(friendTwo);

        user.setFriends(friends);

        return user;
    }
}
