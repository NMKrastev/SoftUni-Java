import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        distribution(scanner, numsList);
        printList(numsList);

    }

    private static void printList(List<Integer> numsList) {

        for (int num : numsList) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> distribution(Scanner scanner, List<Integer> numsList) {

        String input = "";

        while (!(input = scanner.nextLine()).equals("end")) {

            String[] command = input.split(" ");
            switch (command[0]) {
                case "Delete":
                    int delete = Integer.parseInt(command[1]);
                    deleteAllCertainElementsFromList(numsList, delete);
                    break;
                case "Insert":
                    int number = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
                    insertElementAtIndex(numsList, number, index);
                    break;
            }
        }
        return numsList;
    }

    private static List<Integer> insertElementAtIndex(List<Integer> numsList, int number, int index) {

        numsList.add(index, number);
        return numsList;
    }

    private static List<Integer> deleteAllCertainElementsFromList(List<Integer> numsList, int delete) {

        numsList.removeAll(Arrays.asList(delete));
        return numsList;
    }
}
/*Write a program that reads a list of integers from the console and receives commands which manipulate the list.
Your program may receive the following commands:
•	Delete {element} - delete all elements in the array which are equal to the given element
•	Insert {element} {position} - insert element at the given position
You should stop the program when you receive the command "end". Print all numbers in the array,
separated with a single whitespace.
*/