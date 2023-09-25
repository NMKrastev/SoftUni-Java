package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.userDTO.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.userDTO.UserProfileDTO;
import bg.softuni.pathfinder.model.dto.userDTO.UserRegistrationDTO;
import bg.softuni.pathfinder.model.entity.User;

public interface UserService {

    boolean loginUser(UserLoginDTO userLoginDTO);

    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    void logoutUser();

    UserProfileDTO findUserProfile(String username);

    User findUser(String username);
}
