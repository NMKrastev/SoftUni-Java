import java.math.BigInteger;
import java.util.Scanner;

public class A3_BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger number = new BigInteger(scanner.nextLine());
        BigInteger factorial = findFactorial(number);

        System.out.println(factorial);
    }

    private static BigInteger findFactorial(BigInteger number) {

        if (number.equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(1);
        } else {
            return (number.multiply(findFactorial(number.subtract(BigInteger.valueOf(1)))));
        }
    }
}
/*You will receive N - the number in the range [0 - 1000]. Calculate the Factorial of N and print the result*/