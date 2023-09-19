package bg.softuni.mobilelele.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmPassword;
}
