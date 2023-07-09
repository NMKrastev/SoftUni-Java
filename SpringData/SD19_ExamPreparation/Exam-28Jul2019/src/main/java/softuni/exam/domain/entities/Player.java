package softuni.exam.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3, max = 15)
    private String lastname;

    @Column(nullable = false)
    @Min(1)
    @Max(99)
    private int number;

    @Column(nullable = false)
    @Min(0)
    private BigDecimal salary;

    @Column(nullable = false)
    private PositionType position;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Picture picture;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Team team;

    public String getFullName() {

        return this.firstName + " " + this.lastname;
    }
}
