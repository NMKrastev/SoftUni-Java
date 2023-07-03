package com.example.A1_ProductShop.services.seed;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

import static com.example.A1_ProductShop.constants.Constants.ALL_DATA_SEEDED_SUCCESSFULLY;

public interface SeedService {

    String seedUsers() throws IOException, JAXBException;
    String seedCategories() throws IOException, JAXBException;

    String seedProducts() throws IOException, JAXBException;

    default String seedAllData() throws IOException, JAXBException {

        this.seedUsers();
        this.seedCategories();
        this.seedProducts();

        return ALL_DATA_SEEDED_SUCCESSFULLY;
    }
}
