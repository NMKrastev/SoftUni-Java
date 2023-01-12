import java.util.Arrays;
import java.util.Scanner;

public class A3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, dimension);

        int sumLeftToRight = getSumFomLeft(matrix);
        int sumRightToLeft = getSumFomRight(matrix);

        System.out.println(Math.abs(sumLeftToRight - sumRightToLeft));

    }

    private static int getSumFomRight(int[][] matrix) {

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][matrix.length - 1 - row];
        }

        return sum;
    }

    private static int getSumFomLeft(int[][] matrix) {

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }

        return sum;
    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {

        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = current;
        }

        return matrix;
    }
}
/*Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).
Input
•	The first line holds a number n – the size of matrix.
•	The next n lines hold the values for every row – n numbers separated by a space.
*/
