import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A7_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> matrix = readMatrix(scanner);

        String input;
        while (!(input = scanner.nextLine()).equals("Nuke it from orbit")) {
            int positionRow = Integer.parseInt(input.split("\\s+")[0]);
            int positionCol = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);

            deleteFromUpToDown(matrix, positionRow, positionCol, radius);

            deleteFromRightToLeft(matrix, positionRow, positionCol, radius);

            matrix.removeIf(List::isEmpty);
        }

        printResult(matrix);
    }

    private static void printResult(List<List<Integer>> matrix) {

        for (List<Integer> currentRow : matrix) {
            for (int currentNum : currentRow) {
                System.out.print(currentNum + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> deleteFromRightToLeft(List<List<Integer>> matrix, int positionRow, int positionCol, int radius) {

        for (int i = positionCol + radius; i >= positionCol - radius; i--) {
            if (isIndexesInBounds(matrix, positionRow, i)) {
                matrix.get(positionRow).remove(i);
            }
        }

        return matrix;
    }

    private static List<List<Integer>> deleteFromUpToDown(List<List<Integer>> matrix, int positionRow, int positionCol, int radius) {

        for (int i = positionRow - radius; i <= positionRow + radius; i++) {
            if (isIndexesInBounds(matrix, i, positionCol) && i != positionRow) {
                matrix.get(i).remove(positionCol);
            }
        }

        return matrix;
    }

    private static boolean isIndexesInBounds(List<List<Integer>> matrix, int row, int col) {

        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> readMatrix(Scanner scanner) {

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }
        scanner.nextLine();

        return matrix;
    }
}
/*You will receive two integers, which represent the dimensions of a matrix. Then, you must fill the matrix with
increasing integers starting from 1, and continuing on every row, like this:
first row: 1, 2, 3, …, n
second row: n + 1, n + 2, n + 3, …, n + n
third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n
You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will represent
a row in the matrix, a column, and a radius. You must then destroy the cells, which correspond to those arguments cross-like.
Destroying a cell means that that cell becomes completely nonexistent in the matrix. Destroying cells cross-like means
that you form a cross figure with a center point - equal to the cell with coordinates – the given row and column, and
lines with length equal to the given radius. See the examples for more info.
The input ends when you receive the command "Nuke it from orbit". When that happens, you must print what has remained
from the initial matrix.
Input
•	On the first line, you will receive the dimensions of the matrix. You must then fill the matrix according to those dimensions.
•	On the next several lines, you will receive 3 integers separated by a single space representing the row, col,
and radius. It would help if you then destroyed cells according to those coordinates.
•	When you receive the command "Nuke it from orbit" the input ends.
Output
•	The output is simple. You must print what is left from the matrix.
•	Every row must be printed on a new line, and every column of a row - be separated by a space.
Constraints
•	The dimensions of the matrix will be integers in the range [2, 100].
•	The given rows and columns will be valid integers in the range [-231 + 1, 231 - 1].
•	 The radius will be in the range [0, 231 - 1].
•	Allowed time/memory: 250ms/16MB.
*/
