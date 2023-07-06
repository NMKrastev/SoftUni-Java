package com.example.sd18_workshopmvcproject.services.user;

import com.example.sd18_workshopmvcproject.entities.user.UserLoginDTO;
import com.example.sd18_workshopmvcproject.entities.user.User;

import java.util.Optional;

public interface UserService {

    Optional<User> login(UserLoginDTO userLoginDTO);
}
