import java.util.Scanner;

public class HalfSumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            if (number > max) {
                max = number;
            }
            sum += number;
        }

        sum = sum - max;

        if (sum == max) {
            System.out.println("Yes\nSum = " + sum);
        } else {
            int diff = Math.abs(sum - max);
            System.out.println("No\nDiff = " + diff);
        }
    }
}