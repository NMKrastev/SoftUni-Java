package A4_FoodShortage;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyers = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Buyer buyer;

            if (data.length == 4) {
                String id = data[2];
                String birthDate = data[3];
                buyer = new Citizen(name, age, id, birthDate);
            } else {
                String group = data[2];
                buyer = new Rebel(name, age, group);
            }

            buyers.put(name, buyer);
        }

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            final String name = input;
            buyers.entrySet().stream()
                    .filter(e -> e.getKey().equals(name))
                    .forEach(e -> e.getValue().buyFood());
        }

        System.out.println(buyers.values().stream()
                .mapToInt(Buyer::getFood).sum());
    }
}
/*Your totalitarian dystopian society suffers a shortage of food, so many rebels appear.
Extend the code from your previous (Problem 2. Multiple Implementation) tasks with new functionality to solve this task.
Define a class Rebel which has a name, age, and group (String), names are unique -
there will never be 2 Rebels/Citizens or a Rebel and Citizen with the same name. Define an interface Buyer
which defines the methods buyFood() and a getFood(). Implement the Buyer interface in the Citizen and Rebel class,
both Rebels and Citizens start with 0 food, when a Rebel buys food his food increases by 5,
when a Citizen buys food his food increases by 10.
On the first line of the input you will receive an integer N - the number of people, on each of the next N lines
you will receive information in one of the following formats "{name} {age} {id} {birthdate}" for a Citizen or
"{name} {age}{group}" for a Rebel. After the N lines, until the command "End" is received, you will receive
names of people who bought food, each on a new line. Note that not all names may be valid,
in the case of an incorrect name - nothing should happen.
On the only line of output, you should print the total amount of food purchased.

<<Interface>>
Buyer
+	buyFood(): void
+	getFood(): int

<<Interface>>
Identifiable
+	getId(): String

<<Interface>>
Person
+	getName(): String
+	getAge(): int

-------------------------------------------------------

Citizen
-	name: String
-	age: int
-	id: String
-	birthDate: String
-	food: int
+	Citizen(String, int, String, String)
+	getName(): String
+	getAge(): int
+	getId(): String
+	getFood(): int
+	buyFood(): void
Rebel
-	name: String
-	age: int
-	group: String
-	food: int
+	Rebel(String, int, String)
+	getName(): String
+	getAge(): int
+	getGroup(): String
+	getFood(): int
+	buyFood(): void
*/
