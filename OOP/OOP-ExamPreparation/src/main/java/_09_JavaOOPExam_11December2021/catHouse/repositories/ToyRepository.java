package _09_JavaOOPExam_11December2021.catHouse.repositories;

import _09_JavaOOPExam_11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {

    private Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {

        return this.toys
                .stream()
                .filter(e -> e.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
