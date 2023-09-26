package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.validation.FieldMatch;
import bg.softuni.mobilelele.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty(message = "User email should be provided.")
    @Email(message = "User email should be valid.")
    @UniqueUserEmail(message = "Email is already in use!")
    private String email;

    @NotEmpty
    @Size(min = 5)
    private String password;

    @NotEmpty
    @Size(min = 5)
    private String confirmPassword;
}
