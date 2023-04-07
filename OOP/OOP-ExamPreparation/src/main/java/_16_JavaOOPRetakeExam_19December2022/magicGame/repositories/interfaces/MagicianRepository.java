package _16_JavaOOPRetakeExam_19December2022.magicGame.repositories.interfaces;

import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
