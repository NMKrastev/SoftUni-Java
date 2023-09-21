package bg.softuni.pathfinder.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDTO {

    private String fullName;

    private String username;

    private int age;
}
