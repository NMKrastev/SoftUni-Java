package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.dto.userDTO.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.userDTO.UserProfileDTO;
import bg.softuni.pathfinder.model.dto.userDTO.UserRegistrationDTO;
import bg.softuni.pathfinder.model.entity.Role;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.enums.LevelEnumType;
import bg.softuni.pathfinder.model.enums.RoleEnumType;
import bg.softuni.pathfinder.model.mapper.UserMapper;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.RoleService;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           CurrentUser currentUser, UserMapper userMapper,
                           ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        final Optional<User> optionalUser = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (optionalUser.isEmpty()) {

            this.LOGGER.info(String.format("Username [%s] not found.", userLoginDTO.getUsername()));

            return false;
        }

        final String rawPassword = userLoginDTO.getPassword();

        final String encodedPassword = optionalUser.get().getPassword();

        final boolean passMatches = this.passwordEncoder.matches(rawPassword, encodedPassword);

        if (passMatches) {

            this.login(optionalUser.get());

        } else {

            this.logoutUser();

        }

        return passMatches;
    }

    @Override
    public void logoutUser() {
        this.currentUser.clear();
    }

    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (this.userRepository.findByUsername(userRegistrationDTO.getUsername()).isPresent()
                || this.userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()
                || !userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {

            this.logoutUser();

            return false;
        }

        final User user = this.userMapper.userToUserDTO(userRegistrationDTO);

        user.setRoles(Set.of(this.roleService.getUserRole()));
        user.setLevel(LevelEnumType.BEGINNER);

        final User savedUser = this.userRepository.saveAndFlush(user);

        this.login(savedUser);

        return true;
    }

    @Override
    public UserProfileDTO findUserProfile(String username) {

        final User byUsername = this.userRepository.findByUsername(username).get();

        return this.mapper.map(byUsername, UserProfileDTO.class);
    }

    @Override
    public User findUser(String username) {

        return this.userRepository.findByUsername(username).get();
    }

    private void login(User user) {

        this.currentUser.setLoggedIn(true);

        this.currentUser.setUsername(user.getUsername());

        this.currentUser.setAdmin(this.isUserAdmin(user));
    }

    private boolean isUserAdmin(User user) {

        final Set<Role> roles = user.getRoles();

        if (!roles.isEmpty()) {

            for (Role role : roles) {

                if (role.getName().equals(RoleEnumType.ADMIN)) {
                    return true;
                }
            }
        }

        return false;
    }
}
