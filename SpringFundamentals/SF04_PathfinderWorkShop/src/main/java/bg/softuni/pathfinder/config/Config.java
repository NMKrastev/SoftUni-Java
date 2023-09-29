package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.annotation.EncodedMapping;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {

        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder createPasswordEncoder() {

        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
