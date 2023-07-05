package hiberspring.domain.entities;

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
@Table(name = "branches")
public class Branch extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "branch")
    private Set<Employee> employees;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Fetch(FetchMode.JOIN)
    private Town town;

    @OneToMany(mappedBy = "branch")
    @Fetch(FetchMode.JOIN)
    private Set<Product> products;
}
