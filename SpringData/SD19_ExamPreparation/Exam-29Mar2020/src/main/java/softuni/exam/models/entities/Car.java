package softuni.exam.models.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 3, max = 19)
    private String make;

    @Column(nullable = false)
    @Size(min = 3, max = 19)
    private String model;

    @Column(nullable = false)
    @Min(1)
    private Long kilometers;

    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;

    @OneToMany(targetEntity = Picture.class, mappedBy = "car")
    @Fetch(FetchMode.JOIN)
    private Set<Picture> pictures;

    @OneToMany(targetEntity = Offer.class, mappedBy = "car")
    @Fetch(FetchMode.JOIN)
    private Set<Offer> offer;
}
