package A3_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] info = input.split("\\s+");
            String type = info[0];
            String name = info[1];

            Birthable birthable;

            switch (type) {
                case "Citizen":
                    int age = Integer.parseInt(info[2]);
                    String citizenId = info[3];
                    String citizenBirthDate = info[4];
                    birthable = new Citizen(name, age, citizenId, citizenBirthDate);
                    birthableList.add(birthable);
                    break;
                case "Pet":
                    String petBirthDate = info[2];
                    birthable = new Pet(name, petBirthDate);
                    birthableList.add(birthable);
                    break;
            }
        }

        String searchedDate = scanner.nextLine();

        System.out.println(birthableList.stream()
                .map(Birthable::getBirthDate)
                .filter(p -> p.endsWith(searchedDate))
                .collect(Collectors.toList()).size() == 0
                ? "<no output>"
                : String.format("%s", birthableList.stream()
                .map(Birthable::getBirthDate)
                .filter(e -> e.endsWith(searchedDate))
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()))));

    }
}
/*It is a well-known fact that people celebrate birthdays, it is also known that some people also celebrate
their pet's birthdays. Extend the program from your last task to add birthdates to citizens and include a class Pet,
pets have a name and a birthdate. Also, create a class Robot that has an id and model. Encompass repeated
functionality into interfaces and implement them in your classes.
You will receive from the console an unknown amount of lines until the command "End" is received,
each line will contain information in one of the following formats "Citizen {name} {age} {id} {birthdate}" for citizens,
"Robot {model} {id}" for robots or "Pet {name} {birthdate}" for pets. After the end command on the next line,
you will receive a single number representing a specific year, your task is to print all birthdates
(of both citizens and pets) in that year in the format "{day}/{month}/{year}" (the order of printing doesn’t matter).

<<Interface>>
Identifiable
+	getId(): String

<<Interface>>
Birthable
+	getBirthDate(): String

--------------------------------------------

Citizen
-	name: String
-	age: int
-	id: String
-	birthDate: String
+	Citizen(String, int, String, String)
+	getName(): String
+	getAge(): int
+	getId(): String

Robot
-	id: String
-	model: String
+	Robot(String, String)
+	getId(): String
+	getModel(): String

Pet
-	name: String
-	birthDate: String
+	Pet(String, String)
+	getName(): String
+	getBirthDate(): String
*/
