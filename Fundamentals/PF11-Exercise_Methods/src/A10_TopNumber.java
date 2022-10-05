import java.util.Scanner;

public class A10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printTopNumbers(number);

    }

    private static void printTopNumbers(int number) {

        for (int i = 0; i <= number; i++) {

            int num = i;
            int sum = 0;
            int count = 0;

            while (num > 0) {
                int temp = num % 10;
                if (temp % 2 != 0) {
                    count++;
                }
                sum += temp;
                num = num / 10;
            }

            if (sum % 8 == 0 && count != 0) {
                System.out.println(i);
            }
        }
    }
}
/*Read an integer n from the console. Find all top numbers in the range [1 … n] and print them.
A top number holds the following properties:
•	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
•	Holds at least one odd digit, e.g. 232, 707, 87578.
*/