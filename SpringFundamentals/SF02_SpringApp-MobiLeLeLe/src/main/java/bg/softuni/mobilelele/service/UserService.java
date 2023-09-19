package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserLoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegisterDTO;

public interface UserService {


    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();

    boolean registerUser(UserRegisterDTO userDTO);
}
