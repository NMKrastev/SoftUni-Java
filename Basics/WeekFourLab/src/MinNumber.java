import java.util.Scanner;

public class MinNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int num = Integer.parseInt(scanner.nextLine());
        int min = Integer.MAX_VALUE;

        System.out.println("Enter the numbers: ");
        for (int i = 1; i <= num; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < min) {
                min = number;
            }
        }

        System.out.println("min = " + min);

    }
}