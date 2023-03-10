package JavaOOPExam_12December2020.bakery.entities.drinks;

import JavaOOPExam_12December2020.bakery.entities.drinks.interfaces.Drink;

import static JavaOOPExam_12December2020.bakery.common.ExceptionMessages.*;

public abstract class BaseDrink implements Drink {

    private String name;
    private int portion;
    private double price;
    private String brand;

    protected BaseDrink(String name, int portion, double price, String brand) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
        this.setBrand(brand);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    @Override
    public int getPortion() {
        return this.portion;
    }

    private void setPortion(int portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }

        this.portion = portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }

        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv", this.getName(), this.getBrand(), this.getPortion(), this.getPrice());
    }
}
