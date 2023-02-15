package EP16_JavaAdvancedExam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_EnergyDrinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> energyDrinks = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int maxCaffeine = 300;

        while (!caffeine.isEmpty() && !energyDrinks.isEmpty()) {
             int product = caffeine.getLast() * energyDrinks.getFirst();

             if (product <= maxCaffeine) {
                 caffeine.removeLast();
                 energyDrinks.removeFirst();
                 maxCaffeine -= product;
             } else {
                 caffeine.removeLast();
                 energyDrinks.addLast(energyDrinks.removeFirst());
                 maxCaffeine += 30;
                 if (maxCaffeine > 300) {
                     maxCaffeine = 300;
                 }
             }
        }
        if (!energyDrinks.isEmpty()) {
            System.out.printf("Drinks left: %s\n", energyDrinks.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.\n", 300 - maxCaffeine);
    }
}
/*On the first line, you will receive a sequence of numbers representing milligrams of caffeinе.
On the second line, you will receive another sequence of numbers representing energy drinks.
It is important to know that the maximum caffeine Stamat can have for the night is 300 milligrams, and his initial is always 0.
To calculate the caffeine in the drink take the last milligrams of caffeinе and the first energy drink, and multiply them.
Then, compare the result with the caffeine Stamat drank:
•	If the sum of the caffeine in the drink and the caffeine that Stamat drank doesn't exceed 300 milligrams,
remove both the milligrams of caffeinе and the drink from their sequences. Also, add the caffeine to Stamat's total caffeine.
•	If Stamat is about to exceed his maximum caffeine per night, do not add the caffeine to Stamat’s total caffeine.
Remove the milligrams of caffeinе and move the drink to the end of the sequence. Also, reduce the current caffeine
that Stamat has taken by 30 (Note: Stamat's caffeine cannot go below 0).
Stop calculating when you are out of drinks or milligrams of caffeine.
For more clarification, see the examples below.
Input
•	In the first line, you will be given a sequence of the milligrams of caffeinе -
integers separated by comma and space ", " in the range [1, 50].
•	In the second line, you will be given a sequence of energy drinks -
integers separated by comma and space ", " in the range [1, 300].
Output
•	On the first line:
o	If Stamat hasn't drunk all the energy drinks, print the remaining ones separated by a comma and a space ", ":
	"Drinks left: { remaining drinks separated by ", " }"
o	If Stamat has drunk all the energy drinks, print:
	"At least Stamat wasn't exceeding the maximum caffeine."
•	On the next line, print:
o	"Stamat is going to sleep with { current caffeine } mg caffeine."
Constraints
•	You will always have at least one element in each sequence at the beginning.
*/
