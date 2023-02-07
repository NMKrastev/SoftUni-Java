package EP6_JavaAdvancedExam20February2021;

import java.util.Scanner;

public class A2_Bomb {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = fillMatrix(scanner, dimensions);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        int bombsCount = findBombs(matrix);
        matrix[currentRow][currentCol] = "+";

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("B")) {
                matrix[currentRow][currentCol] = "+";
                bombsCount--;
                System.out.println("You found a bomb!");
                if (bombsCount == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[currentRow][currentCol].equals("e")) {
                System.out.printf("END! %d bombs left on the field\n", bombsCount);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n", bombsCount, currentRow, currentCol);
    }

    private static int findBombs(String[][] matrix) {
        int bombsCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    bombsCount++;
                }
            }
        }
        return bombsCount;
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals("s")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("s")) {
                    return row;
                }
            }
        }
        return -1;
    }

    private static String[][] fillMatrix(Scanner scanner, int dimension) {
        String[][] matrix = new String[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("\\s+");
            matrix[row] = current;
        }
        return matrix;
    }
}
/*We get as input the size of the field in which our sapper moves. The field is always a square.
After that, we receive the commands which represent the directions in which the sapper should move.
The sapper starts from the s-position The commands will be left/right/up/down.
If the sapper reaches the side edge of the field (left, right, up, or down), it remains in its current position.
The possible characters that may appear on the screen are:
•	+ – regular position on the field.
•	e – end of the route.
•	B – bomb
•	s – the place where the sapper starts
Each time when sapper finds a bomb, he deactivates it, and replace "B" with "+". Keep track of the count of the bombs.
Each time you find a bomb, you have to print the following message: "You found a bomb!".
If the sapper steps at the end of the route game are over (the program stops) and you have to print the output
as shown in the output section. After executing all of the commands there are only 2 possible outcomes (there are not going to be more cases):
•	if you found all bombs – you win and the game ends
•	if you reach the endpoint ("e"), you have to stop
Print the corresponding output depending on the case.
Input
•	Field size – an integer number.
•	Commands to move the sapper – an array of strings separated by ",".
•	The field: some of the following characters (+, e, B, s), separated by whitespace (" ");
Output
•	There are three types of output:
o	If all of the bombs have cleared print the following output: "Congratulations! You found all bombs!"
o	If you reached the end, you have to stop moving and print the following line: "END! {bombs left} bombs left on the field"
o	If there are no more commands and none of the above cases happens, you have to print the following message:
"{bombs left} bombs left on the field. Sapper position: ({row},{col})"
Constraints
•	The input numbers will be a 32-bit integer in the range [0 … 2 147 483 647].
•	Allowed working time for your program: 0.1 seconds.
•	Allowed memory: 16 MB.
*/
