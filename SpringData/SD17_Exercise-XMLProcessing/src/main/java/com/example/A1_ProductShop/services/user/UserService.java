package com.example.A1_ProductShop.services.user;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface UserService {

    String findAllUsersWithSoldProductsToAtLeastOneBuyer() throws IOException, JAXBException;

    String findUsersWithSoldProductsAndCount() throws IOException, JAXBException;
}
