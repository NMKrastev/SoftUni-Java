package bg.softuni.BattleShipsApplication.model.dto;

import bg.softuni.BattleShipsApplication.validation.EmailExist;
import bg.softuni.BattleShipsApplication.validation.FieldMatch;
import bg.softuni.BattleShipsApplication.validation.UsernameLoginExist;
import bg.softuni.BattleShipsApplication.validation.UsernameRegistrationExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords does not match!")
public class UserRegistrationDTO {

    @NotNull
    @NotBlank(message = "Username must not be empty or have whitespace!")
    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters!")
    @UsernameRegistrationExist
    private String username;

    @NotNull
    @NotBlank(message = "Full name must not be empty or have whitespace!")
    @Size(min = 5, max = 20, message = "Full name must be between 5 and 20 characters!")
    private String fullName;

    @NotNull
    @NotBlank(message = "Email must not be empty or have whitespace!")
    @Size(min = 3, message = "Email must be at least 3 characters and should be valid!")
    @EmailExist
    private String email;

    @NotNull
    @NotBlank(message = "Password length must be more than 3 characters long!")
    private String password;

    @NotNull
    @NotBlank(message = "Password length must be more than 3 characters long!")
    private String confirmPassword;
}
