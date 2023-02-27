package A4_WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {

    protected String animalName;
    protected String animalType;
    protected Double animalWeight;
    protected Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        setAnimalName(animalName);
        setAnimalType(animalType);
        setAnimalWeight(animalWeight);
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    abstract void makeSound();

    abstract void eat(Food food);

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s[%s, %s,", animalType, animalName, df.format(animalWeight));
    }
}
