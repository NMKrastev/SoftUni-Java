package softuni.exam.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planes")
public class Plane extends BaseEntity {

    @Column(name = "register_number", nullable = false, unique = true)
    @Size(min = 5)
    private String registerNumber;

    @Column(nullable = false)
    @Min(1)
    private int capacity;

    @Column(nullable = false)
    @Size(min = 2)
    private String airline;

}
