package com.example.sd18_workshopmvcproject.services.user;

import com.example.sd18_workshopmvcproject.entities.user.UserLoginDTO;
import com.example.sd18_workshopmvcproject.entities.user.User;
import com.example.sd18_workshopmvcproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(UserLoginDTO userLoginDTO) {

        final String username = userLoginDTO.getUsername();
        final String password = userLoginDTO.getPassword();

        final Optional<User> optionalUser =
                this.userRepository.findByUsernameAndPassword(username, password);

        return optionalUser;

        //check password is hashed
        //marked user as logged in if data is correct
    }
}
