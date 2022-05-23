import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        //boolean isPrime = false;

        for (int i = 2; i <= numOne; i += 2) {
            for (int j = 2; j <= numTwo; j++) {
                if (j == 2 || j == 3 || j == 5 || j == 7) {
                    for (int k = 2; k <= numThree; k += 2) {
                            System.out.printf("%d %d %d\n", i, j, k);
                    }
                }
            }
        }
    }
}
