package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dtos.passenger.PassengerByCountOfTicketDTO;
import softuni.exam.models.entities.Passenger;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Passenger findByEmail(String email);

    @Query("SELECT NEW softuni.exam.models.dtos.passenger.PassengerByCountOfTicketDTO(p.firstName, p.lastName, p.email, p.phoneNumber, COUNT(t.passenger.id)) " +
            "FROM Passenger AS p JOIN Ticket AS t ON t.passenger.id = p.id GROUP BY p.id ORDER BY COUNT(t.id) DESC, p.email")
    List<PassengerByCountOfTicketDTO> findPassengerByCountOfTicket();
}
