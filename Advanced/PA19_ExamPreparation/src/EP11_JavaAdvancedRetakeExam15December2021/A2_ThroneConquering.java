package EP11_JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class A2_ThroneConquering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int dimensions = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimensions);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        matrix[currentRow][currentCol] = "-";

        while (true) {

            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            matrix[spartanRow][spartanCol] = "S";

            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("S")) {
                energy -= 2;
                if (energy <= 0) {
                    matrix[currentRow][currentCol] = "X";
                    System.out.printf("Paris died at %d;%d.\n", currentRow, currentCol);
                    printMatrix(matrix);
                    return;
                }
                matrix[currentRow][currentCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("H")) {
                matrix[currentRow][currentCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
                printMatrix(matrix);
                return;
            } else if (energy <= 0) {
                matrix[currentRow][currentCol] = "X";
                System.out.printf("Paris died at %d;%d.\n", currentRow, currentCol);
                printMatrix(matrix);
                return;
            }
        }
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
/*After Paris got into Sparta, he has to fight his way to Helen’s chamber. To do that, he has to walk through the city
where dangerous enemies are watching out for threats, but he also has to be careful not to get exhausted and not be able
to proceed with his mission. If Paris successfully reaches her chamber, they safely escape from the Spartans.
A standard field of Sparta looks like this:
Field of Sparta	Legend
------H---
-------S--
--S-------
----------
-----P----	P  Paris, the player character
S Spartan, enemy
H  Helen
-  Empty space
Each turn proceeds as follows:
•	First, Spartan spawns on the given indices.
•	Then, Paris moves in a direction, which decreases his energy by 1.
o	It can be "up", "down", "left", "right".
o	If Paris tries to move outside of the field, he doesn’t move but still has his energy decreased.
•	If an enemy is in the same cell where Paris moves, Paris fights him, which decreases his energy by 2. If Paris’
energy drops at 0 or below, he dies and you should mark his position with ‘X’.
•	If Paris kills the enemy successfully, the enemy disappears.
•	If Paris reaches the index where Helen is, they both run away (disappear from the field), even if his energy is 0 or below.
Input
•	On the first line of input, you will receive e – the energy Paris has.
•	On the second line of input, you will receive n – the number of rows the field of Sparta will consist of
range: [5-20].
•	On the next n lines, you will receive how each row looks.
•	Then, until Paris dies, or reaches Helen, you will receive a move command and spawn row and column.
Output
•	If Paris is running out of energy, print "Paris died at {row};{col}."
•	If Helen is abducted, print "Paris has successfully abducted Helen! Energy left: {energy}"
•	Then, in all cases, print the final state of the field on the console.
Constraints
•	The field will always be rectangular.
•	Paris will always run out of energy or reach Helen.
•	There will be no case with spawn on invalid indices.
•	There will be no case with two enemies on the same cell.
•	There will be no case with enemy spawning on the indices where Paris is.
•	There will be no case with enemy spawning on the indices where Helen is.
*/
