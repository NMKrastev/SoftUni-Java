package com.example.sd18_workshopmvcproject.entities.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    public UserRegisterDTO(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public boolean validate() {

        final String usernamePattern = "[a-zA-Z0-9._-]{3,}";

        if (!Pattern.matches(usernamePattern, this.username)) {
            return false;
        }

        final String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

        if (!Pattern.matches(passwordPattern, this.password)) {
            return false;
        }

        if (!this.password.equals(this.confirmPassword)) {
            return false;
        }

        final String emailPattern = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        if (!Pattern.matches(emailPattern, this.email)) {
            return false;
        }

        return true;
    }
}
