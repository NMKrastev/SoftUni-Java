package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long population;

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Branch> branches;
}
