import java.util.Arrays;
import java.util.Scanner;

public class A4_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = readMatrix(scanner, rows);

        getMaxSum(matrix);
    }

    private static void getMaxSum(int[][] matrix) {

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentSum = 0;
                if (isIndexInBounds(matrix, row, col)) {
                    currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                            matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                            matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        startRow = row;
                        startCol = col;
                    }
                }
            }
        }

        printResult(matrix, maxSum, startRow, startCol);
    }

    private static void printResult(int[][] matrix, int maxSum, int startRow, int startCol) {

        System.out.printf("Sum = %d\n", maxSum);
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static boolean isIndexInBounds(int[][] matrix, int row, int col) {

        return row + 2 < matrix.length && col + 2 < matrix[row].length;
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {

        int[][] matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = current;
        }

        return matrix;
    }
}
/*Write a program that reads a rectangular integer matrix of size N x M and finds the square 3 x 3 with a maximal sum of its elements.
Input
•	On the first line, you will receive the rows N and columns M.
•	On the next N lines, you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below.
*/
