package bg.softuni.mobilelele.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder createPasswordEncoder() {

        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public ModelMapper createModelMapper() {

        final ModelMapper mapper = new ModelMapper();

        Converter<LocalDateTime, String> date = new AbstractConverter<>() {
            @Override
            protected String convert(LocalDateTime source) {

                final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

                return source.format(dtf);
            }
        };

        mapper.addConverter(date);

        return new ModelMapper();
    }
}
