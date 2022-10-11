import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int capacityOfSeats = Integer.parseInt(scanner.nextLine());

        wagons = fillWagons(scanner, wagons, capacityOfSeats);
        printWagonsState(wagons);

    }

    private static void printWagonsState(List<Integer> wagons) {
        for (int num : wagons) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> fillWagons(Scanner scanner, List<Integer> wagons, int capacityOfSeats) {

        String input = "";

        while (!(input = scanner.nextLine()).equals("end")) {

            String[] command = input.split(" ");
            int people = 0;
            if (command[0].equals("Add")) {
                int wagon = Integer.parseInt(command[1]);
                wagons.add(wagon);
            } else {
                people = Integer.parseInt(command[0]);
                wagons = searchForSeats(wagons, people, capacityOfSeats);
            }


        }
        return wagons;
    }

    private static List<Integer> searchForSeats(List<Integer> wagons, int people, int capacityOfSeats) {

        for (int i = 0; i < wagons.size(); i++) {

            if (wagons.get(i) + people <= capacityOfSeats) {
                wagons.set(i, wagons.get(i) + people);
                break;
            }
        }
        return wagons;
    }
}
/*On the first line, you will be given a list of wagons (integers). Each integer represents the number of passengers
that are currently in each wagon. On the next line, you will get the max capacity of each wagon (single integer).
Until you receive "end" you will be given two types of input:
•	Add {passengers} - add a wagon to the end with the given number of passengers
•	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
In the end, print the final state of the train (all the wagons separated by a space)
*/