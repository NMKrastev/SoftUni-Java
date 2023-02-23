package A1_Person;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Child child = new Child(name, age);

        System.out.println(child.getName());
        System.out.println(child.getAge());
    }
}
/*NOTE: You need a public class Main. Create a package person.
You are asked to model an application for storing data about people.
You should be able to have a Person and a Child. The child derives from the person.
Every person has a name and an age. Your task is to model the application.
The Person class also has getters for the fields.
Create a Child class that inherits Person and has the same public constructor definition.
However, do not copy the code from the Person class - reuse the Person class's constructor.
*/
