import java.util.Arrays;
import java.util.Scanner;

public class A11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, rows);

        for (int col = cols - 1; col >= 0; col--) {
            int currentRow = rows;
            for (int currentCol = col; currentCol <= cols - 1 && currentRow > 0; currentCol++) {

                System.out.print(matrix[currentRow - 1][currentCol] + " ");
                currentRow--;
            }

            System.out.println();
        }

        if (rows >= 2) {
            for (int row = rows - 2; row >= 0; row--) {
                int currentRow = row;
                for (int col = 0; col <= row && col < cols; col++) {
                    System.out.print(matrix[currentRow][col] + " ");
                    currentRow--;
                }
                System.out.println();
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {

        int[][] matrix = new int[rows][];
        scanner.nextLine();
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = current;
        }

        return matrix;
    }
}
/*You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order.
Print each diagonal on a new line.
Input
On the first line, single integer the number R of rows in the matrix. On each of the next R lines,
C numbers are separated by single spaces. Note that R and C may have different values.
Output
The output should consist of R lines, each consisting of exactly C characters, separated by spaces,
representing the matrix diagonals reversed.
*/
