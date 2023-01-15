import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A12_TheMatrix {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        char[][] matrix = readMatrix(scanner, rows, cols);
        char fillChar = scanner.nextLine().trim().charAt(0);
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        char startChar = matrix[startRow][startCol];

        spreadChar(matrix, startRow, startCol, fillChar, startChar);

        System.out.println(Arrays.stream(matrix).map(String::new)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static void spreadChar(char[][] matrix, int startRow, int startCol, char fillChar, char startChar) {

        if (matrix[startRow][startCol] != startChar) {
            return;
        }

        matrix[startRow][startCol] = fillChar;

        if (startRow + 1 < matrix.length) {
            spreadChar(matrix, startRow + 1, startCol, fillChar, startChar);
        }
        if (startRow - 1 >= 0) {
            spreadChar(matrix, startRow - 1, startCol, fillChar, startChar);
        }
        if (startCol + 1 < matrix[startRow].length) {
            spreadChar(matrix, startRow, startCol + 1, fillChar, startChar);
        }
        if (startCol - 1 >= 0) {
            spreadChar(matrix, startRow, startCol - 1, fillChar, startChar);
        }

    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];
        scanner.nextLine();

        for (int row = 0; row < matrix.length; row++) {
            char[] current = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

            matrix[row] = current;
        }

        return matrix;
    }
}
/*You are given a matrix (2D array) of lowercase alphanumeric characters (a-z, 0-9), a starting position –
defined by a start row startRow and a start column startCol – and a filling symbol fillChar. Let's call the symbol
originally at startRow and startCol the startChar. Write a program, which, starting from the symbol at startRow and
startCol, changes to fillChar every symbol in the matrix which:
•	is equal to startChar AND
•	can be reached from startChar by going up (row – 1), down (row + 1), left (col – 1) and right (col + 1) and
“stepping” ONLY on symbols equal startChar
So, you basically start from startRow and startCol and can move either by changing the row OR column
(not both at once, i.e. you can't go diagonally) by 1 and can only go to positions that have the startChar
written on them. Once you find all those positions, you change them to fillChar.
In other words, you need to implement something like the Fill tool in MS Paint, but for a 2D char array instead of a bitmap.
Input
On the first line, two integers will be entered – the number R of rows and number C of columns.
On each of the next R lines, C characters separated by single spaces will be entered – the symbols of the Rth row of
the matrix, starting from the 0th column and ending at the C-1 column.
On the next line, a single character – the fillChar – will be entered.
On the last line, two integers – startRow and startCol – will be entered, separated by a single space.
Output
The output should consist of R lines, each consisting of exactly C characters, NOT SEPARATED by spaces, representing
the matrix after the fill operation has been finished.
Constraints
0 < R, C < 20
0 <= startRow < R
0 <= startCol < C
All symbols in the input matrix will be lowercase alphanumerics (a-z, 0-9). The fillChar will also be alphanumeric and lowercase.
The total running time of your program should be no more than 0.1s.
The total memory allowed for use by your program is 5MB.
*/
