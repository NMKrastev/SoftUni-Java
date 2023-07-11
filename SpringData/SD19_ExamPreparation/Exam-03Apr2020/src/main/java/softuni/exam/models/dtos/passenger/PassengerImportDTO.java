package softuni.exam.models.dtos.passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerImportDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String phoneNumber;

    private String email;

    private String town;
}
