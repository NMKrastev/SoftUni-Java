import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A5_ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divisible = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numberList);

        Predicate<Integer> predicate = num -> num % divisible == 0;

        numberList.removeIf(predicate);

        Consumer<Integer> consumer = num -> System.out.print(num + " ");

        numberList.forEach(consumer);
    }
}
/*Write a program that reverses a collection and removes elements that are divisible by a given integer n.*/
