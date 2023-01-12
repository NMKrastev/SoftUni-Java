import java.util.Arrays;
import java.util.Scanner;

public class A6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        printDiagonals(matrix);

    }

    private static void printDiagonals(int[][] matrix) {

        int index = 0;
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][index] + " ");
            index++;
        }

        System.out.println();

        index = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            System.out.print(matrix[row][index] + " ");
            index++;
        }
    }

    private static int[][] readMatrix(Scanner scanner) {

        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = current;
        }

        return matrix;
    }
}
/*Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square.
On the first line, you read a single integer N the matrix size. Then on each line N elements.
The first diagonal should always start with the element at the first row and col.
The second diagonal should start with the element at the last row and first col.*/
