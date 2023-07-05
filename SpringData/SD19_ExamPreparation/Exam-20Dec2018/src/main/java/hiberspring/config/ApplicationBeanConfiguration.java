package hiberspring.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hiberspring.util.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil() {

        return filePath -> new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @Bean
    public Gson gson() {

        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
//        return new ModelMapper();
    }

    @Bean
    public StringBuilder stringBuilder() {
        return new StringBuilder();
    }
}
