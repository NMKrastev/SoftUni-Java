import java.util.*;

public class A7_HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> personDecksMap = new LinkedHashMap<>();
        String input;
        while (!(input = scanner.nextLine()).equals("JOKER")) {

            String name = input.split(":")[0];
            String deck = input.split(": ")[1];

            personDecksMap.putIfAbsent(name, new LinkedHashSet<>());
            Set<String> currentDeck = personDecksMap.get(name);
            currentDeck.addAll(Arrays.asList(deck.split(",\\s+")));
        }

        personDecksMap.forEach((person, deck) -> {
            System.out.printf("%s: ", person);
            int sum = getSumOfCards(deck);
            System.out.printf("%d\n", sum);
        });
    }

    private static int getSumOfCards(Set<String> deck) {

        int sum = 0;
        int size = deck.size();
        for (int i = 0; i < size; i++) {
            String currentHand = deck.iterator().next();
            deck.remove(currentHand);
            if (Character.isDigit(currentHand.charAt(0))) {
                int num = Integer.parseInt(currentHand.replaceAll("[^0-9]", ""));
                if (currentHand.contains("S")) {
                    sum += num * 4;
                } else if (currentHand.contains("H")) {
                    sum += num * 3;
                } else if (currentHand.contains("D")) {
                    sum += num * 2;
                } else if (currentHand.contains("C")) {
                    sum += num;
                }
            } else {
                if (currentHand.contains("S")) {
                    switch (currentHand.charAt(0)) {
                        case 'A':
                            sum += 14 * 4;
                            break;
                        case 'K':
                            sum += 13 * 4;
                            break;
                        case 'Q':
                            sum += 12 * 4;
                            break;
                        case 'J':
                            sum += 11 * 4;
                            break;
                    }
                } else if (currentHand.contains("H")) {
                    switch (currentHand.charAt(0)) {
                        case 'A':
                            sum += 14 * 3;
                            break;
                        case 'K':
                            sum += 13 * 3;
                            break;
                        case 'Q':
                            sum += 12 * 3;
                            break;
                        case 'J':
                            sum += 11 * 3;
                            break;
                    }
                } else if (currentHand.contains("D")) {
                    switch (currentHand.charAt(0)) {
                        case 'A':
                            sum += 14 * 2;
                            break;
                        case 'K':
                            sum += 13 * 2;
                            break;
                        case 'Q':
                            sum += 12 * 2;
                            break;
                        case 'J':
                            sum += 11 * 2;
                            break;
                    }
                } else if (currentHand.contains("C")) {
                    switch (currentHand.charAt(0)) {
                        case 'A':
                            sum += 14;
                            break;
                        case 'K':
                            sum += 13;
                            break;
                        case 'Q':
                            sum += 12;
                            break;
                        case 'J':
                            sum += 11;
                            break;
                    }
                }
            }
        }

        return sum;
    }
}
/*You are given a sequence of people and what cards he draws from the deck for every person. The input will be
separate lines in the format:
"{personName}: {PT, PT, PT,… PT}"
Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type.
The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ":". The input will always be
valid, and in the format described, there is no need to check it.
A single person cannot have more than one card with the same power and type. If he draws such a card, he discards it.
The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type.
Powers 2 to 10 have the same value, and J to A is 11 to 14. Types are mapped to multipliers the following way
(S -> 4, H-> 3, D -> 2, C -> 1).
Finally, print out the total value each player has in his hand in the format:
"{personName}: {value}"
*/
