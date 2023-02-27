package A4_WildFarm;

public abstract class Mammal extends Animal {

    protected String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public abstract void makeSound();

    @Override
    public abstract void eat(Food food);

    @Override
    public String toString() {
        return String.format("%s %s, %d]", super.toString(), livingRegion, foodEaten);
    }
}
