package EP10_JavaAdvancedExam23October2021;

import java.util.Scanner;

public class A2_MouseAndCheese {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        matrix[currentRow][currentCol] = "-";
        int eatenCheese = 0;
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {

            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    } else {
                        printOutOfField(eatenCheese);
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        matrix[currentRow][currentCol] = "-";
                        currentRow--;
                        if (matrix[currentRow][currentCol].equals("c")) {
                            eatenCheese++;
                            matrix[currentRow][currentCol] = "-";
                        }
                    } else if (matrix[currentRow][currentCol].equals("c")) {
                        eatenCheese++;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    } else {
                        printOutOfField(eatenCheese);
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        matrix[currentRow][currentCol] = "-";
                        currentRow++;
                        if (matrix[currentRow][currentCol].equals("c")) {
                            eatenCheese++;
                            matrix[currentRow][currentCol] = "-";
                        }
                    } else if (matrix[currentRow][currentCol].equals("c")) {
                        eatenCheese++;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    } else {
                        printOutOfField(eatenCheese);
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        matrix[currentRow][currentCol] = "-";
                        currentCol--;
                        if (matrix[currentRow][currentCol].equals("c")) {
                            eatenCheese++;
                            matrix[currentRow][currentCol] = "-";
                        }
                    } else if (matrix[currentRow][currentCol].equals("c")) {
                        eatenCheese++;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    } else {
                        printOutOfField(eatenCheese);
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[currentRow][currentCol].equals("B")) {
                        matrix[currentRow][currentCol] = "-";
                        currentCol++;
                        if (matrix[currentRow][currentCol].equals("c")) {
                            eatenCheese++;
                            matrix[currentRow][currentCol] = "-";
                        }
                    } else if (matrix[currentRow][currentCol].equals("c")) {
                        eatenCheese++;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
            }
        }

        printEatenCheese(eatenCheese);
        matrix[currentRow][currentCol] = "M";
        printMatrix(matrix);
    }

    private static void printOutOfField(int eatenCheese) {
        System.out.println("Where is the mouse?");
        printEatenCheese(eatenCheese);
    }

    private static void printEatenCheese(int eatenCheese) {
        System.out.println(eatenCheese < 5
                ? String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - eatenCheese)
                : String.format("Great job, the mouse is fed %d cheeses!", eatenCheese));
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
                if (strings[col].equals("M")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("M")) {
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
/*You will be given an integer n for the size of the mouse territory with a square shape. On the next n lines,
you will receive the rows of the territory. The mouse will be placed in a random position, marked with the letter 'M'.
On random positions, there will be cheese, marked with 'c'. There may also be a bonus on the territory.
There will always be only one bonus. It will be marked with the letter - 'B'.
All of the empty positions will be marked with '-'.
Each turn, you will be given a command for the mouse’s movement.
The commands will be: "up", "down", "left", "right", "end".
If the mouse moves to cheese, it eats the cheese and increases the cheese it has eaten by one.
If it goes to a bonus, the mouse gets a bonus one move forward and then the bonus disappears.
If the mouse goes out she can't return and the program ends. If the mouse receives the "end" command the program ends.
The mouse needs at least 5 eaten cheeses.
Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines hold the values for every row.
•	On each of the next lines, until you receive the "end" command,  you will receive a move command.
Output
•	On the first line:
o	If the mouse goes out of its territory print: "Where is the mouse?".
•	On the second line:
o	 If the mouse couldn’t eat enough cheeses print: "The mouse couldn't eat the cheeses, she needed {needed} cheeses more.".
o	If the mouse has successfully eaten enough cheeses print: "Great job, the mouse is fed {eaten cheeses} cheeses!".
•	At the end print the matrix.
Constraints
•	The size of the square matrix will be between [2…10].
•	There will always be only one bonus, marked with 'B.
•	The mouse position will be marked with 'M'.
•	There won't be a case where a bonus moves the mouse out of its territory.
*/