import java.util.Scanner;

public class A2_SquareRoot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            double sqrt = checkSqrt(input);
            System.out.printf("%.2f\n", sqrt);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double checkSqrt(String input) {

        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(number);
    }
}
/*Write a program that reads an integer number and calculates and prints its square root
(with 2 digits after the decimal point). If the number is invalid, print "Invalid number".
In all cases finally, print "Goodbye". Use try-catch-finally.*/
