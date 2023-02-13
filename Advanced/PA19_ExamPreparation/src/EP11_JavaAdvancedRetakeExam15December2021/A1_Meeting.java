package EP11_JavaAdvancedRetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_Meeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);
        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(females::offer);
        int matchesCount = 0;

        while (!males.isEmpty() && !females.isEmpty()) {

            int male = males.peek();
            int female = females.peek();

            if (male <= 0 || female <= 0) {
                if (male <= 0) {
                    males.pop();
                }
                if (female <= 0) {
                    females.poll();
                }
                continue;
            }

            if (male % 25 == 0 || female % 25 == 0) {
                if (male % 25 == 0) {
                    males.pop();
                    males.pop();
                }
                if (female % 25 == 0) {
                    females.poll();
                    females.poll();
                }
                continue;
            }

            if (male == female) {
                matchesCount++;
                males.pop();
                females.poll();
            } else {
                male = males.pop() - 2;
                males.push(male);
                females.poll();
            }
        }

        System.out.printf("Matches: %s\n", matchesCount);
        System.out.println(males.isEmpty() ? "Males left: none" : String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(females.isEmpty() ? "Females left: none" : String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", "))));
    }
}
/*The first line will give you a sequence of integers representing males. Afterward,
you will be given another sequence of integers representing females.
You have to start from the first female and try to match it with the last male.
•	If their values are equal, you have to match them and remove both of them. Otherwise,
you should remove only the female and decrease the value of the male by 2.
•	If someone’s value is equal to or below 0, you should remove him/her
from the records before trying to match him/her with anybody.
•	Special case - if someone’s value is divisible by 25 without remainder,
you should remove him/her and the next person of the same gender.
You need to stop matching people when you have no more females or males.
Input / Constraints
•	On the first line, you will receive the integers, representing the males, separated by a single space.
•	On the second line, you will receive the integers, representing the females, separated by a single space.
•	All of the given numbers will be valid integers in the range [-100, 100].
Output
•	On the first line - print the number of successful matches:
o	"Matches: {matchesCount}"
•	On the second line - print all males left:
o	If there are no males: "Males left: none"
o	If there are males: "Males left: {male1}, {male2}, {male3}, (…)"
•	On the third line - print all females left:
o	If there are no females: "Females left: none"
o	If there are females: "Females left: {female1}, {female2}, {female3}, (…)"
*/
