package EP13_JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Armory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[0-9]");
        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix, "A");
        int currentCol = findCol(matrix, "A");
        boolean isOutOfField = false;
        int totalBoughtSwords = 0;
        matrix[currentRow][currentCol] = "-";
        String input;
        while (true) {
            input = scanner.nextLine();
            switch (input) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        isOutOfField = true;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        isOutOfField = true;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        isOutOfField = true;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        isOutOfField = true;
                    }
                    break;
            }

            Matcher matcher = pattern.matcher(matrix[currentRow][currentCol]);

            if (isOutOfField) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.\n", totalBoughtSwords);
                matrix[currentRow][currentCol] = "-";
                printMatrix(matrix);
                return;
            } else if (matrix[currentRow][currentCol].equals("M")) {
                matrix[currentRow][currentCol] = "-";
                currentRow = findRow(matrix, "M");
                currentCol = findCol(matrix, "M");
                matrix[currentRow][currentCol] = "-";
            } else if (matcher.find()) {
                matrix[currentRow][currentCol] = "-";
                totalBoughtSwords += Integer.parseInt(matcher.group());
                if (totalBoughtSwords >= 65) {
                    System.out.println("Very nice swords, I will come back for more!");
                    System.out.printf("The king paid %d gold coins.\n", totalBoughtSwords);
                    matrix[currentRow][currentCol] = "A";
                    printMatrix(matrix);
                    return;
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join("", current));
        }
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix, String position) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals(position)) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix, String position) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals(position)) {
                    return row;
                }
            }
        }
        return -1;
    }

    private static String[][] fillMatrix(Scanner scanner, int dimension) {
        String[][] matrix = new String[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("");
            matrix[row] = current;
        }
        return matrix;
    }
}
/*You will be given an integer n for the size of the armory with a square shape. On the next n lines, you will receive
the rows of the armory. The army officer will be placed in a random position, marked with the letter 'A'.
On random positions, there will be swords, marked with a single digit (the price of the sword).
There may also be mirrors, the count will be either 0 or 2 and they are marked with the letter - 'M'.
All of the empty positions will be marked with '-'.
Each turn, you will tell the army officer which direction he should move.
Move commands will be: "up", "down", "left", "right". If the army officer moves to a sword,
he buys the sword for a price equal to the digit there and the sword disappears. If the army officer moves to a mirror,
he teleports on the position of the other mirror, and then both mirrors disappear. If you guide the army officer
out of the armory, he leaves with the swords that he has bought. In advance, you negotiate with the king,
that he'll buy at least 65 gold coins worth of blades.
The program ends when the army officer buys blades for at least 65 gold coins, or you guide him out of the armory.
Input
•	On the first line, you are given the integer n – the size of the matrix (armory).
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a move command.
Output
•	On the first line:
o	If the army officer leaves the armory, print: "I do not need more swords!"
o	If the army officer fulfills the initial deal, print: "Very nice swords, I will come back for more!"
•	On the second line print the profit you’ve made: "The king paid {amount} gold coins."
•	At the end print the final state of the matrix (armory).
Constraints
•	The size of the square matrix (armory) will be between [2…10].
•	There will always be 0 or 2 mirrors, marked with the letter - 'M'.
•	The army officer’s position will be marked as 'A'.
•	There will be always two output scenarios: the army officer leaves or bays swords worth at least 65 gold coins.
*/
