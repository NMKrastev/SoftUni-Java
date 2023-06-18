package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "competition_type")
    private CompetitionType competitionType;

    public Competition() {
    }
}
