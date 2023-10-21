package bg.softuni.dictionaryApp.service;

import bg.softuni.dictionaryApp.model.dto.UserLoginDTO;
import bg.softuni.dictionaryApp.model.dto.UserRegistrationDTO;
import bg.softuni.dictionaryApp.model.entity.User;
import bg.softuni.dictionaryApp.model.mapper.UserMapper;
import bg.softuni.dictionaryApp.repository.UserRepository;
import bg.softuni.dictionaryApp.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       UserMapper userMapper, CurrentUser currentUser) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.currentUser = currentUser;
    }

    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (this.userRepository.findByUsername(userRegistrationDTO.getUsername()).isPresent()
                || this.userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()) {

            this.logoutUser();

            return false;
        }

        final User user = this.userMapper.userRegistrationDtoToUser(userRegistrationDTO);

        this.userRepository.save(user);

        return true;
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {

        final Optional<User> optionalUser = this.userRepository
                .findByUsername(userLoginDTO.getUsername());

        if (optionalUser.isEmpty()) {

            return false;
        }

        final String rawPassword = userLoginDTO.getPassword();
        final String encodedPassword = optionalUser.get().getPassword();

        final boolean doPasswordsMatch = this.passwordEncoder
                .matches(rawPassword, encodedPassword);

        if (doPasswordsMatch) {

            this.login(optionalUser.get());

        } else {

            this.logoutUser();
        }

        return doPasswordsMatch;
    }

    public void logoutUser() {

        this.currentUser.clear();
    }

    private void login(User user) {

        this.currentUser.setLoggedIn(true);
        this.currentUser.setUsername(user.getUsername());
    }

    public User findByUsername(String username) {

        return this.userRepository
                .findByUsername(username)
                .get();
    }
}
