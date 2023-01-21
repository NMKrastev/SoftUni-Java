import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A3_CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMin = nums -> Collections.min(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        System.out.println(getMin.apply(numbers));
    }
}
/*Write a simple program that reads a set of numbers from the console
and finds the smallest of the numbers using a simple Function<Integer[], Integer>.*/
