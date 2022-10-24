import java.math.BigInteger;
import java.util.Scanner;

public class A2_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger numOne = new BigInteger(scanner.nextLine());
        BigInteger numTwo = new BigInteger(scanner.nextLine());

        BigInteger sum = numOne.add(numTwo);

        System.out.println(sum);
    }
}
/*You will receive two numbers (0 to 10 on 50th), and print their sum.*/