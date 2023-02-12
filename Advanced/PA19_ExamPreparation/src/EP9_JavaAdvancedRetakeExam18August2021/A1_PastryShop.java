package EP9_JavaAdvancedRetakeExam18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class A1_PastryShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String biscuit = "Biscuit";
        String cake = "Cake";
        String pie = "Pie";
        String pastry = "Pastry";
        Map<String, Integer> productsMap = new LinkedHashMap<>();
        productsMap.put(biscuit, 0);
        productsMap.put(cake, 0);
        productsMap.put(pie, 0);
        productsMap.put(pastry, 0);
        Deque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::offer);
        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25) {
                productsMap.put(biscuit, productsMap.get(biscuit) + 1);
            } else if (sum == 50) {
                productsMap.put(cake, productsMap.get(cake) + 1);
            } else if (sum == 75) {
                productsMap.put(pastry, productsMap.get(pastry) + 1);
            } else if (sum == 100) {
                productsMap.put(pie, productsMap.get(pie) + 1);
            } else {
                ingredient += 3;
                ingredients.push(ingredient);
            }
        }
        if (productsMap.get("Biscuit") != 0 && productsMap.get("Cake") != 0
                && productsMap.get("Pastry") != 0 && productsMap.get("Pie") != 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println(liquids.isEmpty()
                ? "Liquids left: none"
                : String.format("Liquids left: %s", liquids.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(ingredients.isEmpty() ?
                "Ingredients left: none"
                : String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        productsMap.forEach((p, v) -> System.out.printf("%s: %d\n", p, v));
    }
}
/*First, you will be given a sequence of integers, representing liquids. Afterward, you will be given another
sequence of integers representing ingredients.
You need to start from the first liquid and try to mix it with the last ingredient. If the sum of their values is equal
to any of the items in the table below – cook the food corresponding to the value and remove both the liquid
and the ingredient. Otherwise, remove only the liquid and increase the value of the ingredient by 3.
You need to stop combining when you have no more liquids or ingredients.
Food	Value needed
Biscuit	25
Cake	50
Pastry	75
Pie	100
Input
•	On the first line, you will receive the integers representing the liquids, separated by a single space.
•	On the second line, you will receive the integers representing the ingredients, separated by a single space.
Output
•	On the first line of output print one of the following outputs:
o	"Great! You succeeded in cooking all the food!" -if you have at least
one of each of the foods, after completing combining.
o	"What a pity! You didn't have enough materials to cook everything." –
if you did not collect one of each of the foods, after completing combining.
•	On the second line - print all liquids you have left:
o	If there are no liquids: "Liquids left: none"
o	If there are liquids: "Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
•	On the third line - print all physical materials you have left:
o	If there are no items: "Ingredients left: none"
o	If there are items: "Ingredients left: {ingredient}, {ingredient}, {ingredient}, (…)"
•	Then, you need to print all Advanced Materials and the amount you have of them, ordered:
o	"Biscuit: {amount}"
o	"Cake: {amount}"
o	"Pie: {amount}"
o	"Pastry: {amount}"
Constraints
•	All of the given numbers will be valid integers in the range [0, 100].
•	Advanced materials can be crafted more than once.
*/
