package softuni.exam.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;

    @Column(nullable = false)
    @Min(1)
    private int population;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String guide;
}
