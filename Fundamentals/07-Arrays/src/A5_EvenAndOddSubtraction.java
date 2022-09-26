import java.util.Arrays;
import java.util.Scanner;

public class A5_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumEven = 0, sumOdd = 0;
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0) {

                sumEven += numbers[i];

            } else {

                sumOdd += numbers[i];
            }
        }

        System.out.println(sumEven - sumOdd);
    }
}
/*Write a program that calculates the difference between
the sum of the even and the sum of the odd numbers in an array.*/