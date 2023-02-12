package EP10_JavaAdvancedExam23October2021;

import java.util.*;
import java.util.stream.Collectors;

public class A1_AutumnCocktails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String appleHinny = "Apple Hinny";
        String highFashion = "High Fashion";
        String pearSour = "Pear Sour";
        String theHarvest = "The Harvest";
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put(appleHinny, 0);
        cocktails.put(highFashion, 0);
        cocktails.put(pearSour, 0);
        cocktails.put(theHarvest, 0);
        Deque<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> freshnessLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {

            int ingredient = ingredients.removeFirst();
            int level = freshnessLevel.removeLast();
            if (ingredient == 0) {
                freshnessLevel.addLast(level);
                continue;
            }
            int product = ingredient * level;

            if (product == 150) {
                cocktails.put(pearSour, cocktails.get(pearSour) + 1);
            } else if (product == 250) {
                cocktails.put(theHarvest, cocktails.get(theHarvest) + 1);
            } else if (product == 300) {
                cocktails.put(appleHinny, cocktails.get(appleHinny) + 1);
            } else if (product == 400) {
                cocktails.put(highFashion, cocktails.get(highFashion) + 1);
            } else {
                ingredient += 5;
                ingredients.addLast(ingredient);
            }
        }

        if (cocktails.get(pearSour) != 0 && cocktails.get(theHarvest) != 0
                && cocktails.get(appleHinny) != 0 && cocktails.get(highFashion) != 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sum = 0;
        while (!ingredients.isEmpty()) {
            sum += ingredients.removeFirst();
        }
        if (sum > 0) {
            System.out.printf("Ingredients left: %d\n", sum);
        }
        cocktails.entrySet()
                .stream()
                .filter(cocktail -> cocktail.getValue() > 0)
                .forEach(cocktail -> System.out.printf("# %s --> %d\n", cocktail.getKey(), cocktail.getValue()));
    }
}
/*First, you will receive a sequence of integers, representing the number of ingredients in a single bucket.
After that, you will be given another sequence of integers - the freshness level of the ingredients.
Your task is to mix them so you can produce the cocktails, listed in the table below with the exact freshness level.
Cocktail	Freshness Level needed
Pear Sour	150
The Harvest	250
Apple Hinny	300
High Fashion	400
To mix a cocktail, you have to take the first bucket of ingredients and the last freshness level value.
The total freshness level is calculated by their multiplication. If the product of this operation equals
one of the levels described in the table, you make the cocktail and remove both buckets with ingredients and freshness value.
Otherwise, you should remove the freshness level, increase the ingredient value by 5,
then remove it from the first position and add it at the end. In case you have an ingredient with a value of 0
you have to remove it and continue mixing the cocktails.
You need to stop making cocktails when you run out of buckets with ingredients or freshness level values.
Your task is considered done if you make at least four cocktails - one of each type.
Input
•	The first line of input will represent the values of buckets with ingredients - integers, separated by a single space.
•	On the second line, you will be given the freshness values - integers again, separated by a single space.
Output
•	On the first line of output - print whether you've succeeded in preparing the cocktails
o	"It's party time! The cocktails are ready!".
o	"What a pity! You didn't manage to prepare all cocktails.".
•	On the next output line - print the sum of the ingredients only if they are left any
o	"Ingredients left: {sum of the left ingredients}".
•	On the last few lines, you have to print the cocktails you have made at least once, ordered alphabetically in the format:
" # {cocktail name} --> {amount}".
Constraints
•	All of the ingredients' values and freshness level values will be integers in the range [0, 100].
•	We can have more than one mixed cocktail of the types specified in the table above.
*/