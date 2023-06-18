package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity(name = "PlayerStatistics")
@Table(name = "player_statistics")
public class PlayerStatistic {

    @EmbeddedId
    private GamePlayerId id;
    @ManyToOne
    @MapsId("gameId")
    private Game game;
    @ManyToOne
    @MapsId("playerId")
    private Player player;
    @Column(name = "scored_goals")
    private Integer scoredGoals;
    @Column(name = "player_assists")
    private Integer playerAssists;
    @Column(name = "played_minutes")
    private Integer playedMinutes;

    public PlayerStatistic() {}
}
