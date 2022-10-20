import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> seqOfElementsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = "";
        int moves = 0;

        while (!(input = scanner.nextLine()).equals("end")) {

            int indexOne = Integer.parseInt(input.split("\\s+")[0]);
            int indexTwo = Integer.parseInt(input.split("\\s+")[1]);
            boolean isValidIndex = isValidIndex(indexOne, indexTwo, seqOfElementsList);

            if (isValidIndex) {
                if (seqOfElementsList.get(indexOne).equals(seqOfElementsList.get(indexTwo))) {
                    moves++;
                    System.out.printf("Congrats! You have found matching elements - %s!\n", seqOfElementsList.get(indexOne));
                    seqOfElementsList.removeAll(Collections.singleton(seqOfElementsList.get(indexOne)));
                    if (seqOfElementsList.size() == 0) {
                        break;
                    }
                } else {
                    moves++;
                    System.out.println("Try again!");
                }
            } else {
                moves++;
                String letter = "a";
                seqOfElementsList.add(seqOfElementsList.size() / 2,
                        -moves + letter);
                seqOfElementsList.add(seqOfElementsList.size() / 2 + 1,
                        -moves + letter);
                System.out.println("Invalid input! Adding additional elements to the board");
            }
        }

        if (seqOfElementsList.size() > 0) {
            System.out.println("Sorry you lose :(");
            System.out.println(seqOfElementsList.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.printf("You have won in %d turns!", moves);
        }
    }

    private static boolean isValidIndex(int indexOne, int indexTwo, List<String> seqOfElementsList) {

        if (indexOne > -1 && indexTwo > -1 && indexOne != indexTwo && indexOne < seqOfElementsList.size()
                && indexTwo < seqOfElementsList.size()) {
            return true;
        }
        return false;
    }
}
/*Write a program that recreates the Memory game.
On the first line, you will receive a sequence of elements. Each element in the sequence will have a twin.
Until the player receives "end" from the console, you will receive strings with two integers separated by a space,
representing the indexes of elements in the sequence.
If the player tries to cheat and enters two equal indexes or indexes which are out of bounds of the sequence,
you should add two matching elements at the middle of the sequence in the following format:
"-{number of moves until now}a"
Then print this message on the console:
"Invalid input! Adding additional elements to the board"
Input
•	On the first line, you will receive a sequence of elements
•	On the following lines, you will receive integers until the command "end"
Output
•	Every time the player hit two matching elements, you should remove them from the sequence and print on the console
the following message:
"Congrats! You have found matching elements - ${element}!"
•	If the player hit two different elements, you should print on the console the following message:
"Try again!"
•	If the player hit all matching elements before he receives "end" from the console, you should print on the console
the following message:
"You have won in {number of moves until now} turns!"
•	If the player receives "end" before he hits all matching elements, you should print on the console the
following message:
"Sorry you lose :(
{the current sequence's state}"
Constraints
•	All elements in the sequence will always have a matching element.
*/