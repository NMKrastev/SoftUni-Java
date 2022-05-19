import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int n;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < num; i++) {
            n = Integer.parseInt(scanner.nextLine());

            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }

        }

        System.out.printf("Max number: %d\nMin number: %d", max, min);

    }
}
