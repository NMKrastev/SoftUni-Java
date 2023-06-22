package com.example.sd11_exercisespringdataadvancedquerying.services.seed;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface SeedService {

    void seedAuthors() throws IOException;

    void seedCategories() throws IOException;

    void seedBooks() throws IOException;

    default void seedAllData() throws IOException {

        this.seedAuthors();

        this.seedCategories();

        this.seedBooks();
    }
}
