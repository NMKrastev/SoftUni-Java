package com.example.sd13_exercisespringdataautomappingobjects.services.user;

import com.example.sd13_exercisespringdataautomappingobjects.entities.User;
import com.example.sd13_exercisespringdataautomappingobjects.entities.dtos.user.UserLoginDTO;
import com.example.sd13_exercisespringdataautomappingobjects.entities.dtos.user.UserRegisterDTO;
import com.example.sd13_exercisespringdataautomappingobjects.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.sd13_exercisespringdataautomappingobjects.constants.Messages.*;
import static com.example.sd13_exercisespringdataautomappingobjects.constants.Validations.EMAIL_ALREADY_EXISTS;
import static com.example.sd13_exercisespringdataautomappingobjects.constants.Validations.USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE;

@Service
public class UserServiceImpl implements UserService {

    private User loggedInUser;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(String[] args) {

        final String email = args[0];
        final String password = args[1];
        final String confirmPassword = args[2];
        final String fullName = args[3];

        final UserRegisterDTO userRegisterDTO;

        try {
            userRegisterDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        boolean isUserFound = this.userRepository.findByEmail(userRegisterDTO.getEmail()).isPresent();

        if (isUserFound) {
            //throw new IllegalArgumentException(EMAIL_ALREADY_EXISTS);
            return EMAIL_ALREADY_EXISTS;
        }

        final User user = this.mapper.map(userRegisterDTO, User.class);
        //final User user2 = userRegisterDTO.toUser();

        user.setAdministrator(this.userRepository.count() == 0);

        this.userRepository.save(user);

        return userRegisterDTO.successfulRegisteredUser();
    }

    @Override
    public String loginUser(String[] userData) {

        if (this.loggedInUser != null) {
            return USER_ALREADY_LOGGED_IN;
        }

        final String email = userData[0];
        final String password = userData[1];

        UserLoginDTO userLoginDTO = new UserLoginDTO(email, password);

        Optional<User> user = this.userRepository.findByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword());

        if (user.isPresent() && this.loggedInUser == null) {

            this.loggedInUser = this.userRepository.findByEmail(userLoginDTO.getEmail()).get();

            return String.format(USER_LOGGED_IN_SUCCESSFULLY, this.loggedInUser.getFullName());
        }

        return String.format(USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE);
    }

    @Override
    public String logoutUser() {

        if (this.loggedInUser == null) {
            return USER_NOT_LOGGED_IN;
        }

        final String fullName = this.loggedInUser.getFullName();

        this.loggedInUser = null;

        return String.format(USER_LOGGED_OUT_SUCCESSFULLY, fullName);
    }

    @Override
    public User getLoggedInUser() {
        return this.loggedInUser;
    }
}
