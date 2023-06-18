package A6_FootballBettingDatabase;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameBetId implements Serializable {

    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "bet_id")
    private Integer betId;

    public GameBetId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        GameBetId that = (GameBetId) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(betId, that.betId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, betId);
    }

}
