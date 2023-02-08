package EP8_JavaAdvancedExam26June2021;

import java.util.Scanner;

public class A2_Python {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",\\s+");
        String[][] matrix = fillMatrix(scanner, dimensions);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        int pythonLength = 1;
        int foodCount = findFoodCount(matrix);
        matrix[currentRow][currentCol] = "*";

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        currentRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        currentRow = 0;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        currentCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        currentCol = 0;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (matrix[currentRow][currentCol].equals("f")) {
                matrix[currentRow][currentCol] = "*";
                pythonLength++;
                foodCount--;
                if (foodCount == 0) {
                    System.out.printf("You win! Final python length is %d\n", pythonLength);
                    return;
                }
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
    }

    private static int findFoodCount(String[][] matrix) {
        int foodCount = 0;
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (string.equals("f")) {
                    foodCount++;
                }
            }
        }
        return foodCount;
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
/*The game starts with a python length of 1.
We get as input the size of the screen in which our python moves. The screen is always square.
After that, we receive the commands which represent the directions in which the python should move.
The python starts from s-position The commands will be: "left", "right", "up", "down".
If the python reaches the side edge of the screen (left or right), it goes to the opposite side of the same row.
If the python reaches the top/bottom edge of the screen it goes on the opposite side of the same column.
The possible characters that may appear on the screen are:
•	* – that is a regular asterisk; it does nothing
•	e – represents an enemy.
•	f – this is the food
•	s – the place where the game starts
Each time you eat a piece of food your length increases by one. Keep track of the length,
because in case you win you have to print it. If you step on an enemy the game is over (the python stops moving)
and you have to print the output as shown in the output section.
After executing all of the commands there are 3 possible outcomes:
•	you have eaten all the food and you win
•	you get killed by an enemy
•	there is still some food to be eaten
Print the corresponding output depending on the case.
Input
•	Length of the screen side – an integer number.
•	Commands to move the python – an array of strings separated by ",".
Output
•	There are three types of output:
o	If all of the food is eaten print the following output: "You win! Final python length is {length}"
o	If there are no left commands and there is still some food to be eaten: "You lose!
There is still {left food} food to be eaten."
o	If you step on the enemy the game is over and you print "You lose! Killed by an enemy!"
Constraints
•	The input numbers will be a 32-bit integer in the range [0 … 2 147 483 647].
•	Allowed working time for your program: 0.1 seconds.
•	Allowed memory: 16 MB.
*/
