package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "light_years", nullable = false)
    private double lightYears;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "star_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StarType starType;

    @OneToMany(mappedBy = "observingStar", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Set<Astronomer> observers;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Constellation constellation;
}
