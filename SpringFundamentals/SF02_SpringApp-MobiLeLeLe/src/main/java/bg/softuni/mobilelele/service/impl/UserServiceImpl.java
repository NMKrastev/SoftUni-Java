package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.UserLoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.RoleService;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CurrentUser currentUser;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           CurrentUser currentUser, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.currentUser = currentUser;
        this.encoder = encoder;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        final Optional<UserEntity> userOpt = this.userRepository.findByEmail(userLoginDTO.getEmail());

        if (userOpt.isEmpty()) {
            this.LOGGER.info(String.format("User with email [%s] not found.", userLoginDTO.getEmail()));
            return false;
        }

        final String rawPassword = userLoginDTO.getPassword();
        final String encodedPassword = userOpt.get().getPassword();

        final boolean success = this.encoder.matches(rawPassword, encodedPassword);

        if (success) {
            this.login(userOpt.get());
        } else {
            this.logoutUser();
        }

        return success;
    }

    @Override
    public void logoutUser() {

        this.currentUser.clear();
    }

    @Override
    public boolean registerUser(UserRegisterDTO userDTO) {

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            this.logoutUser();
            return false;
        }

        final UserEntity newUser = new UserEntity();

        newUser.setActive(true);
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(this.encoder.encode(userDTO.getPassword()));
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setCreated(LocalDateTime.now());
        newUser.setRole(this.roleService.getUserRole());

        final UserEntity savedUser = this.userRepository.saveAndFlush(newUser);

        this.login(savedUser);

        return true;
    }

    private void login(UserEntity user) {

        this.currentUser.setLoggedIn(true);
        this.currentUser.setFirstName(user.getFirstName());
        this.currentUser.setFullName(user.getFirstName() + " " + user.getLastName());
    }
}
