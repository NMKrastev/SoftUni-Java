package EP5_JavaAdvancedRetakeExam16December2020;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_Selling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher;
        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        int moneyCount = 0;
        boolean isOutOfBakery = false;
        matrix[currentRow][currentCol] = "-";

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        matrix[currentRow][currentCol] = "-";
                        isOutOfBakery = true;
                        break;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        matrix[currentRow][currentCol] = "-";
                        isOutOfBakery = true;
                        break;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        matrix[currentRow][currentCol] = "-";
                        isOutOfBakery = true;
                        break;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        matrix[currentRow][currentCol] = "-";
                        isOutOfBakery = true;
                        break;
                    }
                    break;
            }

            if (isOutOfBakery) {
                System.out.println("Bad news, you are out of the bakery.");
                System.out.println("Money: " + moneyCount);
                printMatrix(matrix);
                return;
            }

            matcher = pattern.matcher(matrix[currentRow][currentCol]);

            if (matrix[currentRow][currentCol].equals("O")) {
                matrix[currentRow][currentCol] = "-";
                currentRow = findPillarRow(matrix);
                currentCol = findPillarCol(matrix);
                matrix[currentRow][currentCol] = "-";
            } else if (matcher.find()) {
               moneyCount += Integer.parseInt(matcher.group(0));
                matrix[currentRow][currentCol] = "-";
                if (moneyCount >= 50) {
                    break;
                }
            }
        }
        System.out.println("Good news! You succeeded in collecting enough money!");
        System.out.println("Money: " + moneyCount);
        matrix[currentRow][currentCol] = "S";
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join("", current));
        }
    }

    private static int findPillarCol(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("O")) {
                    return col;
                }
            }
        };
        return -1;
    }

    private static int findPillarRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("O")) {
                    return row;
                }
            }
        };
        return -1;
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
/*You will be given an integer n for the size of the bakery with a square shape.
On the next n lines, you will receive the rows of the bakery. You will be placed in a random position,
marked with the letter 'S'. On random positions, there will be clients, marked with a single digit.
There may also be pillars. Their count will be either 0 or 2 and they are marked with the letter - 'O'.
All of the empty positions will be marked with '-'.
Each turn, you will be given commands for your movement. Move commands will be: "up", "down", "left", "right".
If you move to a client, you collect the price equal to the digit there and the client disappears.
If you move to a pillar, you move on to the position of the other pillar and then both pillars disappear.
If you go out of the bakery, you disappear from the bakery and you are out of there.
You need at least 50 dollars to rent your Bakery
When you are out of the bakery or you collect enough money, the program ends.
Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a move command.
Output
•	On the first line:
o	If the player goes to the void, print: "Bad news, you are out of the bakery."
o	If the player collects enough star power, print: "Good news! You succeeded in collecting enough money!"
•	On the second line print, all-star power collected: "Money: {money}"
•	At the end print the matrix.
Constraints
•	The size of the square matrix will be between [2…10].
•	There will always be 0 or 2 pillars, marked with the letter - 'O'.
•	Your position will be marked with 'S'.
•	You will always go out of the bakery or collect enough money.
*/
