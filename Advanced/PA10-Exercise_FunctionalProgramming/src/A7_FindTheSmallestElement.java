import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A7_FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        /*Function<List<Integer>, Integer> function = list -> {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= min) {
                    min = list.get(i);
                    index = i;
                }
            }
            return index;
        };*/

        Function<List<Integer>, Integer> altFunction = list -> {
            int min = list.stream().mapToInt(e -> e).min().getAsInt();
            return list.lastIndexOf(min);
        };

        System.out.println(altFunction.apply(numbersList));
    }
}
/*Write a program that is using a custom function (written by you) to find the smallest integer in a sequence of integers.
The input could have more than one space. Your task is to collect the integers from the console, find the smallest
one and print its index (if more than one such elements exist, print the index of the rightmost one).*/
