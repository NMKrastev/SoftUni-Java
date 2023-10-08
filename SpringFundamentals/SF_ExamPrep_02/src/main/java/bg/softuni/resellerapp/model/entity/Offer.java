package bg.softuni.resellerapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Condition condition;

    @ManyToOne(fetch = FetchType.EAGER)
    private User seller;

    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;
}
