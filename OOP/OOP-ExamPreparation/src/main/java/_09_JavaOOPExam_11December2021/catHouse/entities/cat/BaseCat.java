package _09_JavaOOPExam_11December2021.catHouse.entities.cat;

import static _09_JavaOOPExam_11December2021.catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    protected BaseCat(String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        this.kilograms = 0;
        setPrice(price);
    }

    @Override
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CAT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setBreed(String breed) {

        if (breed == null || breed.trim().isEmpty()) {
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.breed = breed;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    private void setPrice(double price) {

        if (price <= 0) {
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void eating() {
    }
}
