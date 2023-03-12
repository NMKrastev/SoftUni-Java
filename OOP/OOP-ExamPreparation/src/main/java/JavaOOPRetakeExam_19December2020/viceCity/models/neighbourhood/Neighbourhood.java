package JavaOOPRetakeExam_19December2020.viceCity.models.neighbourhood;

import JavaOOPRetakeExam_19December2020.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
