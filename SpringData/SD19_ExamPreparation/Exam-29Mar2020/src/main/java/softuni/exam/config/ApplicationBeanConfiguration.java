package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.util.LocalDateAdapterDeserializer;
import softuni.exam.util.LocalDateAdapterSerializer;
import softuni.exam.util.LocalDateTimeAdapterDeserializer;
import softuni.exam.util.LocalDateTimeAdapterSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {

        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapterSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapterDeserializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapterSerializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapterDeserializer())
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
