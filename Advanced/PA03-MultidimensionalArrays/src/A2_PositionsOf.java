import java.util.Scanner;

public class A2_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = scanner.nextInt();
            }
        }

        int searchNum = scanner.nextInt();
        //boolean isFound = false;
        //Use of SB and more specific .isEmpty() method
        //is not applicable for Judge system because it uses Java 13
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == searchNum) {
                    /*System.out.printf("%d %d\n", row, col);
                    isFound = true;*/
                    output
                            .append(row)
                            .append(" ")
                            .append(col)
                            .append(System.lineSeparator());
                }
            }
        }
        /*if (!isFound) {
            System.out.println("not found");
        }*/
        System.out.println(output.isEmpty() ? "not found" : output);
    }
}
/*Write a program that reads a matrix of integers from the console, then a number, and prints all the
positions at which that number appears in the matrix.
The matrix definition on the console will contain a line with two positive integer numbers R and C –
the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces),
representing each row of the matrix.
The number you will need to find the positions will be entered on a single line after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print "not found".
*/
