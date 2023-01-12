import java.util.Arrays;
import java.util.Scanner;

public class A4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(",\\s+")[0]);
        int cols = Integer.parseInt(input.split(",\\s+")[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < current.length; col++) {
                sum += current[col];
            }
            matrix[row] = current;
        }

        System.out.printf("%d\n%d\n%d", rows, cols, sum);
    }
}
/*Write a program that reads a matrix from the console and prints:
•	The count of rows
•	The count of columns
•	The sum of all matrix's elements
On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines,
you will get the elements for each row separated by a comma.
*/
