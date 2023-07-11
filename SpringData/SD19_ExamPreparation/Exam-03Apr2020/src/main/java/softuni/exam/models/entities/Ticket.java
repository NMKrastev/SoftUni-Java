package softuni.exam.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @Column(name = "serial_number", unique = true, nullable = false)
    @Size(min = 2)
    private String serialNumber;

    @Column(nullable = false)
    @Min(1)
    private BigDecimal price;

    @Column(name = "take_off")
    private LocalDateTime takeOff;

    @ManyToOne
    @JoinColumn(name = "from_town")
    @Fetch(FetchMode.JOIN)
    private Town fromTown;

    @ManyToOne
    @JoinColumn(name = "to_town")
    @Fetch(FetchMode.JOIN)
    private Town toTown;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Passenger passenger;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Plane plane;
}
