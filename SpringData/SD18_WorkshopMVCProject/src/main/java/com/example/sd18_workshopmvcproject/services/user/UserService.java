package com.example.sd18_workshopmvcproject.services.user;

import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoggedInDTO;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoginDTO;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserRegisterDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserLoggedInDTO> login(UserLoginDTO userLoginDTO);

    void registerUser(UserRegisterDTO userRegisterDTO);
}
