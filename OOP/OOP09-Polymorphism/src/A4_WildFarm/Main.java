package A4_WildFarm;

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
/*Your task is to create a class hierarchy like the picture below.
All the classes except Vegetable, Meat, Mouse, Tiger, Cat & Zebra should be abstract.
Input should be read from the console. Every even line will contain information about the Animal in following format:
"{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}".
If the animai is a cat: "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}".
On the odd lines, you will receive information about the food that you should give to the Animal.
The line will consist of FoodType and quantity separated by whitespace.
You should build the logic to determine if the animal is going to eat the provided food.
The Mouse and Zebra should check if the food is Vegetable. If it is they will eat it.
Otherwise, you should print a message in the format:
"{AnimalType} are not eating that type of food!". AnimalType to be in the plural.
Cats eat any kind of food, but Tigers accept only Meat. If a Vegetable is provided to a tiger
message like the one above should be printed on the console.
After you read information about the Animal and Food then invoke makeSound() method
of the current animal and then feed it. In the end, print the whole object in the format:
"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
If the animal is a cat: "{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
Proceed to read information about the next animal/food. The input will continue until you receive "End".
Print all AnimalWeight with two digits after the decimal separator. Use the DecimalFormat class.
Note: consider overriding toString() method.
*/
