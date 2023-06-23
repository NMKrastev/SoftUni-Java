package com.example.A2_UserSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class UserSystemDataSource {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource createUserSystemDataSource() {

        DriverManagerDataSource manager = new DriverManagerDataSource();

        manager.setDriverClassName(environment.getProperty("user_system.spring.datasource.driver-class-name"));
        manager.setUrl(environment.getProperty("user_system.spring.datasource.url"));
        manager.setUsername(environment.getProperty("user_system.spring.datasource.username"));
        manager.setPassword(environment.getProperty("user_system.spring.datasource.password"));

        System.out.println();

        return manager;
    }
}
