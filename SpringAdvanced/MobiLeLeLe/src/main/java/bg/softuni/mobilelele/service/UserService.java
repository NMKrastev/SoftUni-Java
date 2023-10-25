package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;

public interface UserService {


    //boolean loginUser(UserLoginDTO userLoginDTO);

    //void logoutUser();

    boolean registerUser(UserRegistrationDTO userDTO);

    //UserEntity findByEmail(String email);
}
