import java.util.Scanner;

public class OddEvenSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= num; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        if (evenSum == oddSum) {
            System.out.println("Yes\nSum = " + evenSum);
        } else {
            int diff = Math.abs(evenSum - oddSum);
            System.out.println("No\nDiff = " + diff);
        }
    }
}