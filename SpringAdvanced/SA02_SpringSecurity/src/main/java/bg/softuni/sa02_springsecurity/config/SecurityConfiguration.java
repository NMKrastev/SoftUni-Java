package bg.softuni.sa02_springsecurity.config;

import bg.softuni.sa02_springsecurity.model.entity.UserRole;
import bg.softuni.sa02_springsecurity.model.enums.RoleEnum;
import bg.softuni.sa02_springsecurity.repository.UserRepository;
import bg.softuni.sa02_springsecurity.service.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    //Here we have to expose 3 things:
    // 1. PasswordEncoder
    // 2. SecurityFilterChain
    // 3. UserDetailsService

    @Bean
    public PasswordEncoder passwordEncoder() {

        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.
                // define which requests are allowed and which not
                        authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    // everyone can download static resources (css, js, images)
                    authorizationManagerRequestMatcherRegistry.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                            // everyone can login and register
                            .requestMatchers("/", "/users/login", "/users/register").permitAll()
                            // pages available only for moderators
                            .requestMatchers("/pages/moderators").hasRole(RoleEnum.MODERATOR.name())
                            // pages available only for admins
                            .requestMatchers("/pages/admins").hasRole(RoleEnum.ADMIN.name())
                            // all other pages are available for logged-in users
                            .anyRequest()
                            .authenticated();
                })
                // the custom login form
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            // configuration of form login
                            .loginPage("/users/login")
                            // the name of the username form field
                            .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                            // the name of the password form field
                            .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                            .// where to go in case that the login is successful
                            defaultSuccessUrl("/", true)
                            // where to go in case that the login failed
                            .failureForwardUrl("/users/login-error");
                })
                // configure logout
                .logout(httpSecurityLogoutConfigurer -> {
                    // which is the logout url
                    httpSecurityLogoutConfigurer.logoutUrl("/users/logout")
                            // invalidate the session and delete the cookies
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID");
                });

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {

        return new AppUserDetailsService(userRepository);
    }
}
