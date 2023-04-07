package _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians;

import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
