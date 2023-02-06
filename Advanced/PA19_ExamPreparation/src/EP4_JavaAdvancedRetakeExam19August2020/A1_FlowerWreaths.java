package EP4_JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_FlowerWreaths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> lilies = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> roses = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int storedSum = 0;
        int wreathsCount = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {

            int lily = lilies.removeLast();
            int rose = roses.removeFirst();
            int sum = lily + rose;

            if (sum == 15) {
                wreathsCount++;
            }
            while (sum > 15) {
                sum -= 2;
                if (sum == 15) {
                    wreathsCount++;
                    break;
                }
            }
            if (sum < 15) {
                storedSum += sum;
            }

            if (wreathsCount == 5) {
                break;
            }
        }

        int count = storedSum / 15;
        if (count > 0) {
            wreathsCount += count;
        }

        System.out.println(wreathsCount < 5
                ? String.format("You didn't make it, you need %d wreaths more!", 5 - wreathsCount)
                : String.format("You made it, you are going to the competition with %d wreaths!", wreathsCount));

    }
}
/*You will be given two sequences of integers, representing roses and lilies.
You need to start making wreaths knowing that one wreath needs 15 flowers. Your goal is to make at least 5 flower wreaths.
You will start crafting from the last lilies and the first roses.
If the sum of their values is equal to 15 – create one wreath and remove them. If the sum is bigger than 15,
just decrease the value of the lilies by 2. If the sum is less than 15 you have to store them for later and remove them.
You need to stop combining when you have no more roses or lilies. In the end,
if you have any stored flowers you should make as many wreaths as you can with them.
Input
•	On the first line, you will receive the integers representing the lilies, separated by ", ".
•	On the second line, you will receive the integers representing the roses, separated by ", ".
Output
•	Print whether you have succeeded in making at least 5 wreaths:
o	"You made it, you are going to the competition with {count of wreaths} wreaths!"
o	"You didn't make it, you need {wreaths needed} wreaths more!"
Constraints
•	All of the given numbers will be valid integers in the range [0, 120].
•	Don't have a situation with a negative number.
*/