import java.util.Scanner;

public class A1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int dimension = Integer.parseInt(input.split(",\\s+")[0]);
        String pattern = input.split(",\\s+")[1];
        int[][] matrix = new int[dimension][dimension];

        if (pattern.equals("A")) {
            getPatternA(matrix);
        } else {
            getPatternB(matrix);
        }

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void getPatternB(int[][] matrix) {

        int col = 0;
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (col % 2 == 0) {
                matrix[row][col] = counter;
                counter++;
            } else {
                for (int innerRow = matrix.length - 1; innerRow >= 0; innerRow--) {
                    matrix[innerRow][col] = counter;
                    counter++;
                }
                row = matrix.length - 1;
            }
            if (row == matrix.length - 1 && col != matrix.length - 1) {
                row = -1;
                col++;
            }
        }
    }

    private static void getPatternA(int[][] matrix) {

        int col = 0;
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = counter;
            counter++;
            if (row == matrix.length - 1 && col != matrix.length - 1) {
                row = -1;
                col++;
            }
        }
    }
}
/*Filling a matrix regularly (top to bottom and left to right) is boring.
Write two methods that fill a size N x N matrix in two different patterns.*/