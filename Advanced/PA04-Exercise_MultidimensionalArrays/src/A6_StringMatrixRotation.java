import java.util.ArrayDeque;
import java.util.Scanner;

public class A6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]", ""));
        degree = degree % 360;
        String command = String.format("Rotate(%d)", degree);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String input;
        int maxColLength = Integer.MIN_VALUE;
        while (!(input = scanner.nextLine()).equals("END")) {

            queue.offer(input);
            if (input.length() > maxColLength) {
                maxColLength = input.length();
            }
        }

        int rowSize = queue.size();
        char[][] matrix = readMatrix(scanner, queue, maxColLength);

        if (command.contains("Rotate(90)")) {
            char[][] matrix90 = getMatrix90(matrix, rowSize, maxColLength);
            printMatrix(matrix90);
        } else if (command.contains("Rotate(180)")) {
            char[][] matrix180 = getMatrix180(matrix, rowSize, maxColLength);
            printMatrix(matrix180);
        } else if (command.contains("Rotate(270)")) {
            char[][] matrix270 = getMatrix270(matrix, rowSize, maxColLength);
            printMatrix(matrix270);
        } else if (command.contains("Rotate(360)") || command.contains("Rotate(0)")) {
            printMatrix(matrix);
        }
    }

    private static char[][] getMatrix90(char[][] matrix, int rowSize, int maxColLength) {

        char[][] matrix90 = new char[maxColLength][rowSize];
        for (int col = 0; col < matrix[rowSize - 1].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                matrix90[col][matrix.length - 1 - row] = matrix[row][col];
            }
        }

        return matrix90;
    }

    private static char[][] getMatrix180(char[][] matrix, int rowSize, int maxColLength) {

        char[][] matrix180 = new char[rowSize][maxColLength];
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                matrix180[matrix.length - 1 - row][matrix[row].length - 1 - col] = matrix[row][col];
            }
        }
        return matrix180;
    }

    private static char[][] getMatrix270(char[][] matrix, int rowSize, int maxColLength) {

        char[][] matrix270 = new char[maxColLength][rowSize];
        for (int col = matrix[rowSize - 1].length - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                matrix270[matrix[rowSize - 1].length - 1 - col][row] = matrix[row][col];
            }
        }

        return matrix270;
    }

    private static char[][] readMatrix(Scanner scanner, ArrayDeque<String> queue, int maxColLength) {

        char[][] matrix = new char[queue.size()][maxColLength];
        for (int row = 0; row < matrix.length; row++) {
            String currentWord = queue.poll();
            for (int col = 0; col < matrix[row].length; col++) {
                if (currentWord != null) {
                    if (col >= currentWord.length()) {
                        matrix[row][col] = ' ';
                    } else {
                        matrix[row][col] = currentWord.charAt(col);
                    }
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {

        for (char[] current : matrix) {
            for (char symbol : current) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
/*You are given a sequence of text lines. Assume these text lines form a matrix of characters
(pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate the matrix
by 90, 180, 270, 360,… degrees. Print the result as a sequence of strings at the console after receiving the "END" command.
Input
The input is read from the console:
•	The first line holds the command in the format "Rotate(X)" where X is the degrees of the requested rotation.
•	The next lines contain the lines of the matrix for rotation.
•	The input ends with the command "END".
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
Print at the console the rotated matrix as a sequence of text lines.
Constraints
•	The rotation degree is a positive integer in the range [0…90000], where degrees are multiple of 90.
•	The number of matrix lines is in the range [1…1 000].
•	The matrix lines are strings of length 1 … 1 000.
•	It allowed a working time: 200ms/16MB.
*/
