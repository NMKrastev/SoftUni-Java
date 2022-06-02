import java.math.BigDecimal;
import java.util.Scanner;

public class PF03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < num; i++) {
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());

            sum = sum.add(currentNum);
        }
        System.out.println(sum);
    }
}
/*Write a program to enter n numbers and calculate and print their exact sum (without rounding).*/