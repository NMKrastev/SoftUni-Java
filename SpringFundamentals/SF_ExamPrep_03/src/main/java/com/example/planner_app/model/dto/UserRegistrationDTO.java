package com.example.planner_app.model.dto;

import com.example.planner_app.validation.EmailExist;
import com.example.planner_app.validation.FieldMatch;
import com.example.planner_app.validation.UsernameRegistrationExist;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword", message = "Password does not match!")
public class UserRegistrationDTO {

    @NotBlank(message = "No white spaces are allowed!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    @UsernameRegistrationExist
    private String username;

    @NotBlank(message = "Email must not be empty!")
    @Email(message = "Email should contain \"@\"!")
    @EmailExist
    private String email;

    @NotBlank(message = "No white spaces are allowed!")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;

    @NotBlank(message = "No white spaces are allowed!")
    @Size(min = 3, max = 20, message = "Confirm Password must be between 3 and 20 characters!")
    private String confirmPassword;
}
