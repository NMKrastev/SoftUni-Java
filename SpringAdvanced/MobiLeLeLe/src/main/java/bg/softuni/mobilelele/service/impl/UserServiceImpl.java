package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.enums.RoleEnum;
import bg.softuni.mobilelele.model.mapper.UserMapper;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.RoleService;
import bg.softuni.mobilelele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    @Override
    public boolean registerUser(UserRegistrationDTO userDTO) {

        if (this.userRepository.findByEmail(userDTO.getEmail()).isPresent()
                || !userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            return false;
        }

        //Using MapStruct for mapping entities
        final UserEntity newUser = this.userMapper.userDtoToUserEntity(userDTO);
        newUser.setRole(this.roleService.getUserRole());
        newUser.setCreated(LocalDateTime.now());

        final UserEntity savedUser = this.userRepository.saveAndFlush(newUser);

        return true;
    }

}
