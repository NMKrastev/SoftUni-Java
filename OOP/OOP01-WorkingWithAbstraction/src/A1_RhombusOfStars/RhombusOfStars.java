package A1_RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopPart(n);
        printRow(n, n);
        printBottomPart(n);
    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printTopPart(int n) {
        for (int row = 1; row <= n - 1; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {

        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }
        for (int star = 1; star <= row; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
/*Create a program that reads a positive integer n as input and prints on the console a rhombus with size n:*/
