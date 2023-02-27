package wildFarm;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Animal> animalsList = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();

        String input;

        while (!(input = scanner.nextLine()).equals("End")) {

            String[] animalData = input.split("\\s+");
            String animalType = animalData[0];
            String animalName = animalData[1];
            Double weight = Double.valueOf(animalData[2]);
            String livingRegion = animalData[3];

            Animal animal;
            switch (animalType) {
                case "Cat":
                    String catBreed = animalData[4];
                    animal = new Cat(animalName, animalType, weight, livingRegion, catBreed);
                    animalsList.add(animal);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, weight, livingRegion);
                    animalsList.add(animal);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, weight, livingRegion);
                    animalsList.add(animal);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, weight, livingRegion);
                    animalsList.add(animal);
                    break;
            }

            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = getFoodType(foodData);
            foodList.add(food);
        }

        printResult(animalsList, foodList);
    }

    private static void printResult(List<Animal> animalsList, List<Food> foodList) {

        for (int i = 0; i < animalsList.size(); i++) {
            animalsList.get(i).makeSound();
            animalsList.get(i).eat(foodList.get(i));
        }

        for (Animal animal : animalsList) {
            System.out.println(animal);
        }
    }

    private static Food getFoodType(String[] foodData) {

        Food food = null;
        String foodType = foodData[0];
        Integer quantity = Integer.valueOf(foodData[1]);

        if (foodType.equals("Meat")) {
            food = new Meat(quantity);
        } else if (foodType.equals("Vegetable")) {
            food = new Vegetable(quantity);
        }

        return food;
    }
}
