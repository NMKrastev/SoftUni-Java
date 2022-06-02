import java.util.Scanner;

public class PF12RefactorSpecialNumbers {
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
/*You are given a working code that is a solution to Problem 9. Special Numbers. However, the variables are
improperly named, declared before they are needed and some of them are used for multiple things.
Without using your previous solution, modify the code so that it is easy to read and understand.*/