package EP17_JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

public class A2_NavyBattle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix, "S");
        int currentCol = findCol(matrix, "S");
        matrix[currentRow][currentCol] = "-";
        int minesHit = 0;
        int cruisersDestroyed = 0;
        String command;
        while (minesHit < 3 || cruisersDestroyed < 3) {
            command = scanner.nextLine();
            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            if (matrix[currentRow][currentCol].equals("*")) {
                minesHit++;
                matrix[currentRow][currentCol] = "-";
                if (minesHit == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", currentRow, currentCol);
                    matrix[currentRow][currentCol] = "S";
                    printMatrix(matrix);
                    return;
                }
            } else if (matrix[currentRow][currentCol].equals("C")) {
                cruisersDestroyed++;
                matrix[currentRow][currentCol] = "-";
                if (cruisersDestroyed == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    matrix[currentRow][currentCol] = "S";
                    printMatrix(matrix);
                    return;
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join("", current));
        }
    }

    /*private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }*/

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

    private static String[][] fillMatrix(Scanner scanner, int dimension) {
        String[][] matrix = new String[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("");
            matrix[row] = current;
        }
        return matrix;
    }
}
/*You will be given an integer n for the size of the battlefield (square shape). On the next n lines,
you will receive the rows of the battlefield. The submarine will start at a random position, marked with the letter 'S'.
The submarine surveys the surrounding area through its periscope, so it has to climb up to periscope depth,
where it might run across naval mines.
When the submarine receives direction, it goes deep and moves one position towards the given direction.
On each turn, you will be guiding the submarine and giving it the direction, in which it should move.
The commands will be "up", "down", "left" and "right".
When a new position is reached,  the submarine clims up to periscope depth to search for a cruiser:
•	If a position with '-' (dash) is reached, it means that the field is empty and the submarine awaits its next direction.
•	If it runs across a naval mine ('*'), the submarine takes serious damage. When a mine is blown,
the position of the mine will be marked with '-' (dash). U-9 can withstand two hits from naval mines.
The third time the submarine is hit by a mine, it disappears and the mission is failed.
The battle is over and the following message should be printed on the Console:
"Mission failed, U-9 disappeared! Last known coordinates [{row}, {col}]!"
•	If a battle cruiser is reached ('C'), the submarine destroys it and the position of the destroyed cruiser will be marked with '-' (dash).
•	If this is the last (third) battle cruiser on the battlefield, the battle is over and the following message
should be printed on the Console: "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!"
 The program will end when the battle is over (All battle cruisers are destroyed or the submarine hits mines three times).
Input
•	On the first line, you are given the integer n – the size of the matrix (wall).
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a direction command.
Output
•	If all battle cruisers are destroyed, print: "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!"
•	If U-9 is hit by a mine three times, print: "Mission failed, U-9 disappeared! Last known coordinates [{row}, {col}]!".
•	At the end, print the final state of the matrix (battlefield) with the last known U-9’s position on it.
Constraints
•	The size of the square matrix (battlefield) will be between [4…10].
•	U-9’s starting position will always be marked with 'S'.
•	There will be always three battle cruisers - fields marked with 'C'.
•	There will be always enough mines on the battlefield to destroy the submarine.
•	The commands given will direct the submarine only within the limits of the battlefield.
•	You will always receive enough commands to end the battle.
*/