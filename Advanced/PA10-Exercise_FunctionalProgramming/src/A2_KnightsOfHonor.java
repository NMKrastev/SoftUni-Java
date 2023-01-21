import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class A2_KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> printNames = p -> {
            System.out.println(Arrays.stream(p)
                    .map(w -> String.format("Sir %s", w))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printNames.accept(names);
    }
}
/*Write a program that reads a collection of names as strings from the console
and then appends "Sir" in front of every name and prints it back onto the console. Use a Consumer<T>.*/
