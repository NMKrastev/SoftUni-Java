package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserLoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegisterDTO;

public interface UserService {


    void registerUser(UserRegisterDTO userDTO);

    void loginUser(UserLoginDTO userLoginDTO);
}
