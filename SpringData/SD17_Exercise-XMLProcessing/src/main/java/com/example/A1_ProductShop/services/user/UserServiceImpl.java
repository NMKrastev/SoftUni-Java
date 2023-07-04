package com.example.A1_ProductShop.services.user;

import com.example.A1_ProductShop.entities.dto.user.UserDTO;
import com.example.A1_ProductShop.entities.dto.user.UserWithProductsDTO;
import com.example.A1_ProductShop.entities.dto.user.UserWithSoldProductDTO;
import com.example.A1_ProductShop.entities.dto.user.UserWithSoldProductXmlDTO;
import com.example.A1_ProductShop.entities.dto.user.wrapper.UsersWithProductsWrapperDTO;
import com.example.A1_ProductShop.entities.dto.user.wrapper.UsersWithSoldProductWrapperDTO;
import com.example.A1_ProductShop.repositories.UserRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A1_ProductShop.constants.Constants.*;
import static com.example.A1_ProductShop.constants.Paths.USERS_AND_PRODUCTS_FILE_PATH;
import static com.example.A1_ProductShop.constants.Paths.USER_WITH_SOLD_PRODUCTS_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public String findAllUsersWithSoldProductsToAtLeastOneBuyer() throws IOException, JAXBException {

        final List<UserWithSoldProductXmlDTO> userWithSoldProductsDTO =
                this.userRepository
                        .findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc()
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(user -> this.mapper.map(user, UserWithSoldProductXmlDTO.class))
                        .toList();

        if (userWithSoldProductsDTO.isEmpty()) {
            return NO_USERS_WITH_SOLD_PRODUCTS;
        }

        final UsersWithSoldProductWrapperDTO usersWithSoldProductWrapperDTO =
                new UsersWithSoldProductWrapperDTO(userWithSoldProductsDTO);

        final JAXBContext context = JAXBContext.newInstance(UsersWithSoldProductWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(usersWithSoldProductWrapperDTO, USER_WITH_SOLD_PRODUCTS_FILE_PATH.toFile());

        return USERS_WITH_SOLD_PRODUCTS_SAVED_SUCCESSFULLY;
    }

    @Override
    public String findUsersWithSoldProductsAndCount() throws IOException, JAXBException {


        final List<UserWithProductsDTO> userWithProductsDTOS = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> this.mapper.map(user, UserDTO.class))
                .map(UserDTO::toUserWithProductsDTO)
                .toList();

        final UsersWithProductsWrapperDTO usersWithProductsWrapperDTO =
                new UsersWithProductsWrapperDTO(userWithProductsDTOS);

        if (usersWithProductsWrapperDTO.getUsers().isEmpty()) {
            return NO_DATA_IN_FOR_USERS;
        }

        final JAXBContext context = JAXBContext.newInstance(UsersWithProductsWrapperDTO.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(usersWithProductsWrapperDTO, USERS_AND_PRODUCTS_FILE_PATH.toFile());

        return USERS_AND_PRODUCTS_SAVED_SUCCESSFULLY;
    }
}
