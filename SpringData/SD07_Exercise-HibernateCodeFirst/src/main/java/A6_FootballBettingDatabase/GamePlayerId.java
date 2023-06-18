package A6_FootballBettingDatabase;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamePlayerId implements Serializable {

    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "player_id")
    private Integer playerId;

    public GamePlayerId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        GamePlayerId that = (GamePlayerId) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playerId);
    }
}
