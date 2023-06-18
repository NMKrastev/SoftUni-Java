package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity
@Table(name = "rounds")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    public Round() {}
}
