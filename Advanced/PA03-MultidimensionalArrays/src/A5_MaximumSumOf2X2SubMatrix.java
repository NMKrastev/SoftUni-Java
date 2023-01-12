import java.util.Arrays;
import java.util.Scanner;

public class A5_MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(",\\s+")[0]);
        int cols = Integer.parseInt(input.split(",\\s+")[1]);

        int[][] matrix = new int[rows][cols];
        initializeMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = -1;
        int colIndex = -1;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                int currentSum = matrix[row][col] + matrix[row + 1][col] + matrix[row][col + 1] + matrix[row + 1][col + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        System.out.printf("%d %d\n%d %d\n%d", matrix[rowIndex][colIndex], matrix[rowIndex][colIndex + 1],
                matrix[rowIndex + 1][colIndex], matrix[rowIndex + 1][colIndex + 1],
                maxSum);
    }

    private static void initializeMatrix(Scanner scanner, int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = current;
        }
    }
}
/*Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix.
Print the subMatrix and its sum.
On the first line, you will get the matrix dimensions in the format "{rows, columns}".
On the next lines, you will get the elements for each row separated by a comma.
*/
