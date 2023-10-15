package com.example.planner_app.service;

import com.example.planner_app.model.dto.UserLoginDTO;
import com.example.planner_app.model.dto.UserRegistrationDTO;
import com.example.planner_app.model.entity.User;
import com.example.planner_app.model.mapper.UserMapper;
import com.example.planner_app.repository.UserRepository;
import com.example.planner_app.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
