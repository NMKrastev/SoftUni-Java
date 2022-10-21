import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        targetsList = distribution(scanner, targetsList);
        printTargetsList(targetsList);
    }

    private static void printTargetsList(List<Integer> targetsList) {

        System.out.println(targetsList.toString().replaceAll("[\\[\\],]", "")
                .replace(" ", "|"));
    }

    private static List<Integer> distribution(Scanner scanner, List<Integer> targetsList) {

        String input = "";

        while (!(input = scanner.nextLine()).equals("End")) {

            if (input.contains("Shoot")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int power = Integer.parseInt(input.split(" ")[2]);
                if (isValidIndex(targetsList, index)) {
                    targetsList = shootTarget(targetsList, index, power);
                }
            } else if (input.contains("Add")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int value = Integer.parseInt(input.split(" ")[2]);
                if (isValidIndex(targetsList, index)) {
                    targetsList = addValueToTargets(targetsList, index, value);
                } else {
                    printInvalidPlacement();
                }
            } else if (input.contains("Strike")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int radius = Integer.parseInt(input.split(" ")[2]);
                if (isValidIndex(targetsList, index, radius)) {
                    targetsList = strikeTargets(targetsList, index, radius);
                } else {
                    printMissedStrike();
                }
            }
        }
        return targetsList;
    }

    private static void printMissedStrike() {

        System.out.println("Strike missed!");
    }

    private static List<Integer> strikeTargets(List<Integer> targetsList, int index, int radius) {

        targetsList.subList(index - radius, index + radius + 1).clear();
        return targetsList;
    }

    private static void printInvalidPlacement() {

        System.out.println("Invalid placement!");
    }

    private static List<Integer> addValueToTargets(List<Integer> targetsList, int index, int value) {

        targetsList.add(index, value);
        return targetsList;
    }

    private static List<Integer> shootTarget(List<Integer> targetsList, int index, int power) {

        targetsList.set(index, targetsList.get(index) - power);
        if (targetsList.get(index) < 1) {
            targetsList.remove(targetsList.get(index));
        }
        return targetsList;
    }

    private static boolean isValidIndex(List<Integer> targetsList, int index) {

        return index >= 0 && index < targetsList.size();
    }

    private static boolean isValidIndex(List<Integer> targetsList, int index, int radius) {

        return index - radius >= 0 && index + radius < targetsList.size();
    }
}
/*You are at the shooting gallery again, and you need a program that helps you keep track of moving targets.
On the first line, you will receive a sequence of targets with their integer values, split by a single space.
Then, you will start receiving commands for manipulating the targets until the "End" command.
The commands are the following:
•"Shoot {index} {power}"
oShoot the target at the index if it exists by reducing its value by the given power (integer value).
oRemove the target if it is shot. A target is considered shot when its value reaches 0.
•"Add {index} {value}"
oInsert a target with the received value at the received index if it exists.
oIf not, print: "Invalid placement!"
•"Strike {index} {radius}"
oRemove the target at the given index and the ones before and after it depending on the radius.
oIf any of the indices in the range is invalid, print: "Strike missed!" and skip this command.
 Example:  "Strike 2 2"
{radius}{radius}{strikeIndex}{radius}{radius}

•"End"
oPrint the sequence with targets in the following format and end the program:
"{target1}|{target2}…|{targetn}"
Input / Constraints
•On the first line, you will receive the sequence of targets – integer values [1-10000].
•On the following lines, until the "End" will be receiving the command described above – strings.
•There will never be a case when the "Strike" command would empty the whole sequence.
Output
•Print the appropriate message in case of any command if necessary.
•In the end, print the sequence of targets in the format described above.
*/