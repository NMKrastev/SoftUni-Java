import java.util.Scanner;

public class PF10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int currentNUm = i;
            int sum = 0;

            while (currentNUm > 0) {
                sum += (currentNUm % 10);
                currentNUm = currentNUm / 10;
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
*/