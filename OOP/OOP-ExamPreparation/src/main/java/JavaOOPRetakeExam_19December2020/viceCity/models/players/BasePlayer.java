package JavaOOPRetakeExam_19December2020.viceCity.models.players;

import JavaOOPRetakeExam_19December2020.viceCity.models.guns.Gun;
import JavaOOPRetakeExam_19December2020.viceCity.repositories.interfaces.GunRepository;
import JavaOOPRetakeExam_19December2020.viceCity.repositories.interfaces.Repository;

import static JavaOOPRetakeExam_19December2020.viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;
import static JavaOOPRetakeExam_19December2020.viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;

public abstract class BasePlayer implements Player {

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints -= points;
    }
}
