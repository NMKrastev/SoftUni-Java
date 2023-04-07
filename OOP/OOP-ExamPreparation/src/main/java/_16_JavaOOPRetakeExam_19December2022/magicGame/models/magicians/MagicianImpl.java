package _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians;

import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magics.Magic;

import static _16_JavaOOPRetakeExam_19December2022.magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician{
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setAlive();
        setMagic(magic);
    }

    private void setUsername(String username) {

        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }

        this.username = username;
    }

    private void setHealth(int health) {

        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }

        this.health = health;
    }

    private void setProtection(int protection) {

        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }

        this.protection = protection;
    }

    private void setAlive() {
        isAlive = this.health > 0;
    }

    private void setMagic(Magic magic) {

        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }

        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {

        if (points > this.protection) {
            points -= this.protection;
            this.protection = 0;
        } else {
            this.protection -= points;
            points = 0;
        }

        this.health -= points;

        if (this.health < 0) {
            this.health = 0;
        }

        if (this.health == 0) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %s", getClass().getSimpleName(), this.username)).append(System.lineSeparator());
        sb.append(String.format("Health: %d", this.health)).append(System.lineSeparator());
        sb.append(String.format("Protection: %d", this.protection)).append(System.lineSeparator());
        sb.append(String.format("Magic: %s", this.magic.getName())).append(System.lineSeparator());


        return sb.toString();
    }
}