package com.example.A1_ProductShop.services.seed;

import com.example.A1_ProductShop.entities.Category;
import com.example.A1_ProductShop.entities.Product;
import com.example.A1_ProductShop.entities.User;
import com.example.A1_ProductShop.entities.dto.category.SeedCategoryDTO;
import com.example.A1_ProductShop.entities.dto.product.SeedProductDTO;
import com.example.A1_ProductShop.entities.dto.user.SeedUserDTO;
import com.example.A1_ProductShop.repositories.CategoryRepository;
import com.example.A1_ProductShop.repositories.ProductRepository;
import com.example.A1_ProductShop.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import static com.example.A1_ProductShop.constants.Constants.*;
import static com.example.A1_ProductShop.constants.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final Gson gson;
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(Gson gson, ModelMapper mapper, UserRepository userRepository,
                           CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String seedUsers() throws IOException {

        if (this.userRepository.count() != 0) {
            return USER_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<SeedUserDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(USER_JSON_FILE_PATH.toFile()));

        final List<SeedUserDTO> usersDTO = this.gson.fromJson(reader, type);

        try {

            final List<User> users = usersDTO
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
    public String seedCategories() throws IOException {

        if (this.categoryRepository.count() != 0) {
            return CATEGORY_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<SeedCategoryDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(CATEGORIES_JSON_FILE_PATH.toFile()));

        final List<SeedCategoryDTO> categoriesDTO = this.gson.fromJson(reader, type);

        try {

            final List<Category> categories = categoriesDTO
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
    public String seedProducts() throws IOException {

        if (this.productRepository.count() != 0) {
            return PRODUCT_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<SeedProductDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(PRODUCTS_JSON_FILE_PATH.toFile()));

        final List<SeedProductDTO> productsDTO = this.gson.fromJson(reader, type);

        try {

            final List<Product> products = productsDTO
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
