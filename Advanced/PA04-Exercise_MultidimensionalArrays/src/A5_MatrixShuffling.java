import java.util.Scanner;

public class A5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = readMatrix(scanner, rows, cols);

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] currentCommand = input.split("\\s+");
            if (currentCommand[0].contains("swap") && currentCommand.length == 5) {
                try {
                    int row = Integer.parseInt(currentCommand[1]);
                    int col = Integer.parseInt(currentCommand[2]);
                    int replacementRow = Integer.parseInt(currentCommand[3]);
                    int replacementCol = Integer.parseInt(currentCommand[4]);
                    if (isIndexInBounds(matrix, row, col, replacementRow, replacementCol)) {
                        String temp = matrix[row][col];
                        matrix[row][col] = matrix[replacementRow][replacementCol];
                        matrix[replacementRow][replacementCol] = temp;
                        for (String[] currentRow : matrix) {
                            for (String position : currentRow) {
                                System.out.print(position + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static boolean isIndexInBounds(String[][] matrix, int row, int col, int replacementRow, int replacementCol) {

        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length
                && replacementRow >= 0 && replacementRow < matrix.length && replacementCol >= 0 && replacementCol < matrix[row].length;
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("\\s+");

            matrix[row] = current;
        }

        return matrix;
    }
}
/*Write a program which reads a string matrix from the console and performs certain operations with its elements.
User input is provided similarly to the problems above – first, you read the dimensions and then the data.
Your program should then receive commands in the format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are
coordinates in the matrix. For a command to be valid, it should start with the "swap" keyword along with four valid
coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1]
with cell [row2, col2]) and print the matrix at each step (this you'll be able to check if the operation was performed correctly).
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered, or the given
coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.
*/
