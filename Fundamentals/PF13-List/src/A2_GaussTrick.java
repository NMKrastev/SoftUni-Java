import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        sumNumbers(numbers);

    }


    public static void sumNumbers(List<Integer> numbers) {

        int count = numbers.size() / 2;
        for (int i = 0; i < count; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }

    }
}
/*Write a program that sum all numbers in a list in the following order:
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.
*/