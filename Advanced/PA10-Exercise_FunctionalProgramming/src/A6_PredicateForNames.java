import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A6_PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        //Predicate<String> predicate = name -> name.length() <= length;
        //names.stream().filter(predicate).forEach(System.out::println);

        Predicate<String> predicate = name -> name.length() > length;

        names.removeIf(predicate);

        Consumer<String> consumer = System.out::println;

        names.forEach(consumer);
    }
}
/*Write a predicate. Its goal is to check a name for its length and to return true if the length of the name
is less or equal to the passed integer. You will be given an integer that represents the length you have to use.
On the second line, you will be given a string array with some names.
Print the names, passing the condition in the predicate. */
