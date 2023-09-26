package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.UserLoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.model.enums.RoleEnum;
import bg.softuni.mobilelele.model.mapper.UserMapper;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.RoleService;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CurrentUser currentUser;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           CurrentUser currentUser, PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.currentUser = currentUser;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        final Optional<UserEntity> userOpt = this.userRepository.findByEmail(userLoginDTO.getEmail());

        if (userOpt.isEmpty()) {
            this.LOGGER.info(String.format("User with email [%s] not found.", userLoginDTO.getEmail()));
            return false;
        }

        final String rawPassword = userLoginDTO.getPassword();
        final String encodedPassword = userOpt.get().getPassword();

        final boolean success = this.encoder.matches(rawPassword, encodedPassword);

        if (success) {
            this.login(userOpt.get());
        } else {
            this.logoutUser();
        }

        return success;
    }

    @Override
    public void logoutUser() {

        this.currentUser.clear();
    }

    @Override
    public boolean registerUser(UserRegistrationDTO userDTO) {

        if (this.userRepository.findByEmail(userDTO.getEmail()).isPresent()
                || !userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            this.logoutUser();
            return false;
        }

        //final UserEntity newUser = mapEntity(userDTO);
        //Using MapStruct for mapping entities
        final UserEntity newUser = this.userMapper.userDtoToUserEntity(userDTO);
        newUser.setPassword(this.encoder.encode(userDTO.getPassword()));
        newUser.setRole(this.roleService.getUserRole());
        newUser.setCreated(LocalDateTime.now());

        final UserEntity savedUser = this.userRepository.saveAndFlush(newUser);

        this.login(savedUser);

        return true;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return this.userRepository.findByEmail(email).get();
    }

    private void login(UserEntity user) {

        this.currentUser.setLoggedIn(true);
        this.currentUser.setEmail(user.getEmail());
        this.currentUser.setFirstName(user.getFirstName());
        this.currentUser.setFullName(user.getFirstName() + " " + user.getLastName());
        this.currentUser.setAdmin(this.isUserAdmin(user));
    }

    private boolean isUserAdmin(UserEntity user) {

        return user
                .getRole()
                .getName()
                .equals(RoleEnum.ADMIN);
    }

/*    private UserEntity mapEntity(UserRegistrationDTO userDTO) {

        return UserEntity
                .builder()
                .active(true)
                .email(userDTO.getEmail())
                .password(this.encoder.encode(userDTO.getPassword()))
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .created(LocalDateTime.now())
                .role(this.roleService.getUserRole())
                .build();
    }*/
}
