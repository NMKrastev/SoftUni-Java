package A6_Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Beast!")) {

            String[] animalInfo = scanner.nextLine().split("\\s+");
            String animalName = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            switch (input) {
                case "Cat":
                    try {
                        Cat cat = new Cat(animalName, age, gender);
                        animals.add(cat);
                    } catch (IllegalArgumentException e) {
                        printErrorMessage(e);
                    }
                    break;
                case "Tomcat":
                    try {
                        Tomcat tomcat = new Tomcat(animalName, age);
                        animals.add(tomcat);
                    } catch (IllegalArgumentException e) {
                        printErrorMessage(e);
                    }
                    break;
                case "Kitten":
                    try {
                        Kitten kitten = new Kitten(animalName, age);
                        animals.add(kitten);
                    } catch (IllegalArgumentException e) {
                        printErrorMessage(e);
                    }
                    break;
                case "Dog":
                    try {
                        Dog dog = new Dog(animalName, age, gender);
                        animals.add(dog);
                    } catch (IllegalArgumentException e) {
                        printErrorMessage(e);
                    }
                    break;
                case "Frog":
                    try {
                        Frog frog = new Frog(animalName, age, gender);
                        animals.add(frog);
                    } catch (IllegalArgumentException e) {
                        printErrorMessage(e);
                    }
                    break;
            }
        }

        animals.forEach(System.out::println);
    }

    private static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
/*NOTE: You need a public class Main.
Create a hierarchy (package) of animals. Your program should have three different animals –
Dog, Frog, and Cat. Deeper in the hierarchy you should have two additional classes – Kitten and Tomcat.
Kittens are "Female" and Tomcats are "Male". All types of animals should be able to produce some kind of sound -
String produceSound(). For example, the dog should be able to bark. Your task is to model the hierarchy
and test its functionality. Create an animal of each kind and make them all produce sound and create getters for all fields.
You will be given some lines of input. Every two lines will represent an animal. On the first line will be
the type of animal and on the second – the name, the age, and the gender. When the command "Beast!" is given,
stop the input and print all the animals in the format shown below.
Output
•	Print the information for each animal in three lines. On the first line, print: "{animalType}".
•	On the second line, print: "{name} {age} {gender}".
•	On the third line, print the sounds it produces: "{produceSound()}".
Constraints
•	Each Animal should have a name, an age, and a gender.
•	All input values should not be blank (e.g. name, age, and so on…).
•	If you receive an input for the gender of a Tomcat or a Kitten, ignore it but create the animal.
•	If the input is invalid for one of the properties, throw an exception with the message: "Invalid input!".
•	Each animal should have the functionality to produceSound().
•	Here is the type of sound each animal should produce:
o	Dog: "Woof!"
o	Cat: "Meow meow"
o	Frog: "Ribbit"
o	Kittens: "Meow"
o	Tomcat: "MEOW"
*/