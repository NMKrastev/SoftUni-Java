package com.example.sd18_workshopmvcproject.services.user;

import com.example.sd18_workshopmvcproject.entities.user.User;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoggedInDTO;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoginDTO;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserRegisterDTO;
import com.example.sd18_workshopmvcproject.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserLoggedInDTO> login(UserLoginDTO userLoginDTO) {

        final String username = userLoginDTO.getUsername();
        final String password = userLoginDTO.getPassword();

        final Optional<UserLoggedInDTO> optionalUser =
                this.userRepository.findByUsernameAndPassword(username, password)
                        .stream()
                        .map(user -> this.mapper.map(user, UserLoggedInDTO.class))
                        .findFirst();

        return optionalUser;

        //check password is hashed
        //marked user as logged in if data is correct
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {

        final User user = this.mapper.map(userRegisterDTO, User.class);

        this.userRepository.saveAndFlush(user);
    }
}
