package JavaAdvancedExam22Feb2020;

import java.util.Scanner;

public class A2_ReVolt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int numOfCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        int tempRowCol = 0;
        boolean isWon = false;
        matrix[currentRow][currentCol] = "-";
        while (numOfCommands-- > 0) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        tempRowCol = currentRow;
                        currentRow--;
                    } else {
                        tempRowCol = currentRow;
                        currentRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        tempRowCol = currentRow;
                        currentRow++;
                    } else {
                        tempRowCol = currentRow;
                        currentRow = 0;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        tempRowCol = currentCol;
                        currentCol--;
                    } else {
                        tempRowCol = currentCol;
                        currentCol = matrix[currentRow].length - 1;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        tempRowCol = currentCol;
                        currentCol++;
                    } else {
                        tempRowCol = currentCol;
                        currentCol = 0;
                    }
                    break;
            }

            switch (command) {
                case "up":
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentRow = tempRowCol;
                    } else if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow - 1, currentCol, matrix)) {
                            currentRow--;
                        } else {
                            currentRow = matrix.length - 1;
                        }
                    }
                    break;
                case "down":
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentRow = tempRowCol;
                    } else if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow + 1, currentCol, matrix)) {
                            currentRow++;
                        } else {
                            currentRow = 0;
                        }
                    }
                    break;
                case "left":
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentCol = tempRowCol;
                    } else if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow, currentCol - 1, matrix)) {
                            currentCol--;
                        } else {
                            currentCol = matrix.length - 1;
                        }
                    }
                    break;
                case "right":
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentCol = tempRowCol;
                    } else if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow, currentCol + 1, matrix)) {
                            currentCol++;
                        } else {
                            currentCol = 0;
                        }
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("F")) {
                isWon = true;
                break;
            }
        }

        matrix[currentRow][currentCol] = "f";
        System.out.println(isWon
                ? "Player won!"
                : "Player lost!");
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join("", current));
        }
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals("f")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
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
/*You will be given an integer N for the size of the square matrix and then an integer for the count of commands.
On the next n lines, you will receive the rows of the matrix. The player starts at a random position
(the player is marked with "f") and all of the empty slots will be filled with "-" (dash).
The goal is to reach the finish mark which will be marked with an "F". On the field, there can also be bonuses and traps.
Bonuses are marked with "B" and traps are marked with "T".
Each turn you will be given commands for the player’s movement. If the player goes out of the matrix,
he comes in from the other side. For example, if the player is on 0, 0 and the next command is left,
he goes to the last spot on the first row.
If the player steps on a bonus, he should move another step forward in the direction he is going.
If the player steps on a trap, he should move a step backward.
When the player reaches the finish mark or the count of commands is reached, the game ends.
Input
•	On the first line, you are given the integer N – the size of the square matrix.
•	On the second you are given the count of commands.
•	The next N lines hold the values for every row.
•	On each of the next lines, you will get commands for movement directions.
Output
•	If the player reaches the finish mark, print:
o	"Player won!"
•	If the player reaches the commands count and hasn’t reached the finish mark print:
o	"Player lost!"
•	At the end print the matrix.
Constraints
•	The size of the matrix will be between [2…20].
•	The players will always be indicated with "f".
•	If the player steps on the finish mark at the same time as his last command, he wins the game.
•	Commands will be in the format of up, down, left or right.
•	There won't be a case where you bypass the finish while you are on a trap or a bonus.
•	A trap will never place you into a bonus or another trap and a bonus will never place you into a trap or another bonus.
*/