package bg.softuni.pathfinder.model.dto.userDTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 20)
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 20)
    private String fullName;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotEmpty
    @Min(0)
    @Max(90)
    private int age;

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 20)
    private String confirmPassword;
}
