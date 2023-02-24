package A5_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input;

        while (!(input = scanner.nextLine()).equals("End")) {

            String[] data = input.split("\\s+");

            Identifiable identifiable;

            if (data.length == 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                identifiable = new Citizen(name, age, id);
            } else {
                String model = data[0];
                String id = data[1];
                identifiable = new Robot(model, id);
            }

            identifiables.add(identifiable);
        }

        String fakeId = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeId))
                .forEach(System.out::println);
    }
}
/*It’s the future, you’re the ruler of a totalitarian dystopian society inhabited by citizens and robots,
since you’re afraid of rebellions you decide to implement strict control of who enters your city.
Your soldiers check the Ids of everyone who enters and leaves.
You will receive from the console an unknown amount of lines until the command "End" is received, on each line,
there will be the information for either a citizen or a robot who tries to enter your city in the format
"{name} {age} {id}" for citizens and "{model} {id}" for robots.
After the end command on the next line, you will receive a single number representing the last digits of fake ids,
all citizens or robots whose Id ends with the specified digits must be detained.
The output of your program should consist of all detained Ids each on a separate line (the order of printing doesn’t matter).

                                <<Interface>>
                                Identifiable
                              ^            ^
                            /                \
                          /                    \
                        /                        \
  Robot                                             Citizen
  -	id: String                                      -	name: String
  -	model: String                                   -	model: String
  +	Robot(String, String)                           -	id: String
  +	getId(): String                                 +	Citizen(String, int, String)
  +	getModel(): String                              +	getName(): String
                                                    +	getAge(): int
                                                    +	getId(): String
*/
