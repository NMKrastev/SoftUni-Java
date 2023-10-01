package bg.softuni.BattleShipsApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public PasswordEncoder createPasswordEncoder() {

        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
