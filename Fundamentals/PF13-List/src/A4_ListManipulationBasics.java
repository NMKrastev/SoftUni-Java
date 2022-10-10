import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A4_ListManipulationBasics {
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
            int number;
            int index;
            switch (command[0]) {
                case "Add":
                    number = Integer.parseInt(command[1]);
                    numsList = addNumberToTheEnd(numsList, number);
                    break;
                case "Remove":
                    number = Integer.parseInt(command[1]);
                    numsList = removeNumberFromList(numsList, number);
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(command[1]);
                    numsList = removeNumberAtIndex(numsList, index);
                    break;
                case "Insert":
                    number = Integer.parseInt(command[1]);
                    index = Integer.parseInt(command[2]);
                    numsList = insertNumberAtGivenIndex(numsList, number, index);
                    break;
            }
        }
        return numsList;
    }

    private static List<Integer> addNumberToTheEnd(List<Integer> numsList, int number) {

        numsList.add(number);
        return numsList;
    }

    private static List<Integer> removeNumberFromList(List<Integer> numsList, int number) {

        numsList.removeAll(Arrays.asList(number));
        return numsList;
    }

    private static List<Integer> removeNumberAtIndex(List<Integer> numsList, int index) {

        numsList.remove(numsList.get(index));

        return numsList;
    }

    private static List<Integer> insertNumberAtGivenIndex(List<Integer> numsList, int number, int index) {

        numsList.add(index, number);

        return numsList;
    }
}
/*Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
Add {number}: add a number to the end of the list
Remove {number}: remove a number from the list
RemoveAt {index}: remove a number at a given index
Insert {number} {index}: insert a number at a given index
Note: All the indices will be valid!
When you receive the "end" command, print the final state of the list (separated by spaces).
*/