import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A6_FindEvensOrOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int begin = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);
        String filter = scanner.nextLine();

        IntPredicate predicate = num -> filter.equals("odd") == (num % 2 != 0);

        String output = IntStream.rangeClosed(begin, end)
                .filter(predicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
/*You are given a lower and an upper bound for a range of integer numbers.
Then a command specifies if you need to list all even or odd numbers in the given range.
Use predicates that need to be passed to a method.*/
