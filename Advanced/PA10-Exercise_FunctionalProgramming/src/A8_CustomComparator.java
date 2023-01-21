import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A8_CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> comparator = (numOne, numTwo) -> {

          if (numOne % 2 == 0 && numTwo % 2 != 0) {
              return -1;
          } else if (numOne % 2 != 0 && numTwo % 2 == 0) {
              return 1;
          }

            return numOne.compareTo(numTwo);
        };

        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
    }
}
/*Write a custom comparator that sorts all even numbers before all odd ones in ascending order.
Pass it to an Arrays.sort() function and print the result.*/
