import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class A2_SumNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], String> count = num -> "Count = " + Arrays.stream(num).count();
        Function<int[], String> sum = num -> "Sum = " + Arrays.stream(num).sum();

        int[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));
    }
}
/*Write a program that reads one line of Integers separated by ", ". Print the count of the numbers and their sum.
*/
