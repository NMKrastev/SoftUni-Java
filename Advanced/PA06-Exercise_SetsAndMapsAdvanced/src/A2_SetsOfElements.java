import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A2_SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int setOneLength = scanner.nextInt();
        int setTwoLength = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = new LinkedHashSet<>();
        while (setOneLength-- > 0) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> secondSet = new LinkedHashSet<>();
        while (setTwoLength-- > 0) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(num -> System.out.printf("%d ", num));
    }
}
/*On the first line, you are given the length of two sets, N and M. On the next N + M lines, there are N numbers that
are in the first set and M numbers that are in the second one. Find all non-repeating element that appears in both of
them, and print them in the same order at the console:
Set with length N = 4: {1, 3, 5, 7}
Set with length M = 3: {3, 4, 5}
Set that contains all repeating elements -> {3, 5}
*/
