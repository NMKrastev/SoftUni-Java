import java.util.Arrays;
import java.util.Scanner;

public class A8_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numArray.length; i++) {

            for (int j = i + 1; j < numArray.length; j++) {

                if (numArray[i] + numArray[j] == num) {

                    System.out.printf("%d %d\n", numArray[i], numArray[j]);

                }
            }
        }
    }
}
/*Write a program that prints all unique pairs in an array of integers whose sum is equal to a given number*/