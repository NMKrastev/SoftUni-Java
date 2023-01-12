import javax.swing.*;
import java.util.Scanner;

public class A2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        StringBuilder output = getPalindromesMatrix(matrix);

        System.out.println(output);
    }

    private static StringBuilder getPalindromesMatrix(int[][] matrix) {

        StringBuilder output = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            char endSymbols = (char) (97 + row);
            char middleSymbol = (char) (97 + row);
            for (int col = 0; col < matrix[row].length; col++) {
                output.append(endSymbols);
                output.append(middleSymbol);
                output.append(endSymbols);
                output.append(" ");
                middleSymbol++;
            }

            output.append(System.getProperty("line.separator"));
        }

        return output;
    }
}
/*Write a program to generate the following matrix of palindromes of 3 letters
with r rows and c columns like the one in the examples below.
•	Rows define the first and the last letter: row 0 -> ‘a’, row 1 -> ‘b’, row 2 -> ‘c’, …
•	Columns + rows define the middle letter:
o	column 0, row 0 -> ‘a’, column 1, row 0 -> ‘b’, column 2, row 0 -> ‘c’, …
o	column 0, row 1 -> ‘b’, column 1, row 1 -> ‘c’, column 2, row 1 -> ‘d’, …
Input
•	The numbers r and c stay in the first line at the input.
•	 r and c are integers in the range [1…26].
•	 r + c ≤ 27
*/
