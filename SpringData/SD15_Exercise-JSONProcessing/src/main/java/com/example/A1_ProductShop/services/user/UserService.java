package com.example.A1_ProductShop.services.user;

import java.io.IOException;

public interface UserService {

    String findAllUsersWithSoldProductsToAtLeastOneBuyer() throws IOException;

    String findUsersWithSoldProductsAndCount() throws IOException;
}
