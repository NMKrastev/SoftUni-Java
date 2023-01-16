import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A9_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        numbers.stream().limit(3).forEach(n -> System.out.printf("%d ", n));
    }
}
/*Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.*/
