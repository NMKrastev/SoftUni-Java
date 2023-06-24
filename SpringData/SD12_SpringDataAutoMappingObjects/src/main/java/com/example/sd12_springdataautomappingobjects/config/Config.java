package com.example.sd12_springdataautomappingobjects.config;

import com.example.sd12_springdataautomappingobjects.repositories.AddressRepository;
import com.example.sd12_springdataautomappingobjects.services.address.AddressService;
import com.example.sd12_springdataautomappingobjects.services.address.AddressServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }

    /*@Bean
    public AddressService createAddressService(AddressRepository repository, ModelMapper mapper) {
        return new AddressServiceImpl(repository, mapper);
    }*/
}
