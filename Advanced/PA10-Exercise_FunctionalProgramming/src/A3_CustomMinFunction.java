import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class A3_CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] array = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Function<Integer[], Integer> readArray = data -> Arrays.stream(data).mapToInt(Integer::new).min().orElse(0);

        System.out.println(readArray);
    }

}
/*Write a simple program that reads a set of numbers from the console
and finds the smallest of the numbers using a simple Function<Integer[], Integer>.*/
