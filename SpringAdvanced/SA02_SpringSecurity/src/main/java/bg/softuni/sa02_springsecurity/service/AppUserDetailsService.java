package bg.softuni.sa02_springsecurity.service;

import bg.softuni.sa02_springsecurity.model.entity.User;
import bg.softuni.sa02_springsecurity.model.entity.UserRole;
import bg.softuni.sa02_springsecurity.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//NOTE: This is not annotated as @Service because we will return it as @Bean
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        this.userRepository
                .findByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));

        return null;
    }

    private UserDetails map(User user) {

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles()
                        .stream()
                        .map(this::map)
                        .toList())
                .build();
    }

    private GrantedAuthority map(UserRole userRole) {

        return new SimpleGrantedAuthority("ROLE_" + userRole.getName().name());

    }
}
