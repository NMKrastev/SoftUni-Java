import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A3_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        int numberOfGuests = Integer.parseInt(scanner.nextLine());

        addingGuests(scanner, names, numberOfGuests);
        printNames(names);
    }

    private static void printNames(List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static List<String> addingGuests(Scanner scanner, List<String> names, int numberOfGuests) {


        for (int i = 0; i < numberOfGuests; i++) {
            String input = scanner.nextLine();
            String[] line = input.split(" ");
            String name = line[0];

            if (!names.contains(name) && input.equals(name + " is not going!")) {
                System.out.printf("%s is not in the list!\n", name);
            } else if (names.contains(name) && input.equals(name + " is going!")) {
                System.out.printf("%s is already in the list!\n", name);
            } else if (names.contains(name) && input.equals(name + " is not going!")) {
                names.removeAll(Collections.singleton(name));
            } else if (!names.contains(name) && input.equals(name + " is going!")) {
                names.add(name);
            }
        }
        return names;
    }
}
/*Write a program that keeps track of guests going to a house party.
On the first input line, you are going to receive how many commands you are going to have.
On the next lines you are going to receive some of the following inputs:
•	"{name} is going!"
•	"{name} is not going!"
If you receive the first type of input, you have to add the person if he/she is not on the list.
If he/she is in the list, print on the console: "{name} is already in the list!".
If you receive the second type of input, you must remove the person if he/she is on the list.
If not, print: "{name} is not in the list!". In the end, print all guests.
*/