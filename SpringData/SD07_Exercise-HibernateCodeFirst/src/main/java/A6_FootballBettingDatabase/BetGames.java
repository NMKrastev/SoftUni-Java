package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGames {

    @EmbeddedId
    private GameBetId id;
    @ManyToOne
    @MapsId("gameId")
    private Game game;
    @ManyToOne
    @MapsId("betId")
    private Bet bet;
    @OneToOne
    @JoinColumn(name = "result_prediction")
    private ResultPrediction result;

    public BetGames() {}
}
