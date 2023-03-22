package _09_JavaOOPExam_11December2021.catHouse.entities.houses;

import _09_JavaOOPExam_11December2021.catHouse.entities.toys.Toy;
import _09_JavaOOPExam_11December2021.catHouse.entities.cat.Cat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static _09_JavaOOPExam_11December2021.catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static _09_JavaOOPExam_11December2021.catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int sumSoftness() {

        return this.toys
                .stream()
                .mapToInt(Toy::getSoftness)
                .sum();
    }

    @Override
    public void addCat(Cat cat) {

        if (this.cats.size() >= this.capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:", name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Cats: ").append(String.format(this.cats.isEmpty()
                        ? "none"
                        : "%s", this.cats.stream().map(Cat::getName).collect(Collectors.joining(" "))))
                .append(System.lineSeparator());
        sb.append(String.format("Toys: %d Softness: %d", this.toys.size(), sumSoftness())).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
