import java.util.Scanner;

public class A2_BlindMansBuff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = fillMatrix(scanner, rows, cols);
        int currentRow = findRow(matrix, "B");
        int currentCol = findCol(matrix, "B");
        int touchedOpponents = 0;
        int movesMade = 0;


        String input;
        while (!(input = scanner.nextLine()).equals("Finish")) {

            switch (input) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                        if (isOpponentOrObstacle(matrix, currentRow, currentCol, "P")) {
                            touchedOpponents++;
                            movesMade++;
                            matrix[currentRow][currentCol] = "-";
                        } else if (isOpponentOrObstacle(matrix, currentRow, currentCol, "O")) {
                            currentRow++;
                            continue;
                        } else {
                            movesMade++;
                        }
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                        if (isOpponentOrObstacle(matrix, currentRow, currentCol, "P")) {
                            touchedOpponents++;
                            movesMade++;
                            matrix[currentRow][currentCol] = "-";
                        } else if (isOpponentOrObstacle(matrix, currentRow, currentCol, "O")) {
                            currentRow--;
                            continue;
                        } else {
                            movesMade++;
                        }
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                        if (isOpponentOrObstacle(matrix, currentRow, currentCol, "P")) {
                            touchedOpponents++;
                            movesMade++;
                            matrix[currentRow][currentCol] = "-";
                        } else if (isOpponentOrObstacle(matrix, currentRow, currentCol, "O")) {
                            currentCol++;
                            continue;
                        } else {
                            movesMade++;
                        }
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                        if (isOpponentOrObstacle(matrix, currentRow, currentCol, "P")) {
                            touchedOpponents++;
                            movesMade++;
                            matrix[currentRow][currentCol] = "-";
                        } else if (isOpponentOrObstacle(matrix, currentRow, currentCol, "O")) {
                            currentCol--;
                            continue;
                        } else {
                            movesMade++;
                        }
                    }
                    break;
            }

            if (touchedOpponents == 3) {
                printResult(touchedOpponents, movesMade);
                return;
            }
        }

        printResult(touchedOpponents, movesMade);
    }

    private static void printResult(int touchedOpponents, int movesMade) {
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, movesMade);
    }

    private static boolean isOpponentOrObstacle(String[][] matrix, int currentRow, int currentCol, String opponentOrObstacle) {
        return matrix[currentRow][currentCol].equals(opponentOrObstacle);
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

    private static String[][] fillMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("\\s+");
            matrix[row] = current;
        }
        return matrix;
    }
}
/*You will be given N and M – integers, indicating the playground’s dimensions.
On the next N lines, you will receive the rows of the playground, with M columns.
You will be marked with the letter 'B', and placed in a random position. In random positions,
furniture or other obstacles will be marked with the letter 'O'.
The other players (opponents) will be marked with the letter 'P'.
There will always be three other players participating in the game. All of the empty positions will be marked with '-'.
Your goal is to touch as many players as possible during the game, without leaving the playground or stepping on an obstacle.
On the next few lines, until you receive the command "Finish",
you will receive a few lines with commands representing which direction you need to move.
The possible directions are "up", " down", "right", and "left". If the direction leads you out of the field,
you need to stay in position inside the field(do NOT make the move). If you have an obstacle, towards the direction,
do NOT make the move and wait for the next command.
You need to keep track of the count of touched opponents and the moves you’ve made.
In case you step on a position marked with '-', increase the count of the moves made.
When you receive a command with direction, you check the position you need to step on for an obstacle or opponent.
If there is an opponent, you touch him and the position is marked with '-'
(increase the count of the touched opponents and moves made), and this is your new position.
The game is over when you manage to touch all other opponents or the given command is "Finish".
A game report is printed on the Console:
"Game over!"
"Touched opponents: {count} Moves made: {count}"
Input
•	On the first line, you'll receive the dimensions of the playground in format: "N M",
where N is the number of rows, and M is the number of columns. They'll be separated by a single space (" ").
•	On the next N lines, you will receive a string representing the respective row of the playground.
The positions in every string will be separated by a single space (" ").
•	On the next few lines, until you receive the command "Finish", you will be given directions (up, down, right, left).
Output
•	When the game is over, the following output should be printed on the Console:
"Game over!"
"Touched opponents: {count} Moves made: {count}"
Constraints
•	The playground size will be a 32-bit integer in the range [2 … 2 147 483 647].
•	The playground will always have three opponents in it - 'P'.
•	The obstacles on the playground will always be random count, and there will be cases without any obstacles.
*/
