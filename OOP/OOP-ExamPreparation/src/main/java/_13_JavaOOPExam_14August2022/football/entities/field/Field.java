package _13_JavaOOPExam_14August2022.football.entities.field;

import _13_JavaOOPExam_14August2022.football.entities.supplement.Supplement;
import _13_JavaOOPExam_14August2022.football.entities.player.Player;

import java.util.Collection;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo();

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
