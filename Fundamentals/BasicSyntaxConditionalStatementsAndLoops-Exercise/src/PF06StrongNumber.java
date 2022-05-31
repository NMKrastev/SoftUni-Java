import java.util.Scanner;

public class PF06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number;
        int totalSum = 0;

        while (number > 0 ) {
            int lastDigit = number % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            totalSum += fact;

            number = number / 10;
        }

        if (totalSum == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
/*Write a program to check if a given number is a strong number or not. A number is strong if the sum of the
Factorial of each digit is equal to the number. For example 145 is a strong number, because 1! + 4! + 5! = 145.
Print "yes" if the number is strong and "no" if the number is not strong.*/