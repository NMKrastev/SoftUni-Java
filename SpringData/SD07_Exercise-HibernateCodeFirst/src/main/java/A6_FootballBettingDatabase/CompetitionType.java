package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity
@Table(name = "competition_type")
public class CompetitionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column
    private CompetitionTypes name;

    public CompetitionType() {}
}
