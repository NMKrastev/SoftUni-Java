package _12_JavaOOPRetakeExam_18April2022.zoo.entities.areas;

import _12_JavaOOPRetakeExam_18April2022.zoo.entities.animals.Animal;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static _12_JavaOOPRetakeExam_18April2022.zoo.common.ConstantMessages.AREA_NOT_SUITABLE;
import static _12_JavaOOPRetakeExam_18April2022.zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static _12_JavaOOPRetakeExam_18April2022.zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(this.animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(this.foods);
    }

    @Override
    public int sumCalories() {

        return this.foods
                .stream()
                .mapToInt(Food::getCalories)
                .sum();
    }

    @Override
    public void addAnimal(Animal animal) {

        if (this.animals.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        if (getClass().getSimpleName().equals("WaterArea") && !animal.getClass().getSimpleName().equals("AquaticAnimal")
                || getClass().getSimpleName().equals("LandArea") && !animal.getClass().getSimpleName().equals("TerrestrialAnimal")) {
            throw new IllegalArgumentException(AREA_NOT_SUITABLE);
        }

        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s (%s):", this.name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Animals: %s",
                String.format(this.animals.isEmpty()
                        ? "none"
                        : this.animals.stream().map(Animal::getName).collect(Collectors.joining(" ")))))
                .append(System.lineSeparator());
        sb.append(String.format("Foods: %d", this.foods.size())).append(System.lineSeparator());
        sb.append(String.format("Calories: %d", this.sumCalories()));

        return sb.toString().trim();
    }
}
