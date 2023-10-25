package bg.softuni.mobilelele.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFullNameDTO {

    private String firstName;

    private String lastName;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
