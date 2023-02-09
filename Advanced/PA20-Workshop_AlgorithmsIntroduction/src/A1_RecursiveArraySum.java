import java.util.Arrays;
import java.util.Scanner;

public class A1_RecursiveArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sumArray(array, 0);
        System.out.println(sum);
    }

    private static int sumArray(int[] array, int index) {

        if (index == array.length - 1) {
            return array[index]; //return 0;
        }
        return array[index] + sumArray(array, index + 1);
    }
}
/*Write a program that finds the sum of all elements in an integer array. Use recursion.
Note: In practice, recursion should not be used here (instead, use an iterative solution), this is just an exercise.
*/
