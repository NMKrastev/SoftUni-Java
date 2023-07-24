package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity {

    @Column(name = "apartment_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ApartmentType apartmentType;

    @Column(nullable = false)
    private double area;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Fetch(FetchMode.JOIN)
    private Town town;
}
