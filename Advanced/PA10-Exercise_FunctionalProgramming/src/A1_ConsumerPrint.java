import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class A1_ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> printNames = p -> {
            System.out.println(Arrays.stream(p)
                    .map(w -> String.format("%s", w))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printNames.accept(names);
    }
}
/*Write a program that reads a collection of strings, separated by one or more whitespaces, from the console
and then prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.*/
