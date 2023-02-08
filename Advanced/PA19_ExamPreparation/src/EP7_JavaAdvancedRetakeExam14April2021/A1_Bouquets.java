package EP7_JavaAdvancedRetakeExam14April2021;

import java.util.*;
import java.util.stream.Collectors;

public class A1_Bouquets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tulips = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> storedFlowers = new ArrayList<>();
        int flowersCount = 0;

        while (!daffodils.isEmpty() && !tulips.isEmpty()) {

            int daffodil = daffodils.removeFirst();
            int tulip = tulips.removeLast();
            int product = daffodil + tulip;

            if (product == 15) {
                flowersCount++;
            }
            while (product > 15) {
                tulip -= 2;
                product = daffodil + tulip;
                if (product == 15) {
                    flowersCount++;
                }
            }
            if (product < 15) {
                storedFlowers.add(product);
            }
        }

        flowersCount += (storedFlowers.stream().mapToInt(Integer::intValue).sum() / 15);

        System.out.println(flowersCount >= 5
                ? String.format("You made it! You go to the competition with %d bouquets!\n", flowersCount)
                : String.format("You failed... You need more %d bouquets.\n", 5 - flowersCount));
    }
}
/*You will be given two sequences of integers, representing daffodils and tulips.
You need to start making bouquets knowing that one bouquet needs 15 flowers. Your goal is to make at least 5 bouquets.
You will start crafting from the last tulips and the first daffodils. If the sum of their values is equal to 15 –
create one bouquet and remove them. While the sum is bigger than 15, keep decreasing the value of the tulips by 2.
If the sum is less than 15 you have to store them for later and remove them.
You need to stop combining when you have no more daffodils or tulips.
In the end, if you have any stored flowers you should make as many bouquets as you can with them.
Input
•	On the first line, you will receive the integers representing the tulips, separated by ", ".
•	On the second line, you will receive the integers representing the daffodils, separated by ", ".
Output
•	Print whether you have succeeded in making at least 5 bouquets:
o	"You made it! You go to the competition with {count of bouquets} bouquets!"
o	"You failed... You need more {number} bouquets."
Constraints
•	All of the given numbers will be valid integers in the range [0, 120].
•	Don't have a situation with a negative number.
*/
