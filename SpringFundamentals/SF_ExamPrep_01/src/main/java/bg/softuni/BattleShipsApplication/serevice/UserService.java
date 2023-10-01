package bg.softuni.BattleShipsApplication.serevice;

import bg.softuni.BattleShipsApplication.model.dto.UserLoginDTO;
import bg.softuni.BattleShipsApplication.model.dto.UserRegistrationDTO;
import bg.softuni.BattleShipsApplication.model.entity.Ship;
import bg.softuni.BattleShipsApplication.model.entity.User;
import bg.softuni.BattleShipsApplication.model.mapper.UserMapper;
import bg.softuni.BattleShipsApplication.user.CurrentUser;
import bg.softuni.BattleShipsApplication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       CurrentUser currentUser, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
    }

    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (this.userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()
                || !userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            this.logoutUser();
            return false;
        }

        final User user = this.userMapper.userRegistrationDtoToUser(userRegistrationDTO);

        final User saveUser = this.userRepository.save(user);

        this.login(saveUser);

        return true;
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {

        final Optional<User> optionalUser = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (optionalUser.isEmpty()) {
            return false;
        }

        final String rawPassword = userLoginDTO.getPassword();
        final String encodedPassword = optionalUser.get().getPassword();

        final boolean success = this.passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            this.login(optionalUser.get());
        } else {
            this.logoutUser();
        }

        return success;
    }

    private void login(User user) {

        this.currentUser.setId(user.getId());
        this.currentUser.setLoggedIn(true);
        this.currentUser.setEmail(user.getEmail());
        this.currentUser.setUsername(user.getUsername());
        this.currentUser.setFullName(user.getFullName());
    }

    public void logoutUser() {

        this.currentUser.clear();
    }

    public User findByUsername(String username) {

        return this.userRepository
                .findByUsername(username)
                .get();
    }
}
