package EP5_JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class A1_Cooking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> bakedProducts = new TreeMap<>(
                Map.of("Bread", 0,
                        "Cake", 0,
                        "Fruit Pie", 0,
                        "Pastry", 0));
        Deque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> ingredients = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int currentLiquid = liquids.removeFirst();
            int currentIngredient = ingredients.pop();
            int product = currentLiquid + currentIngredient;

            if (product == 25) {
                bakedProducts.put("Bread", bakedProducts.get("Bread") + 1);
            } else if (product == 50) {
                bakedProducts.put("Cake", bakedProducts.get("Cake") + 1);
            } else if (product == 75) {
                bakedProducts.put("Pastry", bakedProducts.get("Pastry") + 1);
            } else if (product == 100) {
                bakedProducts.put("Fruit Pie", bakedProducts.get("Fruit Pie") + 1);
            } else {
                currentIngredient += 3;
                ingredients.push(currentIngredient);
            }
        }

        if (bakedProducts.get("Bread") != 0 && bakedProducts.get("Cake") != 0
                && bakedProducts.get("Pastry") != 0 && bakedProducts.get("Fruit Pie") != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println(liquids.isEmpty()
                ? "Liquids left: none"
                : String.format("Liquids left: %s", liquids.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(ingredients.isEmpty()
                ? "Ingredients left: none"
                : String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        bakedProducts.forEach((p, c) -> System.out.printf("%s: %d\n", p, c));
    }
}
/*First, you will be given a sequence of integers, representing liquids. Afterward, you will be given another
sequence of integers representing ingredients.
You need to start from the first liquid and try to mix it with the last ingredient. If the sum of their values is equal
to any of the items in the table below – cook the food corresponding to the value and remove both the liquid and the ingredient.
Otherwise, remove only the liquid and increase the value of the ingredient by 3.
You need to stop combining when you have no more liquids or ingredients.
Input
•	On the first line, you will receive the integers representing the liquids, separated by a single space.
•	On the second line, you will receive the integers representing the ingredients, separated by a single space.
Output
•	On the first line of output print one of the following outputs:
o	"Wohoo! You succeeded in cooking all the food!" - if you have at least
one of each of the foods, after completing combining.
o	"Ugh, what a pity! You didn't have enough materials to cook everything." –
if you did not collect one of each of the foods, after completing combining.
•	On the second line - print all liquids you have left:
o	If there are no liquids: "Liquids left: none"
o	If there are liquids: "Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
•	On the third line - print all physical materials you have left:
o	If there are no items: "Ingredients left: none"
o	If there are items: "Ingredients left: {ingredient}, {ingredient}, {ingredient}, (…)"
•	Then, you need to print all Advanced Materials and the amount you have of them, ordered alphabetically:
o	"Bread: {amount}"
o	"Cake: {amount}"
o	"Fruit Pie: {amount}"
o	"Pastry: {amount}"
Constraints
•	All of the given numbers will be valid integers in the range [0, 100].
•	Advanced materials can be crafted more than once.

*/