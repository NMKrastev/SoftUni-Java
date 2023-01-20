import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class A1_SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println(number.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(number.stream().sorted()
                .map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
/*Write a program that reads one line of Integers separated by ", ".
•	Print the even numbers.
•	Sort them in ascending order.
•	Print them again.
Use 2 Lambda Expressions to do so.
*/
