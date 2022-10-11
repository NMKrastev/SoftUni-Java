import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A4_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        distribution(scanner, numsList);
        printList(numsList);

    }

    private static void printList(List<Integer> numsList) {
        for (int num : numsList) {
            System.out.printf("%d ", num);
        }
    }

    private static List<Integer> distribution(Scanner scanner, List<Integer> numsList) {

        String input = "";
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] command = input.split(" ");

            int number;
            int index;
            switch (command[0]) {
                case "Add":
                    number = Integer.parseInt(command[1]);
                    numsList = addNumberAtTheEnd(numsList, number);
                    break;
                case "Insert":
                    number = Integer.parseInt(command[1]);
                    index = Integer.parseInt(command[2]);
                    if (isValidIndex(numsList.size(), index)) {
                        numsList = insertNumberAtIndex(numsList, number, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(command[1]);
                    if (isValidIndex(numsList.size(), index)) {
                        numsList = removeIndex(numsList, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    if (command[1].equals("left")) {
                        numsList = shiftLeft(numsList, count);
                    } else {
                        numsList = shiftRight(numsList, count);
                    }
                    break;
            }
        }
        return numsList;
    }

    private static boolean isValidIndex(int size, int index) {
        return (index >= 0 && index < size);
    }

    private static List<Integer> shiftRight(List<Integer> numsList, int count) {

        for (int i = 0; i < count; i++) {
            int lastNum = numsList.get(numsList.size() - 1);
            numsList.add(0, lastNum);
            numsList.remove(numsList.size() - 1);
        }
        return numsList;
    }

    private static List<Integer> shiftLeft(List<Integer> numsList, int count) {

        for (int i = 0; i < count; i++) {
            int firstNum = numsList.get(0);
            numsList.add(firstNum);
            numsList.remove(0);
        }
        return numsList;
    }

    private static List<Integer> removeIndex(List<Integer> numsList, int index) {

        numsList.remove(index);
        return numsList;
    }

    private static List<Integer> insertNumberAtIndex(List<Integer> numsList, int number, int index) {

        numsList.add(index, number);
        return numsList;
    }

    private static List<Integer> addNumberAtTheEnd(List<Integer> numsList, int number) {

        numsList.add(number);
        return numsList;
    }
}
/*You will be given numbers (a list of integers) on the first input line.
Until you receive "End" you will be given operations you must apply on the list. The possible commands are:
•	Add {number} - add number at the end
•	Insert {number} {index} - insert number at given index
•	Remove {index} - remove that index
•	Shift left {count} - first number becomes last 'count' times
•	Shift right {count} - last number becomes first 'count' times
Note: The index given may be outside the array's bounds. In that case, print "Invalid index".
*/