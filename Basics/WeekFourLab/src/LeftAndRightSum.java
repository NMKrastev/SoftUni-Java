import java.util.Scanner;

public class LeftAndRightSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < 2 * n; i++) {

            int num = Integer.parseInt(scanner.nextLine());

            if (i < n) {
                sumLeft += num;
            } else {
                sumRight += num;
            }
        }

        if (sumLeft == sumRight) {
            System.out.println("Yes, sum = " + sumLeft);
        } else {
            int diff = Math.abs(sumLeft - sumRight);
            System.out.println("No, diff = " + diff);
        }
    }
}