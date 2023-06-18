package A6_FootballBettingDatabase;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToMany(targetEntity = Country.class, cascade = CascadeType.ALL)
    @JoinTable(name = "continents_countries",
            joinColumns = @JoinColumn(name = "continent_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries;

    public Continent() {
        this.countries = new HashSet<>();
    }

}
