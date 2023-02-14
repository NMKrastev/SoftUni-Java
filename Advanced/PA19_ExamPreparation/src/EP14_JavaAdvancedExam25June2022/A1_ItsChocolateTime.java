package EP14_JavaAdvancedExam25June2022;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A1_ItsChocolateTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String milkChocolate = "# Milk Chocolate";
        String darkChocolate = "# Dark Chocolate";
        String bakingChocolate = "# Baking Chocolate";
        Map<String, Integer> chocolates = new TreeMap<>(Map.of(
                bakingChocolate, 0,
                darkChocolate, 0,
                milkChocolate, 0
        ));

        Deque<Double> milkValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Double> cocoaPowder = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!milkValue.isEmpty() && !cocoaPowder.isEmpty()) {
            double milk = milkValue.removeFirst();
            double cocoa = cocoaPowder.removeLast();
            double percentage = (cocoa / (milk + cocoa)) * 100;

            if (percentage == 30) {
                chocolates.put(milkChocolate, chocolates.get(milkChocolate) + 1);
            } else if (percentage == 50) {
                chocolates.put(darkChocolate, chocolates.get(darkChocolate) + 1);
            } else if (percentage == 100) {
                chocolates.put(bakingChocolate, chocolates.get(darkChocolate) + 1);
            } else {
                milk += 10;
                milkValue.addLast(milk);
            }
        }

        System.out.println(chocolates.get(bakingChocolate) > 0 && chocolates.get(darkChocolate) > 0 && chocolates.get(milkChocolate) > 0
                ? "It’s a Chocolate Time. All chocolate types are prepared."
                : "Sorry, but you didn't succeed to prepare all types of chocolates.");
        chocolates.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s --> %d\n", e.getKey(), e.getValue()));

    }
}
/*First, you will receive a sequence of doubles, representing the milk quantity for the preparation of single chocolate.
After that, you will be given another sequence of doubles - the cacao powder quantity.
Your task is to mix them so you can prepare the chocolates, listed in the table below with different cacao percentages.
Chocolate types	Cacao percentage
Milk Chocolate	30
Dark Chocolate	50
Baking Chocolate	100
To prepare chocolate, you have to take the first milk value and the last cacao powder value.
The cacao percentage is calculated by dividing the cacao powder value by the sum of the milk and cacao powder values.
If the result of this operation equals one of the point levels described in the table, you make the chocolate
and remove both milk and cacao powder values. Otherwise, you should remove the cacao powder value,
increase the milk value by 10, then remove it from the first position and add it at the end.
You need to stop producing chocolates when you run out of milk or cacao powder values.
Your task is considered done if you make at least three chocolates - one of each type.
Input
•	The first line of input will represent the milk values - doubles, separated by a single space.
•	On the second line, you will be given the cacao powder values - doubles again, separated by a single space.
Output
•	On the first line of output - print whether you've succeeded in preparing the chocolates
o	"It’s a Chocolate Time. All chocolate types are prepared."
o	"Sorry, but you didn't succeed to prepare all types of chocolates."
•	In the next few lines, you have to print the chocolates you have made at least once, ordered alphabetically in the format:
" # {chocolate type} --> {amount}".
Constraints
•	All values will be doubles in the range [0, 200].
*/
