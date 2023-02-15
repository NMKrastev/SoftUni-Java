package EP16_JavaAdvancedExam22October2022;

import java.util.Scanner;

public class A2_RallyRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String racingNum = scanner.nextLine();
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = 0;
        int currentCol = 0;
        int kmPassed = 0;
        String input;

        while (!(input = scanner.nextLine()).equals("End")) {

            switch (input) {
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

            if (matrix[currentRow][currentCol].equals("T")) {
                matrix[currentRow][currentCol] = ".";
                currentRow = findRow(matrix, "T");
                currentCol = findCol(matrix, "T");
                matrix[currentRow][currentCol] = ".";
                kmPassed += 30;
            } else if (matrix[currentRow][currentCol].equals("F")) {
                matrix[currentRow][currentCol] = "C";
                kmPassed += 10;
                System.out.printf("Racing car %s finished the stage!\n", racingNum);
                System.out.printf("Distance covered %d km.\n", kmPassed);
                printMatrix(matrix);
                return;
            } else {
                kmPassed += 10;
            }
        }
        System.out.printf("Racing car %s DNF.\n", racingNum);
        System.out.printf("Distance covered %d km.\n", kmPassed);
        matrix[currentRow][currentCol] = "C";
        printMatrix(matrix);
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
            String[] current = scanner.nextLine().split("\\s+");
            matrix[row] = current;
        }
        return matrix;
    }
}
/*On the first line, you will be given an integer N, which represents the size of a square matrix.
On the second line you will receive the racing number of the tracked race car.
On the next N lines you will be given the rows of  the matrix (string sequences, separated by whitespace),
which will be representing the race route. The tracked race car always starts with coordinates [0, 0].
Thеre will be a tunnel somewhere across the race route. If the race car runs into the tunnel ,
the car goes through it and exits at the other end. There will be always two positions marked with "T"(tunnel).
The finish line will be marked with "F". All other positions will be marked with ".".
Keep track of the kilometers passed. Every time the race car receives a direction and moves to the next position
of the race route, it covers 10 kilometers. If the car goes through the tunnel, it covers NOT 10, but 30 kilometers.
On each line, after the matrix is given, you will be receiving the directions for the race car.
•	left
•	right
•	up
•	down
The race car starts moving across the race route:
•	If you receive "End" command, before the race car manages to reach the finish line,
the car is disqualified and the following output should be printed on the Console: "Racing car {racing number} DNF."
•	If the race car comes across a position marked with ".".
The car passes 10 kilometers for the current move and waits for the next direction.
•	If the race car comes across a position marked with "T" this is the tunnel.
The race car goes through it and moves to the other position marked with  "T" (the other end of the tunnel).
The car passes 30 kilometers for the current move. The tunnel stays behind the car, so the race route is clear,
and both the positions marked with "T", should be marked with ".".
•	If the car reaches the finish line - "F" position, the race is over.
The tracked race car manages to finish the stage and the following output should be printed on the Console:
"Racing car {racing number} finished the stage!". Don’t forget that the car has covered another 10 km with the last move.
Input
•	On the first line you will receive N - the size of the square matrix (race route).
•	On the second line you will receive the racing number of the tracked car.
•	On the next N lines, you will receive the race route (elements will be separated by a space).
•	On the following lines, you will receive directions (left, right, up, down).
•	On the last line, you will receive the command "End".
Output
•	If the racing car has reached the finish line before the "End" command is given, print on the Console: "Racing car {racing number} finished the stage!"
•	If the "End" command is given and the racing car has not reached the finish line yet, the race ends and the following message is printed on the Console: "Racing car {racing number} DNF."
•	On the second line, print the distance that the tracked race car has covered: "Distance covered {kilometers passed} km."
•	At the end, mark the last known position of the race car with "C" and print the final state of the matrix (race route). If the race car hasn't gone through the tunnel, the tunnel exits should be visualized in the final state of the matrix. The row elements in the output matrix should NOT be separated by whitespace.
Constraints
•	The directions will always lead to coordinates in the matrix.
•	There will always be two positions marked with "T", representing the tunnel in the race route.
•	The size of the square matrix (race route) will be between [4…10].
*/