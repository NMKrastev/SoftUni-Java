package com.example.A1_ProductShop.services.user;

import jakarta.xml.bind.JAXBException;

public interface UserService {

    String findAllUsersWithSoldProductsToAtLeastOneBuyer() throws JAXBException;

    String findUsersWithSoldProductsAndCount() throws JAXBException;
}
