package EP6_JavaAdvancedExam20February2021;

import java.util.*;
import java.util.stream.Collectors;

public class A1_MagicBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> magicBoxOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> magicBoxTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> claimedItems = new ArrayList<>();

        while (!magicBoxOne.isEmpty() && !magicBoxTwo.isEmpty()) {

            int first = magicBoxOne.removeFirst();
            int second = magicBoxTwo.removeLast();
            int product = first + second;

            if (product % 2 == 0) {
                claimedItems.add(product);
            } else {
                magicBoxOne.addFirst(first);
                magicBoxOne.addLast(second);
            }
        }

        System.out.println(magicBoxOne.isEmpty()
                ? "First magic box is empty."
                : "Second magic box is empty.");
        int sum = claimedItems.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum >= 90
                ? String.format("Wow, your prey was epic! Value: %d\n", sum)
                : String.format("Poor prey... Value: %d\n", sum));
    }
}
/*Every purchase gives you two magic boxes and they are represented as a sequence of integers.
First, you will be given a sequence of integers, representing the first magic box.
Afterward, you will be given another sequence of integers representing the second magic box.
You need to start from the first item in the first box and sum it up with the last item in the second box.
If the sum of their values is an even number, add the summed item to your collection of claimed items
and remove them both from the boxes. Otherwise, remove the last item from the second box
and add it to the last position in the first box. You need to stop summing items when one of the boxes becomes empty.
If the first magic box becomes empty print:
•	"First magic box is empty."
If the second magic box becomes empty print:
•	"Second magic box is empty."
In the end, you need to determine the quality of your claimed items. If the sum of the claimed items is equal to or greater than 90, print:
•	"Wow, your prey was epic! Value: {sum of claimed items}"
Else print:
•	"Poor prey... Value: {sum of claimed items}"
Input
•	On the first line, you will receive the integers representing the first magic box, separated by a single space.
•	On the second line, you will receive the integers representing the second magic box, separated by a single space.
Output
•	On the first line of output – print which box got empty in the format described above.
•	On the second line – the quality of your prey in the format described above.
Constraints
•	All of the given numbers will be valid integers in the range [0, 100].
•	There won’t be a case where both magic boxes become empty at the same time.
*/
