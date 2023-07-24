package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "published_on")
    private LocalDate publishedOn;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Fetch(FetchMode.JOIN)
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Fetch(FetchMode.JOIN)
    private Agent agent;
}
