package softuni.exam.models.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    @Size(min = 3, max = 19)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3, max = 20)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Enumerated
    private RatingType rating;

    @Column(nullable = false)
    private String town;

    @OneToMany(targetEntity = Offer.class, mappedBy = "seller")
    @Fetch(FetchMode.JOIN)
    private Set<Offer> offers;
}
