package EP12_JavaAdvancedExam19February2022;

import java.util.Scanner;

public class A2_PawnWars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = 8;
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[][] matrix = fillMatrix(scanner, dimension);

        int whiteRow = findRow(matrix, "w");
        int whiteCol = findCol(matrix, "w");
        int blackRow = findRow(matrix, "b");
        int blackCol = findCol(matrix, "b");
        while (true) {

            //White pawn turn
            if (isInBounds(whiteRow - 1, whiteCol, matrix)) {
                if (checkForBlack(letters, matrix, whiteRow, whiteCol, blackRow, blackCol)) {
                    return;
                }
                whiteRow--;
            } else {
                System.out.printf("Game over! White pawn is promoted to a queen at %s%d.\n", letters[whiteCol], 8);
                return;
            }

            //Black pawn turn
            if (isInBounds(blackRow + 1, blackCol, matrix)) {
                if (checkForWhite(letters, matrix, whiteRow, whiteCol, blackRow, blackCol)) {
                    return;
                }
                blackRow++;
            } else {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s%d.\n", letters[blackCol], 1);
                return;
            }
        }
    }

    private static boolean checkForWhite(String[] letters, String[][] matrix, int whiteRow, int whiteCol, int blackRow, int blackCol) {
        if (isInBounds(blackRow + 1, blackCol - 1, matrix) && blackRow + 1 == whiteRow && blackCol - 1 == whiteCol) {
            System.out.printf("Game over! Black capture on %s%d.\n", letters[whiteCol], 8 - whiteRow);
            return true;
        }
        if (isInBounds(blackRow + 1, blackCol + 1, matrix) && blackRow + 1 == whiteRow && blackCol + 1 == whiteCol) {
            System.out.printf("Game over! Black capture on %s%d.\n", letters[whiteCol], 8 - whiteRow);
            return true;
        }
        return false;
    }

    private static boolean checkForBlack(String[] letters, String[][] matrix, int whiteRow, int whiteCol, int blackRow, int blackCol) {
        if (isInBounds(whiteRow - 1, whiteCol - 1, matrix) && whiteRow - 1 == blackRow && whiteCol - 1 == blackCol) {
            System.out.printf("Game over! White capture on %s%d.\n", letters[blackCol], 8 - blackRow);
            return true;
        }
        if (isInBounds(whiteRow - 1, whiteCol + 1, matrix) && whiteRow - 1 == blackRow && whiteCol + 1 == blackCol) {
            System.out.printf("Game over! White capture on %s%d.\n", letters[blackCol], 8 - blackRow);
            return true;
        }
        return false;
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix, String pawn) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals(pawn)) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix, String pawn) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals(pawn)) {
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
/*A chessboard has 8 rows and 8 columns. Rows also called ranks, are marked from number 1 to 8,
and columns are marked from a to h. We have a total of 64 squares, each square is represented by a combination
of letters and a number (a1, b1, c1, etc.). In this problem colors of the board will be ignored.
We will play the game with two pawns white (w) and black (b), where they can:
•	Only move forward:
	White (w) moves from the 1st rank to the 8th rank direction.
	Black (b) moves from 8th rank to the 1st rank direction.
•	Can move only 1 square at a time.
•	Can capture another pawn only diagonally:

When a pawn reaches the last rank, for white this is the 8th rank, and for black, this is the 1st rank, can be promoted to a queen.
Two pawns (w and b) will be placed on two random squares of the bord. The first move is always made by the
white pawn (w), then black moves (b), then white (w) again, and so on. When a pawn marches forward, the previous position is marked by "-" (dash).
Some rules will be applied when moving paws:
•	If the two pawns interact diagonally, the player, in turn, must capture the opponent’s pawn.
When a pawn capture another pawn the game is over and "Game over! {White/Black} capture on {coordinates}." is printed to the console.
Example:
White pawn is on the move and captures black in "e5". We print "Game over! White capture on e5."

•	If no capture is possible, the pawns keep on moving until one of them reaches the last rank.
When one of the pawns reaches the last rank we print: "Game over! {White/Black} pawn is promoted to a queen at {coordinates}."
Example:
It is black's turn and the pawn reaches the d1 square, we print "Game over! Black pawn is promoted to a queen at d1."

Constraints
•	The input will be always valid.
•	The matrix will always be 8x8.
•	There will be no case where two pawns are placed on the same square.
•	There will be no case where two pawns are placed on the same column.
•	There will be no case where black/white will be placed on the last rank.
*/