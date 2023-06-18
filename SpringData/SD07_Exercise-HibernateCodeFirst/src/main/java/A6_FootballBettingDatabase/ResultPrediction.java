package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String prediction;
}
