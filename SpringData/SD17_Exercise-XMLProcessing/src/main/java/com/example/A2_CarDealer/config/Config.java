package com.example.A2_CarDealer.config;

import com.example.A2_CarDealer.entities.Customer;
import com.example.A2_CarDealer.entities.dto.customer.CustomerImportDTO;
import com.example.A2_CarDealer.entities.dto.customer.CustomerInfoOrderedDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.ofPattern;

@Configuration
public class Config {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource createCarDealerDataSource() {

        final DriverManagerDataSource manager = new DriverManagerDataSource();

        manager.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driver-class-name")));
        manager.setUrl(environment.getProperty("car-dealer.spring.datasource.url"));
        manager.setUsername(environment.getProperty("spring.datasource.username"));
        manager.setPassword(environment.getProperty("spring.datasource.password"));

        return manager;
    }

    @Bean
    public void createGson() {

    }

    @Bean
    public ModelMapper createModelMapper() {

        final ModelMapper mapper = new ModelMapper();

        final Converter<String, LocalDateTime> toLocalDateTime = mappingContext ->
                LocalDateTime.parse(mappingContext.getSource(), ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        final Converter<LocalDateTime, String> fromLocalDate = mappingContext -> mappingContext.getSource().toString();
        mapper.addConverter(toLocalDateTime);

        mapper.typeMap(CustomerImportDTO.class, Customer.class)
                .addMappings(map -> map.using(toLocalDateTime).map(CustomerImportDTO::getBirthDate, Customer::setBirthDate));

        mapper.typeMap(Customer.class, CustomerInfoOrderedDTO.class)
                .addMappings(map -> map.using(fromLocalDate).map(Customer::getBirthDate, CustomerInfoOrderedDTO::setBirthDate));

        return mapper;
    }

    @Bean
    public Scanner createScanner() {

        return new Scanner(System.in);
    }

    @Bean
    public Random createRandom() {

        return new Random();
    }
}