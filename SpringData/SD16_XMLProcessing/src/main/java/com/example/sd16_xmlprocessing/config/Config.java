package com.example.sd16_xmlprocessing.config;

import com.example.sd16_xmlprocessing.entities.dtos.AddressDTO;
import com.example.sd16_xmlprocessing.entities.dtos.CountryXMLDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    @Bean("addressContext")
    @Primary
    public JAXBContext createAddressContext() throws JAXBException {
        return JAXBContext.newInstance(AddressDTO.class);
    }

    @Bean("countryContext")
    public JAXBContext createCountryContext() throws JAXBException {
        return JAXBContext.newInstance(CountryXMLDTO.class);
    }

    /*@Bean
    public AddressService createAddressService(AddressRepository repository, ModelMapper mapper) {
        return new AddressServiceImpl(repository, mapper);
    }*/
}
