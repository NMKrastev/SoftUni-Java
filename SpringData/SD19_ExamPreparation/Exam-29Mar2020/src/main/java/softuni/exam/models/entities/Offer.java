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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    @Min(1)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(min = 5)
    private String description;

    @Column(name = "has_gold_status", nullable = false)
    private boolean hasGoldStatus;

    @Column(name = "added_on", nullable = false)
    private LocalDateTime addedOn;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Car car;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Seller seller;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Picture> pictures;
}
