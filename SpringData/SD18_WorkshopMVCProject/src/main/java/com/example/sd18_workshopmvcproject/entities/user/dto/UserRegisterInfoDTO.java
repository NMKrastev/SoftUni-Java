package com.example.sd18_workshopmvcproject.entities.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterInfoDTO {

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    public UserRegisterInfoDTO(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }


}
