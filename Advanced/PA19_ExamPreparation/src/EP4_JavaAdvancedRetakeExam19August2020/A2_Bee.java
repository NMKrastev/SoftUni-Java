package EP4_JavaAdvancedRetakeExam19August2020;

import java.util.Scanner;

public class A2_Bee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimension);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);

        int pollinatedFlowers = 0;
        boolean isOutOfField = false;

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            matrix[currentRow][currentCol] = ".";
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                        if (matrix[currentRow][currentCol].equals("f")) {
                            pollinatedFlowers++;
                        } else if (matrix[currentRow][currentCol].equals("O")) {
                            matrix[currentRow][currentCol] = ".";
                            if (isInBounds(currentRow - 1, currentCol, matrix)) {
                                currentRow--;
                                if (matrix[currentRow][currentCol].equals("f")) {
                                    pollinatedFlowers++;
                                }
                            } else {
                                isOutOfField = true;
                                break;
                            }
                        }
                    } else {
                        isOutOfField = true;
                        break;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                        if (matrix[currentRow][currentCol].equals("f")) {
                            pollinatedFlowers++;
                        } else if (matrix[currentRow][currentCol].equals("O")) {
                            matrix[currentRow][currentCol] = ".";
                            if (isInBounds(currentRow + 1, currentCol, matrix)) {
                                currentRow++;
                                if (matrix[currentRow][currentCol].equals("f")) {
                                    pollinatedFlowers++;
                                }
                            } else {
                                isOutOfField = true;
                                break;
                            }
                        }
                    } else {
                        isOutOfField = true;
                        break;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                        if (matrix[currentRow][currentCol].equals("f")) {
                            pollinatedFlowers++;
                        } else if (matrix[currentRow][currentCol].equals("O")) {
                            matrix[currentRow][currentCol] = ".";
                            if (isInBounds(currentRow, currentCol - 1, matrix)) {
                                currentCol--;
                                if (matrix[currentRow][currentCol].equals("f")) {
                                    pollinatedFlowers++;
                                }
                            } else {
                                isOutOfField = true;
                                break;
                            }
                        }
                    } else {
                        isOutOfField = true;
                        break;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                        if (matrix[currentRow][currentCol].equals("f")) {
                            pollinatedFlowers++;
                        } else if (matrix[currentRow][currentCol].equals("O")) {
                            matrix[currentRow][currentCol] = ".";
                            if (isInBounds(currentRow, currentCol + 1, matrix)) {
                                currentCol++;
                                if (matrix[currentRow][currentCol].equals("f")) {
                                    pollinatedFlowers++;
                                }
                            } else {
                                isOutOfField = true;
                                break;
                            }
                        }
                    } else {
                        isOutOfField = true;
                        break;
                    }
                    break;
            }
            matrix[currentRow][currentCol] = "B";
            if (isOutOfField) {
                System.out.println("The bee got lost!");
                matrix[currentRow][currentCol] = ".";
                break;
            }
        }
        System.out.println(pollinatedFlowers >= 5
                ? String.format("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers)
                : String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers));
        printMatrix(matrix);
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
                if (strings[col].equals("B")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
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
/*You will be given an integer n for the size of the bee territory with a square shape.
On the next n lines, you will receive the rows of the territory. The bee will be placed in a random position,
marked with the letter 'B'. On random positions, there will be flowers, marked with 'f'.
There may also be a bonus on the territory. There will always be only one bonus. It will be marked with the letter - 'O'.
All of the empty positions will be marked with '.'.
Each turn, you will be given a command for the bee’s movement.
The commands will be: "up", "down", "left", "right", "End".
If the bee moves to a flower, it pollinates the flower and increases pollinated flowers with one.
If it goes to a bonus, the bee gets a bonus one moves forward and then the bonus disappears.
If the bee goes out she can't return back and the program ends. If the bee receives the "End" command the program ends.
The bee needs at least 5 pollinated flowers.
Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines hold the values for every row.
•	On each of the next lines, until you receive the "End" command,  you will receive a move command.
Output
•	On the first line:
o	If the bee goes out of its territory print: "The bee got lost!"
•	On the second line:
o	 If the bee couldn’t pollinate enough flowers print: "The bee couldn't pollinate the flowers, she needed {needed} flowers more"
o	If the bee successfully pollinated enough flowers print: "Great job, the bee manage to pollinate {polinationed flowers} flowers!"
•	At the end print the matrix.
Constraints
•	The size of the square matrix will be between [2…10].
•	There will always be 0 or 1 bonus, marked with - 'O'.
•	The bee position will be marked with 'B'.
•	There won't be a case where a bonus moves the bee out of its territory.
*/
