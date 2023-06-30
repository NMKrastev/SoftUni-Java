package com.example.A1_ProductShop.services.seed;

import java.io.IOException;

import static com.example.A1_ProductShop.constants.Constants.ALL_DATA_SEEDED_SUCCESSFULLY;

public interface SeedService {

    String seedUsers() throws IOException;
    String seedCategories() throws IOException;

    String seedProducts() throws IOException;

    default String seedAllData() throws IOException {

        this.seedUsers();
        this.seedCategories();
        this.seedProducts();

        return ALL_DATA_SEEDED_SUCCESSFULLY;
    }
}
