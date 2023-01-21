import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A9_ListOfPredicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Integer> divisibleNumsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer currentNum : divisibleNumsList) {
                if (number % currentNum != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= num; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
/*Find all numbers in the range 1..N that is divisible by the numbers of a given sequence. Use predicates.*/
