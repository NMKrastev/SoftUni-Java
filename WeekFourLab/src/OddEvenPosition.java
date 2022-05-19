import java.util.Scanner;

public class OddEvenPosition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double oddSum = 0;
        double evenSum = 0;
        double maxOdd = -Double.MAX_VALUE;
        double minOdd = Double.MAX_VALUE;
        double maxEven = -Double.MAX_VALUE;
        double minEven = Double.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            double number = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                evenSum += number;
                if (maxEven < number) {
                    maxEven = number;
                }
                if (minEven > number) {
                    minEven = number;
                }
            } else if (i % 2 != 0) {
                oddSum += number;
                if (maxOdd < number) {
                    maxOdd = number;
                }
                if (minOdd > number) {
                    minOdd = number;
                }
            }
        }

        if (n == 0) {
            System.out.printf("OddSum=%.2f\nOddMin=No\nOddMax=No\nEvenSum=%2f\nEvenMin=No\nEvenMax=No",
                    oddSum, evenSum);
        } else if (n == 1) {
            System.out.printf("OddSum=%.2f\nOddMin=%.2f\nOddMax=%.2f\nEvenSum=%.2f\nEvenMin=No\nEvenMax=No",
                    oddSum, minOdd, maxOdd, evenSum);
        } else {
            System.out.printf("OddSum=%.2f\nOddMin=%.2f\nOddMax=%.2f\nEvenSum=%.2f\nEvenMin=%.2f\nEvenMax=%.2f\n",
                    oddSum, minOdd, maxOdd, evenSum, minEven, maxEven);
        }

    }
}