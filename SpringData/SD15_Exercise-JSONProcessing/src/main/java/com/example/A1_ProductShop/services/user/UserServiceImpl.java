package com.example.A1_ProductShop.services.user;

import com.example.A1_ProductShop.entities.dto.user.UserDTO;
import com.example.A1_ProductShop.entities.dto.user.UserWithProductsDTO;
import com.example.A1_ProductShop.entities.dto.user.UserWithSoldProductDTO;
import com.example.A1_ProductShop.entities.dto.user.UsersWithProductsWrapperDTO;
import com.example.A1_ProductShop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import static com.example.A1_ProductShop.constants.Constants.*;
import static com.example.A1_ProductShop.constants.Paths.USERS_AND_PRODUCTS_FILE_PATH;
import static com.example.A1_ProductShop.constants.Paths.USER_WITH_SOLD_PRODUCTS_FILE_PATH;
import static com.example.A1_ProductShop.utils.Utils.writeJsonIntoFile;

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
    public String findAllUsersWithSoldProductsToAtLeastOneBuyer() throws IOException {

        final List<UserWithSoldProductDTO> userWithSoldProductsDTO =
                this.userRepository
                        .findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc()
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(user -> this.mapper.map(user, UserWithSoldProductDTO.class))
                        .toList();

        if (userWithSoldProductsDTO.isEmpty()) {
            return NO_USERS_WITH_SOLD_PRODUCTS;
        }

        writeJsonIntoFile(userWithSoldProductsDTO, USER_WITH_SOLD_PRODUCTS_FILE_PATH);

        return USERS_WITH_SOLD_PRODUCTS_SAVED_SUCCESSFULLY;
    }

    @Override
    public String findUsersWithSoldProductsAndCount() throws IOException {


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

            writeJsonIntoFile(usersWithProductsWrapperDTO, USERS_AND_PRODUCTS_FILE_PATH);

        return USERS_AND_PRODUCTS_SAVED_SUCCESSFULLY;
    }
}
