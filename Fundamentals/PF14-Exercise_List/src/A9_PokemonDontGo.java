import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A9_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = catchingPokemons(scanner, numsList);
        System.out.println(sum);

    }

    public static int catchingPokemons(Scanner scanner, List<Integer> numsList) {

        int sum = 0;
        int removedElement = 0;
        while (numsList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                removedElement = numsList.get(0);
            } else if (index > numsList.size() - 1) {
                removedElement = numsList.get(numsList.size() - 1);
            } else {
                removedElement = numsList.get(index);
            }
            removeIndex(numsList, index);
            sum += removedElement;

            if (numsList.size() > 0) {
                increaseAndDecreaseElements(numsList, removedElement);
            }
        }

        return sum;
    }

    private static List<Integer> increaseAndDecreaseElements(List<Integer> numsList, int removedElement) {

        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) > removedElement) {
                numsList.set(i, numsList.get(i) - removedElement);
            } else if (numsList.get(i) <= removedElement) {
                numsList.set(i, numsList.get(i) + removedElement);
            }
        }

        return numsList;
    }

    private static List<Integer> removeIndex(List<Integer> numsList, int index) {

        if (index < 0 && numsList.size() > 1) {
            index = 0;
            numsList.remove(index);
            numsList.add(index, numsList.get(numsList.size() - 1));
        } else if (index > numsList.size() - 1 && numsList.size() > 1) {
            int i = numsList.size() - 1;
            numsList.remove(i);
            numsList.add(numsList.get(0));
        } else if (index < 0 && numsList.size() == 1) {
            numsList.remove(0);
        } else if (index > numsList.size() - 1 && numsList.size() - 1 == 0) {
            numsList.remove(0);
        } else {
            numsList.remove(index);
        }

        return numsList;
    }
}
/*You will receive a sequence of integers, separated by spaces - the distances to the Pokémon.
Then you will begin receiving integers corresponding to indexes in that sequence.
When you receive an index, you must remove the element at that index from the sequence
(as if you've captured the Pokémon).
•	You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed element with
the value of the removed element.
•	You must DECREASE the value of all elements in the sequence which are GREATER than the removed element with the
value of the removed element.
If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and COPY
the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element whose value you should use
is the REMOVED element.
The program ends when the sequence has no elements (there are no Pokémon left for Ely to catch).
Input
•	On the first line of input, you will receive a sequence of integers, separated by spaces.
•	On the next several lines, you will receive integers – the indexes.
Output
•	When the program ends, you must print the summed up value of all REMOVED elements on the console.
Constraints
•	The input data will consist ONLY of valid integers in the range [-2.147.483.648, 2.147.483.647].
*/