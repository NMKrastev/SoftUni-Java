package A4_WildFarm;

public class Tiger extends Felime {

    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Meat) {
            setFoodEaten(food.getQuantity() + getFoodEaten());
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
