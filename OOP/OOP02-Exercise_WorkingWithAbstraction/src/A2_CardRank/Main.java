package A2_CardRank;

public class Main {

    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        for (CardRanks cardRanks : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cardRanks.ordinal(), cardRanks.name());
        }
    }
}
/*Create an enumeration type that has as its constants the thirteen ranks of a deck of playing cards
(ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING).
Iterate over the values of the enumeration type and print all ordinal values and names.
*/
