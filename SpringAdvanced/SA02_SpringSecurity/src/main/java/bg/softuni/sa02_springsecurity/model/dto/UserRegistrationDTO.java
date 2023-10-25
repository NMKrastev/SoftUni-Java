package bg.softuni.sa02_springsecurity.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
