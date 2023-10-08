package bg.softuni.resellerapp.model.dto;

import bg.softuni.resellerapp.validations.EmailExist;
import bg.softuni.resellerapp.validations.FieldMatch;
import bg.softuni.resellerapp.validations.UsernameRegistrationExist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword")
public class UserRegistrationDTO {

    @NotBlank
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @UsernameRegistrationExist
    private String username;

    @NotBlank
    @Email
    @EmailExist
    private String email;

    @NotBlank
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;
}
