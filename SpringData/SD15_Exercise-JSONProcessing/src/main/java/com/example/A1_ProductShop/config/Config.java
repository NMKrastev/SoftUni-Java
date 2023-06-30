package com.example.A1_ProductShop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
public class Config {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource createBookshopDataSource() {

        DriverManagerDataSource manager = new DriverManagerDataSource();

        manager.setDriverClassName(environment.getProperty("product-shop.spring.datasource.driver-class-name"));
        manager.setUrl(environment.getProperty("product-shop.spring.datasource.url"));
        manager.setUsername(environment.getProperty("product-shop.spring.datasource.username"));
        manager.setPassword(environment.getProperty("product-shop.spring.datasource.password"));

        System.out.println();

        return manager;
    }

    @Bean
    public Gson createGson() {

        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper createModelMapper() {

        return new ModelMapper();
    }

    @Bean
    public Scanner createScanner() {

        return new Scanner(System.in);
    }
}
