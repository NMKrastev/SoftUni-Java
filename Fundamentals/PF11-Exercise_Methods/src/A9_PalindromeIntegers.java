import java.util.Scanner;

public class A9_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while(!input.equals("END")) {

            int number = Integer.parseInt(input);
            System.out.println(isPalindromeInt(number));

            input = scanner.nextLine();
        }

    }

    private static boolean isPalindromeInt(int number) {

        int sum = 0;
        int tempNumber = number;
        int remainder = 0;

        while (number > 0) {
            remainder = number % 10;
            sum = (sum * 10) + remainder;
            number = number / 10;
        }

        if (tempNumber == sum) {
            return true;
        } else {
            return false;
        }
    }
}
/*A palindrome is a number that reads the same backward as forward, such as 323 or 1001.
Write a program that reads a positive integer number until you receive "END". For each
numbered print, whether the number is palindrome or not.*/