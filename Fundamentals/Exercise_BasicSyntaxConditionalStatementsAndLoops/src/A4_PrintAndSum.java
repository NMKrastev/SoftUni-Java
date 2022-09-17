import java.util.Scanner;

public class A4_PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = numOne; i <= numTwo ; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}
