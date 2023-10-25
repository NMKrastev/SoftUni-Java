package bg.softuni.sa02_springsecurity.service;

import bg.softuni.sa02_springsecurity.model.entity.User;
import bg.softuni.sa02_springsecurity.model.entity.UserRole;
import bg.softuni.sa02_springsecurity.model.enums.RoleEnum;
import bg.softuni.sa02_springsecurity.repository.UserRepository;
import bg.softuni.sa02_springsecurity.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void init () {

        if (this.userRepository.count() == 0 && this.userRoleRepository.count() == 0) {

            UserRole adminRole = new UserRole().builder().name(RoleEnum.ADMIN).build();
            UserRole moderatorRole = new UserRole().builder().name(RoleEnum.MODERATOR).build();

            adminRole = this.userRoleRepository.save(adminRole);
            moderatorRole = this.userRoleRepository.save(moderatorRole);

            this.initAdmin(List.of(adminRole, moderatorRole));
            this.initModerator(List.of(moderatorRole));
            this.initUser(List.of());
        }
    }

    public void initAdmin(List<UserRole> roles) {

        User admin = User
                .builder()
                .roles(roles)
                .firstName("Admin")
                .lastName("Adminov")
                .email("admin@test.com")
                .password(this.passwordEncoder.encode("123"))
                .build();

        this.userRepository.save(admin);
    }

    public void initModerator(List<UserRole> roles) {

        User moderator = User
                .builder()
                .roles(roles)
                .firstName("Moderator")
                .lastName("Moderatorov")
                .email("moderator@test.com")
                .password(this.passwordEncoder.encode("123"))
                .build();

        this.userRepository.save(moderator);
    }

    private void initUser(List<UserRole> roles) {

        User user = User
                .builder()
                .roles(roles)
                .firstName("User")
                .lastName("Usererov")
                .email("user@test.com")
                .password(this.passwordEncoder.encode("123"))
                .build();

        this.userRepository.save(user);
    }
}
