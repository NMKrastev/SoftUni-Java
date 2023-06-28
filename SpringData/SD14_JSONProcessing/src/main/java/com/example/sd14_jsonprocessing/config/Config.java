package com.example.sd14_jsonprocessing.config;

import com.google.gson.GsonBuilder;
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

    @Bean
    public GsonBuilder createGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .newBuilder();
    }
}
