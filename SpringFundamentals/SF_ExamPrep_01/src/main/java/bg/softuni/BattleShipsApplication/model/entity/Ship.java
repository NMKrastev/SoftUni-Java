package bg.softuni.BattleShipsApplication.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Size(min = 2, max = 10)
    private String name;

    @Column
    @Positive
    private long health;

    @Column
    @Positive
    private long power;

    @Column(nullable = false)
    private LocalDate created;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private User user;

    @Override
    public String toString() {

        return String.format("| %s | %d | %d ", this.name, this.health, this.power);

    }
}
