package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;

public interface UserService {

    boolean loginUser(UserLoginDTO userLoginDTO);
}
