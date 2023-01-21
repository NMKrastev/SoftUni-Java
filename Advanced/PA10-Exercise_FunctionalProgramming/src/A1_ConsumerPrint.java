import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class A1_ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> printNames = System.out::println;

        names.forEach(printNames);
    }
}
/*Write a program that reads a collection of strings, separated by one or more whitespaces, from the console
and then prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.*/
