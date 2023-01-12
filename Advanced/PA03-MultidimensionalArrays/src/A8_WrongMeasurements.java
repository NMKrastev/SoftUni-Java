import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A8_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, rows);

        int rowPosition = scanner.nextInt();
        int colPosition = scanner.nextInt();
        int wrongValue = matrix[rowPosition][colPosition];

        List<int[]> correctValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int correctValue = getSum(matrix, row, col, wrongValue);
                    correctValues.add(new int[]{row, col, correctValue});
                }
            }
        }

        for (int[] correctValue : correctValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }

        for (int[] currentRow : matrix) {
            for (int num : currentRow) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static int getSum(int[][] matrix, int row, int col, int wrongValue) {

        int sum = 0;

        if (isIndexInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isIndexInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        if (isIndexInBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (isIndexInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static boolean isIndexInBounds(int[][] matrix, int row, int col) {

        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

 /*   private static boolean isIndexOutOfBounds(int[][] matrix, int row, int col) {

        return !isIndexInBounds(matrix, row, col);
    }*/

    private static int[][] readMatrix(Scanner scanner, int rows) {

        int[][] matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = current;
        }

        return matrix;
    }
}
/*You will be given the rows of a matrix. Then the matrix itself. Inside this matrix, there are mistaken values that
need to be replaced. You will receive the wrong value at the last line. Those values should be replaced with the sum
of the nearest elements in the four directions, up, down, left, and right, but only if they are valid values.
In the end, you have to print the fixed measurements. */
