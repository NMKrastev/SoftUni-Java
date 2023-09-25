package bg.softuni.pathfinder.model.dto.userDTO;

import jakarta.validation.constraints.NotBlank;
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
public class UserLoginDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 20)
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 20)
    private String password;
}
