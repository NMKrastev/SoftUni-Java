package softuni.exam.models.dtos.passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerByCountOfTicketDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private long countOfTickets;
}
