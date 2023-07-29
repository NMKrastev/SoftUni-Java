package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private double averageObservationHours;

    @Column
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "observing_star_id")
    @Fetch(FetchMode.JOIN)
    private Star observingStar;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
