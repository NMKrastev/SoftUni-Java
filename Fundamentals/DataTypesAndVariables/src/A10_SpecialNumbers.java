import java.util.Scanner;

public class A10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            int currentNum = i;
            int sum = 0;

            while (currentNum > 0) {
                sum += (currentNum % 10);
                currentNum = currentNum / 10;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True\n", i);
            } else {
                System.out.printf("%d -> False\n", i);
            }
        }
    }
}
/*A number is special when its sum of digits is 5, 7, or 11.
Write a program to read an integer n and for all numbers in the range 1…n to print the number
and if it is special or not (True / False).
Hints:
To calculate the sum of digits of given number num, you might repeat the following:
sum the last digit (num % 10) and remove it (sum = sum / 10) until the num reaches 0
*/
