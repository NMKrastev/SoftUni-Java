package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.dto.UserLoginDTO;
import bg.softuni.resellerapp.model.dto.UserRegistrationDTO;
import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.model.mapper.UserMapper;
import bg.softuni.resellerapp.repository.UserRepository;
import bg.softuni.resellerapp.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper,
                       CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        //Reassurance!
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

        final boolean success = this.passwordEncoder
                .matches(rawPassword, encodedPassword);

        if (success) {
            this.login(optionalUser.get());
        } else {
            this.logoutUser();
        }

        return success;
    }

    public User findUserOffers() {

        return this.userRepository
                .findByUsername(this.currentUser.getUsername())
                .get();
    }

    public void logoutUser() {

        this.currentUser.clear();
    }

    public User findByUsername(String username) {

        return this.userRepository
                .findByUsername(username)
                .get();
    }

    private void login(User user) {

        this.currentUser.setId(user.getId());
        this.currentUser.setLoggedIn(true);
        this.currentUser.setEmail(user.getEmail());
        this.currentUser.setUsername(user.getUsername());
    }

    public void saveOfferToUser(Offer savedOffer) {

        final User user = this.userRepository.findByUsername(this.currentUser.getUsername()).get();

        user.getOffers().add(savedOffer);
    }

    public List<User> findAllOtherUsersOffers() {

        return this.userRepository.findUserByIdNot(this.currentUser.getId());
    }
}