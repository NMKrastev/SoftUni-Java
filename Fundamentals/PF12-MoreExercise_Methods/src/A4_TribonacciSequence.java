import java.util.Scanner;

public class A4_TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        getTribonacci(number);

    }

    private static void getTribonacci(int number) {
        int numOne = 1;
        int numTwo = 1;
        int numThree = 2;

        if (number == 1) {
            System.out.printf("%d", numOne);
        } else if (number == 2) {
            System.out.printf("%d %d", numOne, numTwo);
        } else if (number == 3) {
            System.out.printf("%d %d %d", numOne, numTwo, numThree);
        } else {
            int numFour = numOne + numTwo + numThree;
            System.out.printf("%d %d %d ", numOne, numTwo, numThree);

            for (int i = numFour; i <= number; i++) {

                System.out.printf("%d ", numFour);
                numOne = numTwo;
                numTwo = numThree;
                numThree = numFour;
                numFour = numOne + numTwo + numThree;

            }
        }
    }
}
/*In the "Tribonacci" sequence, every number is formed by the sum of the previous 3.
You are given a number num. Write a program that prints num numbers from the Tribonacci sequence,
each on a new line, starting from 1. The input comes as a parameter named num.
The value num will always be a positive integer.
*/