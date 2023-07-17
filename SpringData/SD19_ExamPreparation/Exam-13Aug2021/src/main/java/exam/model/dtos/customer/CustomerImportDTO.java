package exam.model.dtos.customer;

import exam.model.dtos.town.TownNameDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerImportDTO {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate registeredOn;

    private TownNameDTO town;
}
