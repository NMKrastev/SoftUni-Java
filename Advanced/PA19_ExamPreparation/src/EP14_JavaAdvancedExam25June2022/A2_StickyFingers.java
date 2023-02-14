package EP14_JavaAdvancedExam25June2022;

import java.util.Scanner;

public class A2_StickyFingers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix, "D");
        int currentCol = findCol(matrix, "D");
        matrix[currentRow][currentCol] = "+";
        int totalMoneyStolen = 0;

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        printOutsideOfMatrix();
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        printOutsideOfMatrix();
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        printOutsideOfMatrix();
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        printOutsideOfMatrix();
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("$")) {
                matrix[currentRow][currentCol] = "+";
                totalMoneyStolen += (currentRow * currentCol);
                System.out.printf("You successfully stole %d$.\n", currentRow * currentCol);
            } else if (matrix[currentRow][currentCol].equals("P")) {
                matrix[currentRow][currentCol] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoneyStolen);
                printMatrix(matrix);
                return;
            }
        }

        matrix[currentRow][currentCol] = "D";
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalMoneyStolen);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join(" ", current));
        }
    }

    private static void printOutsideOfMatrix() {
        System.out.println("You cannot leave the town, there is police outside!");
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

    private static String[][] fillMatrix(Scanner scanner, int dimension) {
        String[][] matrix = new String[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split(" ");
            matrix[row] = current;
        }
        return matrix;
    }
}
/*We get as input the size of the field in which Dillinger moves. The field is always a square.
After that, we receive the commands which represent the directions in which Dillinger should move.
Dillinger starts from D-position. The commands will be left/right/up/down.
If Dillinger reaches the side edge of the field (left, right, up, or down), he remains in his current position
and you have to print on the console "You cannot leave the town, there is police outside!".
When he successfully moves, replace his last position symbol with the regular position symbol "+".
The possible characters that may appear on the screen are:
•	+ - regular position on the field.
•	$ - house
•	D - Dillinger position
•	P – police
Each time when Dillinger finds a house, he robs it. When Dillinger robs a house replace "$" with "+",
calculate how much he has stolen by multiplying row and column indexes of the found symbol "$",
add the money to his pocket, and then print  "You successfully stole {calculated money}$.".
When he steps on "P", he gets caught, print on the console "You got caught with {total stolen money}$,
and you are going to jail.", and then the program ends. You have to replace stepped "P" with "#",
the matrix must not contain "D".
If his movement commands, get finished print on the console
"Your last theft has finished successfully with {total stolen money}$ in your pocket.".
The program ends when his movement commands get finished or when he gets caught by the police.
Input
•	Field size – an integer number.
•	Commands to move the sapper – an array of strings separated by ",".
•	The field: some of the following characters (+, $, D, P), separated by whitespace (" ");
Output
•	If the program finishes without Dillinger getting caught:
o	"Your last theft has finished successfully with {total stolen money}$ in your pocket."
•	If Dillinger gets caught:
o	"You got caught with {total stolen money}$, and you are going to jail."
•	In the end, print the matrix, and separate each symbol by " ".
Constraints
•	The size of the matrix will be between [2…40].
•	The players will always be indicated with "D".
•	Commands will be in the format of up, down, left or right.
*/
