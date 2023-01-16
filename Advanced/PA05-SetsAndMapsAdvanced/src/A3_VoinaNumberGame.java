import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         LinkedHashSet<Integer> playerOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                 .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> playerTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;
         while (round-- > 0) {

            int firstCard = playerOne.iterator().next();
            playerOne.remove(firstCard);

             int secondCard = playerTwo.iterator().next();
             playerTwo.remove(secondCard);

             if (firstCard > secondCard) {
                 playerOne.add(firstCard);
                 playerOne.add(secondCard);
             } else if (secondCard > firstCard) {
                 playerTwo.add(firstCard);
                 playerTwo.add(secondCard);
             }

             if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                 break;
             }
         }

         if (playerOne.size() > playerTwo.size()) {
             System.out.println("First player win!");
         } else if (playerTwo.size() > playerOne.size()) {
             System.out.println("Second player win!");
         } else {
             System.out.println("Draw!");
         }
    }
}
/*Write a program that:
•	Reads 20 numbers for both players, separated with " " (single space).
o	Every player can hold unique numbers.
Each Round, both players get the top number from their deck.
The player with the bigger number gets both numbers and adds them to the bottom of his sequence.
The game ends after 50 rounds or if any player loses all of his numbers.
Input
•	Numbers – Integer
Output
•	Output must be "First player win!", "Second player win!" or "Draw!".
*/
