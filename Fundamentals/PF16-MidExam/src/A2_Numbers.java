import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numsList = distribution(scanner, numsList);
        printNumsList(numsList);
    }

    private static void printNumsList(List<Integer> numsList) {
        System.out.println(numsList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> distribution(Scanner scanner, List<Integer> numsList) {

        String command = "";

        while (!(command = scanner.nextLine()).equals("Finish")) {

            if (command.contains("Add")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                numsList = addValueAtTheEnd(numsList, value);
            } else if (command.contains("Remove")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                numsList = removeFirstOccurrenceOfValue(numsList, value);
            } else if (command.contains("Replace")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                int replacement = Integer.parseInt(command.split(" ")[2]);
                numsList = replaceFirstOccurrenceOfValue(numsList, value, replacement);
            } else if (command.contains("Collapse")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                numsList = removeElementsLessThanValue(numsList, value);
            }
        }
        return numsList;
    }

    private static List<Integer> removeElementsLessThanValue(List<Integer> numsList, int value) {

        for (int i = 0; i < numsList.size(); i++) {
            if (value > numsList.get(i)){
                numsList.remove(numsList.get(i));
                i--;
            }
        }
        return numsList;
    }

    private static List<Integer> replaceFirstOccurrenceOfValue(List<Integer> numsList, int value, int replacement) {

        if (numsList.contains(value)) {
            int index = numsList.indexOf(value);
            numsList.set(index, replacement);
        }
        return numsList;
    }

    private static List<Integer> removeFirstOccurrenceOfValue(List<Integer> numsList, int value) {

        if (numsList.contains(value)) {
            int index = numsList.indexOf(value);
            numsList.remove(numsList.get(index));
        }
        return numsList;
    }

    private static List<Integer> addValueAtTheEnd(List<Integer> numsList, int value) {

        numsList.add(value);
        return numsList;
    }
}
/*You are given numbers in a sequence on a single line, separated by a space. After that, you will receive commands
that modify the sequence differently:
•	"Add {value} " - you should add the given value to the end of the sequence.
•	"Remove {value}" - you should remove the first occurrence of the given value if there is such.
•	"Replace {value} {replacement }" - you should replace the first occurrence of the given value with the
replacement if there is such occurrence.
•	"Collapse {value}" you must remove each number with a value less than the given one.
When you receive the command "Finish", you should print the modified sequence and end the program.
Input / Constraints:
•	On the first line, you will receive a sequence with numbers, separated by spaces - integers in the range
[-1000...1000).
•	On the following lines, you will receive commands until the "Finish" command is received.
•	The commands will always be valid.
Output:
•	Print a single line the array of numbers separated by a space, wit h the modified values.
*/