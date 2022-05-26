import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int num = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;

        System.out.println("Enter the numbers: ");
        for (int i = 0; i < num; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > max) {
                max = number;
            }
        }

        System.out.println("max = " + max);

    }
}