package JavaOOPRetakeExam_19December2020.viceCity.models.players;

import JavaOOPRetakeExam_19December2020.viceCity.models.guns.Gun;
import JavaOOPRetakeExam_19December2020.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
