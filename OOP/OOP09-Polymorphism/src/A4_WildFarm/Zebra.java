package A4_WildFarm;

public class Zebra extends Mammal {

    protected Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Vegetable) {
            setFoodEaten(food.getQuantity() + getFoodEaten());
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
