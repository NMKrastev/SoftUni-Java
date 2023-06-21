package com.example.A2_UserSystem.services.seed;

import java.io.IOException;

public interface SeedService {

    void seedTowns() throws IOException;

    void seedUsers() throws IOException;

    default void seedAll() throws IOException {

        this.seedTowns();

        this.seedUsers();
    }
}
