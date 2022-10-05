import java.util.Scanner;

public class A8_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long numberOne = Integer.parseInt(scanner.nextLine());
        long numberTwo = Integer.parseInt(scanner.nextLine());

        double result = findFactorial(numberOne) / findFactorial(numberTwo);

        System.out.printf("%.2f", result);

    }

    private static double findFactorial(double number) {

        if (number == 0) {
            return 1;
        } else {
            return (number * findFactorial(number - 1));
        }
    }
}
/*Read two integer numbers. Calculate the factorial of each number.
Divide the first result by the second and print the division formatted to the second decimal point.*/