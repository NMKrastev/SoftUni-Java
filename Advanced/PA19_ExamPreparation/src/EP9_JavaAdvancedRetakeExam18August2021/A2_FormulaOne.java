package EP9_JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class A2_FormulaOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        int numOfCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimensions);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        matrix[currentRow][currentCol] = ".";
        String command;
        for (int i = 0; i < numOfCommands; i++) {
            command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        currentRow = matrix.length - 1;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow - 1, currentCol, matrix)) {
                            currentRow--;
                        } else {
                            currentRow = matrix.length - 1;
                        }
                    } else if (matrix[currentRow][currentCol].equals("T")) {
                        if (isInBounds(currentRow + 1, currentCol, matrix)) {
                            currentRow++;
                        } else {
                            currentRow = 0;
                        }
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        currentRow = 0;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow + 1, currentCol, matrix)) {
                            currentRow++;
                        } else {
                            currentRow = 0;
                        }
                    } else if (matrix[currentRow][currentCol].equals("T")) {
                        if (isInBounds(currentRow - 1, currentCol, matrix)) {
                            currentRow--;
                        } else {
                            currentRow = matrix.length - 1;
                        }
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        currentCol = matrix.length - 1;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow, currentCol - 1, matrix)) {
                            currentCol--;
                        } else {
                            currentCol = matrix.length - 1;
                        }
                    } else if (matrix[currentRow][currentCol].equals("T")) {
                        if (isInBounds(currentRow, currentCol + 1, matrix)) {
                            currentCol++;
                        } else {
                            currentCol = 0;
                        }
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        currentCol = 0;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        if (isInBounds(currentRow, currentCol + 1, matrix)) {
                            currentCol++;
                        } else {
                            currentCol = 0;
                        }
                    } else if (matrix[currentRow][currentCol].equals("T")) {
                        if (isInBounds(currentRow, currentCol - 1, matrix)) {
                            currentCol--;
                        } else {
                            currentCol = matrix.length - 1;
                        }
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("F")) {
                matrix[currentRow][currentCol] = "P";
                System.out.println("Well done, the player won first place!");
                printMatrix(matrix);
                return;
            }
        }
        System.out.println("Oh no, the player got lost on the track!");
        matrix[currentRow][currentCol] = "P";
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
                if (strings[col].equals("P")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
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
(the player is marked with "P") and all of the empty slots will be filled with "." (dot).
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
o	"Well done, the player won first place!"
•	If the player reaches the commands count and hasn’t reached the finish mark print:
o	"Oh no, the player got lost on the track!"
•	At the end print the matrix.
Constraints
•	The size of the matrix will be between [2…20].
•	The players will always be indicated with "P".
•	If the player steps on the finish mark at the same time as his last command, he wins the game.
•	When the final matrix is printed and the vehicle has been completed successfully, you must replace the "F" with the "P".
•	Commands will be in the format of up, down, left or right.
•	There won't be a case where you bypass the finish while you are on a trap or a bonus.
•	A trap will never place you into a bonus or another trap and a bonus will never place you into a trap or another bonus.
*/
