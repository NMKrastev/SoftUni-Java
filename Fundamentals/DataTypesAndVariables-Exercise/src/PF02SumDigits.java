import java.util.Scanner;

public class PF02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (number > 0) {
            int currentDigit = number % 10;
            number = number / 10;
            sum += currentDigit;
        }
        System.out.println(sum);
    }
}
/*You will be given a single integer. Your task is to find the sum of its digits.*/