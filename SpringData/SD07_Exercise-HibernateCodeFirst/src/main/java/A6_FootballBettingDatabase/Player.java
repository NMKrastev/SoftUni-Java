package A6_FootballBettingDatabase;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(name = "squad_number")
    private Integer squadNumber;
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToOne
    private Position position;
    @Column(name = "is_injured", columnDefinition = "BOOLEAN")
    private Boolean isInjured;

    public Player() {
    }
}
