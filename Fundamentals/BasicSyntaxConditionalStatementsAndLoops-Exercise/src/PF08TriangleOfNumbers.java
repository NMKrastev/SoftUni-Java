import java.util.Scanner;

public class PF08TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
/*Write a program, which receives a number – n, and prints a triangle from 1 to n as in the examples.
Constraints
•	n will be in the interval [1...20].
*/