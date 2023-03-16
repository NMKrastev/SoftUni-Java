package _05_JavaOOPExam_10April2021.aquarium.repositories;

import _05_JavaOOPExam_10April2021.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
