package EP3_JavaAdvancedExam28June2020;

import java.util.Scanner;

public class A2_Snake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        matrix[currentRow][currentCol] = ".";
        int foodCount = 0;
        boolean isGameOver = false;

        while (true) {

            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        printGameOver();
                        isGameOver = true;
                        break;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        printGameOver();
                        isGameOver = true;
                        break;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        printGameOver();
                        isGameOver = true;
                        break;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        printGameOver();
                        isGameOver = true;
                        break;
                    }
                    break;
            }

            if (isGameOver) {
                System.out.println("Food eaten: " + foodCount);
                printMatrix(matrix);
                break;
            }
            if (matrix[currentRow][currentCol].equals("*")) {
                foodCount++;
            } else if (matrix[currentRow][currentCol].equals("B")) {
                matrix[currentRow][currentCol] = ".";
                int tempRow = currentRow;
                currentRow = findRowExitOfLair(matrix, currentRow, currentCol);
                currentCol = findColExitOfLair(matrix, tempRow, currentCol);
            }
            matrix[currentRow][currentCol] = ".";
            if (foodCount == 10) {
                System.out.println("You won! You fed the snake.");
                System.out.println("Food eaten: " + foodCount);
                matrix[currentRow][currentCol] = "S";
                printMatrix(matrix);
                break;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join("", current));
        }
    }
    private static int findColExitOfLair(String[][] matrix, int currentRow, int currentCol) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B") && row != currentRow && col != currentCol) {
                    return col;
                }
            }
        };
        return -1;
    }

    private static int findRowExitOfLair(String[][] matrix, int currentRow, int currentCol) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B") && row != currentRow && col != currentCol) {
                    return row;
                }
            }
        };
        return -1;
    }

    private static void printGameOver() {
        System.out.println("Game over!");
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals("S")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("S")) {
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
/*You will be given an integer n for the size of the territory with a square shape.
On the next n lines, you will receive the rows of the territory. The snake will be placed in a random position,
marked with the letter 'S'. There will also be food on random positions, marked with '*'.
The territory may have a lair. The lair will have two burrows marked with the letter - 'B'.
All of the empty positions will be marked with '-'.
Each turn, you will be given a command for the snake’s movement. When the snake moves it leaves a trail marked with '.'
Move commands will be: "up", "down", "left", "right".
If the snake moves to food, it will eat the food, which will increase food quantity with one.
If it goes inside a burrow, it goes out on the position of the other burrow and then both burrows disappear.
If the snake goes out of its territory, the game is over. The snake needs at least 10 food quantities to be fed.
If the snake goes outside of its territory or has eaten enough food, the game should end.
Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a move command.
Output
•	On the first line:
o	If the snake goes out of its territory, print: "Game over!"
o	If the snake eats enough food, print: "You won! You fed the snake."
•	On the second line print, all food is eaten: "Food eaten: {food quantity}"
•	At the end print the matrix.
Constraints
•	The size of the square matrix will be between [2…10].
•	There will always be 0 or 2 burrows, marked with - 'B'.
•	The snake position will be marked with 'S'.
•	The snake will always either go out of its territory or eat enough food.
•	There will be no case in which the snake will go through itself.
*/
