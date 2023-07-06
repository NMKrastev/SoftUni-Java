package com.example.sd18_workshopmvcproject;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {

        return new ModelMapper();
    }
}
