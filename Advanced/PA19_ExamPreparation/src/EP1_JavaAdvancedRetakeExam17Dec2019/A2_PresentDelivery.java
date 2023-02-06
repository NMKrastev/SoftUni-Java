package EP1_JavaAdvancedRetakeExam17Dec2019;

import java.util.Arrays;
import java.util.Scanner;

public class A2_PresentDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presents = Integer.parseInt(scanner.nextLine());
        int dimension = Integer.parseInt(scanner.nextLine());

        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        matrix[currentRow][currentCol] = "-";
        int kidsCounter = 0;
        String command;
        while (!(command = scanner.nextLine()).equals("Christmas morning")) {

            switch (command) {
                case "up":
                    if (isInBounds(matrix, currentRow - 1, currentCol)) {
                        currentRow--;
                    }
                    break;
                case "down":
                    if (isInBounds(matrix, currentRow + 1, currentCol)) {
                        currentRow++;
                    }
                    break;
                case "left":
                    if (isInBounds(matrix, currentRow, currentCol - 1)) {
                        currentCol--;
                    }
                    break;
                case "right":
                    if (isInBounds(matrix, currentRow, currentCol + 1)) {
                        currentCol++;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("V")) {
                presents--;
                kidsCounter++;
                matrix[currentRow][currentCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("X")) {
                matrix[currentRow][currentCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("C")) {
                if (matrix[currentRow + 1][currentCol].equals("V") || matrix[currentRow + 1][currentCol].equals("X")) {
                    presents--;
                    kidsCounter++;
                    matrix[currentRow + 1][currentCol] = "-";
                    if (isRunOutOfPresents(presents)) {
                        break;
                    }
                }
                if (matrix[currentRow - 1][currentCol].equals("V") || matrix[currentRow - 1][currentCol].equals("X")) {
                    presents--;
                    kidsCounter++;
                    matrix[currentRow - 1][currentCol] = "-";
                    if (isRunOutOfPresents(presents)) {
                        break;
                    }
                }
                if (matrix[currentRow][currentCol + 1].equals("V") || matrix[currentRow][currentCol + 1].equals("X")) {
                    presents--;
                    kidsCounter++;
                    matrix[currentRow][currentCol + 1] = "-";
                    if (isRunOutOfPresents(presents)) {
                        break;
                    }
                }
                if (matrix[currentRow][currentCol - 1].equals("V") || matrix[currentRow][currentCol - 1].equals("X")) {
                    presents--;
                    kidsCounter++;
                    matrix[currentRow][currentCol - 1] = "-";
                    if (isRunOutOfPresents(presents)) {
                        break;
                    }
                }
                matrix[currentRow][currentCol] = "-";
            }

            if (isRunOutOfPresents(presents)) {
                break;

            }
        }

        matrix[currentRow][currentCol] = "S";

        printResult(matrix);

        int noPresentForNiceKidCount = findNiceKidWithNoPresent(matrix);
        System.out.println(noPresentForNiceKidCount != 0
                ? String.format("No presents for %d nice kid/s.\n", noPresentForNiceKidCount)
                : String.format("Good job, Santa! %d happy nice kid/s.", kidsCounter));
    }

    private static boolean isRunOutOfPresents(int presents) {
        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
            return true;
        }
        return false;
    }

    private static int findNiceKidWithNoPresent(String[][] matrix) {
        int count = 0;
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (string.equals("V")) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
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
            String[] current = scanner.nextLine().split("\\s+");
            matrix[row] = current;
        }
        return matrix;
    }

    private static void printResult(String[][] matrix) {
        Arrays.stream(matrix).forEach(e -> System.out.printf("%s \n", String.join(" ", e)));
    }
}
/*You will receive an integer m for the count of presents Santa has and an integer n for the size of the neighborhood
with a square shape. On the next lines, you will receive the matrix, which represents the neighborhood.
Santa will be in a random cell, marked with the letter 'S'. Each cell stands for a house where children may live.
If the cell has 'X' on it, that means there lives a naughty kid. Otherwise, if a nice kid lives there, the cell is
marked by 'V'. There can also be cells marked with 'C' for cookies. All of the empty positions will be marked with '-'.
Santa can move "up", "down", "left", "right". These will be the commands that you receive. If he moves to a house
with a nice kid, the kid receives a present, but if Santa reaches a house with a naughty kid, he doesn’t drop a present.
If the command sends Santa to a cell marked with 'C', Santa eats cookies and becomes happy and extra generous
so all the kids around him* receive presents (doesn’t matter if naughty or nice). If Santa has been to a house
and the kid there has received a present, the cell becomes '-'.
Note: *around him means on his left, right, upwards, and downwards by one cell. In this case, Santa doesn't move
to these cells or if he does, he returns to the cell where the cookie was.
If Santa runs out of presents or you receive the command "Christmas morning", then you have to end the program.
Keep in mind that you have to check whether all of the nice kids received presents.
Input
•	On the first line, you are given the integer m – the count of presents.
•	On the second – integer n – the size of the neighborhood.
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a command.
Output
•	On the first line:
o	If Santa runs out of presents, print: "Santa ran out of presents."
•	Next print the matrix.
•	In the end print one of these messages:
o	If he manages to give all the nice kids presents, print:
"Good job, Santa! {count total given presents} happy nice kid/s."
o	Otherwise print:
"No presents for {count nice kids} nice kid/s."
Constraints
•	The size of the square matrix will be between [2…10].
•	Santa’s position will be marked with 'S'.
•	There will always be at least 1 nice kid.
•	There won't be a case where the cookie is on the border of the matrix.
*/
