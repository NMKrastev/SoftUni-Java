package EP15_JavaAdvancedRetakeExam18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_TreasureHunt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = fillMatrix(scanner, rows, cols);
        int currentRow = findRow(matrix, "Y");
        int currentCol = findCol(matrix, "Y");
        List<String> correctPath = new ArrayList<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Finish")) {

            switch (input) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                        if (!checkForTree(matrix, currentRow, currentCol)) {
                            correctPath.add(input);
                        } else {
                            currentRow++;
                        }
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                        if (!checkForTree(matrix, currentRow, currentCol)) {
                            correctPath.add(input);
                        } else {
                            currentRow--;
                        }
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                        if (!checkForTree(matrix, currentRow, currentCol)) {
                            correctPath.add(input);
                        } else {
                            currentCol++;
                        }
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                        if (!checkForTree(matrix, currentRow, currentCol)) {
                            correctPath.add(input);
                        } else {
                            currentCol--;
                        }
                    }
                    break;
            }
        }
        System.out.println(matrix[currentRow][currentCol].equals("X")
                ? String.format("I've found the treasure!\nThe right path is %s", correctPath.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")))
                : "The map is fake!");
    }

    private static boolean checkForTree(String[][] matrix, int currentRow, int currentCol) {
        return matrix[currentRow][currentCol].equals("T");
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix, String symbol) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals(symbol)) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix, String symbol) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals(symbol)) {
                    return row;
                }
            }
        }
        return -1;
    }

    private static String[][] fillMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("\\s+");
            matrix[row] = current;
        }
        return matrix;
    }
}

/*You will be given N and M – integers, indicating the field's dimensions, shown on the secret map.
On the next N lines, you will receive the rows of the field. You will be placed in a random position,
marked with the letter 'Y'. On random positions, there will be trees marked with the letter 'T'.
The treasure is marked with the letter 'X'. All of the empty positions will be marked with '-'.
You will receive a few lines with commands representing which direction you need to move.
The possible directions are up, down, right, and left.
If you go out of the field, you need to stay in the last possible position inside the field.
If you step on a tree (position marked with 'T'), go one step back to the direction you came from (not make a move).
If the given command is "Finish" you need to check the position you are standing on.
If it is marked with 'X' this means you have found the treasure, and you have to print the following message:
"I've found the treasure!". Then print the correct directions you went to in order to find the treasure.
Otherwise, print: "The map is fake!".
Input
•	On the first line, you'll receive the field dimensions in the format: "N M", where N is the number of rows,
and M is the number of columns. They'll be separated by a single space (" ").
•	On the next N lines, you will receive a string representing the respective row of the field.
The positions in every string will be separated by a single space (" ").
•	On the next few lines, until you receive the command "Finish", you will be given directions (up, down, right, left).
Output
•	There are two types of output:
o	If you have found the treasure (the last step is on a position marked with 'X')
print the following output: "I've found the treasure!".
On the next line, print the correct directions you went to find the treasure
(do not include the directions that made you go out of the field or step on a tree).
The directions must be separated by a comma and space (", "). It should look like this:
"The right path is {direction1}, {direction2}, …".
o	If you have not found the treasure, print the following message: "The map is fake!".
Constraints
•	The field size will be a 32-bit integer in the range [0 … 2 147 483 647].
•	The field will always have only one 'X' and only one 'Y'.
•	If the steps are invalid, do not include them in the result.
*/