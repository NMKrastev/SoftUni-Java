import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A6_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOneDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwoDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String result = playGame(playerOneDeck, playerTwoDeck);
        System.out.println(result);

    }

    private static String playGame(List<Integer> playerOneDeck, List<Integer> playerTwoDeck) {

        boolean playerOneWins = false;
        boolean playerTwoWins = false;
        int sum = 0;
        while (playerOneDeck.size() > 0 && playerTwoDeck.size() > 0) {

            if (playerOneDeck.get(0) > playerTwoDeck.get(0)) {
                playerOneDeck.add(playerOneDeck.get(0));
                playerOneDeck.add(playerTwoDeck.get(0));
                playerOneDeck.remove(playerOneDeck.get(0));
                playerTwoDeck.remove(playerTwoDeck.get(0));
            } else if (playerOneDeck.get(0) < playerTwoDeck.get(0)) {
                playerTwoDeck.add(playerTwoDeck.get(0));
                playerTwoDeck.add(playerOneDeck.get(0));
                playerTwoDeck.remove(playerTwoDeck.get(0));
                playerOneDeck.remove(playerOneDeck.get(0));
            } else {
                playerOneDeck.remove(playerOneDeck.get(0));
                playerTwoDeck.remove(playerTwoDeck.get(0));
            }
            if (playerOneDeck.size() < 1) {
                playerTwoWins = true;
                for (int num : playerTwoDeck) {
                    sum += num;
                }
            } else if (playerTwoDeck.size() < 1) {
                playerOneWins = true;
                for (int num : playerOneDeck) {
                    sum += num;
                }
            }
        }
        if (playerOneWins) {
            return "First player wins! Sum: " + sum;
        } else {
            return "Second player wins! Sum: " + sum;
        }
    }
}
/*You will be given two hands of cards, which will be integer numbers. Assume that you have two players.
You must find the winning deck and, respectively, the winner.
You start from the beginning of both hands. Compare the cards from the first deck to those from the second.
The player, who has a bigger card, takes both cards and puts them on the back of his hand - the second player's
card is last, and the first person's card (the winning one) is before it (second to last), and the player with the
smaller card must remove the card from his deck. If both players' cards have the same values - no one wins, and the
two cards must be removed from the decks. The game is over when one of the decks is left without any cards. You have
to print the winner on the console and the sum of the left cards: "{First/Second} player wins! Sum: {sum}".
*/