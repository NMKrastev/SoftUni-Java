package com.example.A1_BookshopSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BookshopDataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource createBookshopDataSource() {

        DriverManagerDataSource manager = new DriverManagerDataSource();

        manager.setDriverClassName(environment.getProperty("bookshop.spring.datasource.driver-class-name"));
        manager.setUrl(environment.getProperty("bookshop.spring.datasource.url"));
        manager.setUsername(environment.getProperty("bookshop.spring.datasource.username"));
        manager.setPassword(environment.getProperty("bookshop.spring.datasource.password"));

        System.out.println();

        return manager;
    }
}
