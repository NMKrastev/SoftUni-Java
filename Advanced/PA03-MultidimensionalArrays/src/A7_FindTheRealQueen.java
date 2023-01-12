import java.util.Scanner;

public class A7_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readMatrix(scanner);

        String output = checkForAnotherQueen(matrix);

        System.out.println(output);
    }

    private static String checkForAnotherQueen(char[][] matrix) {

        String output = null;
        //Checks for queen in the current row
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    //Checks Up/Down for another queen
                    //Checks Diagonals for another queen
                    if (checksUpDown(row, col, matrix) && checkDiagonals(row, col, matrix)) {
                        return row + " " + col;
                    }
                }
            }
        }

        return null;
    }

    private static boolean checkDiagonals(int queenRowPosition, int queenColPosition, char[][] matrix) {

        //Checks for another queen on the first diagonal
        int row = queenRowPosition - 1;
        int col = queenColPosition - 1;
        while (col >= 0 && row >= 0) {
            if (matrix[row--][col--] == 'q') {
                return false;
            }
        }
        row = queenRowPosition + 1;
        col = queenColPosition + 1;
        while (col <= matrix.length - 1 && row <= matrix.length - 1) {
            if (matrix[row++][col++] == 'q') {
                return false;
            }
        }

        //Checks for another queen on the second diagonal
        row = queenRowPosition - 1;
        col = queenColPosition + 1;
        while (col <= matrix.length - 1 && row >= 0) {
            if (matrix[row--][col++] == 'q') {
                return false;
            }
        }
        row = queenRowPosition + 1;
        col = queenColPosition - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row++][col--] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static boolean checksUpDown(int queenRowPosition, int queenColPosition, char[][] matrix) {

        //Checks for another queen on the Up/Down path by rows, using same column
        for (int row = 0; row < matrix.length; row++) {
            if (row == queenRowPosition) {
                continue;
            }
            if (matrix[row][queenColPosition] == 'q') {
                return false;
            }
        }
        //Checks for another queen on the Left/Right path by columns, using same row
        for (int col = 0; col < matrix.length; col++) {
            if (col == queenColPosition) {
                continue;
            }
            if (matrix[queenRowPosition][col] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static char[][] readMatrix(Scanner scanner) {

        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            char[] current = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[row] = current;
        }

        return matrix;
    }
}
/*Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chessboard with
figures on it. The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen,
but only one queen will have a valid position, which is not attacked by any other queen and does not attack any other queen.
In another word, in the way of the valid queen, there are no other queens, but there may be any other ASCII symbol.
Your task is to read the chessboard and find the position of the valid queen. According to chess rules,
the queen can attack all the cells in horizontal verticals and both diagonals, which cross the queen position.*/