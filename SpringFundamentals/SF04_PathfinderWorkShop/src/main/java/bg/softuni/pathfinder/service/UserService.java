package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserProfileDTO;
import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinder.model.entity.User;

public interface UserService {

    boolean loginUser(UserLoginDTO userLoginDTO);

    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    void logoutUser();

    UserProfileDTO findUserProfile(String username);

    User findUser(String username);
}
