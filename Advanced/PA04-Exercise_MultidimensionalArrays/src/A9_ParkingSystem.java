import java.util.Scanner;

public class A9_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[][] parkingLot = initializeParkingLot(scanner);

        String input;
        while (!(input = scanner.nextLine()).equals("stop")) {

            int entryRow = Integer.parseInt(input.split("\\s+")[0]);
            int positionRow = Integer.parseInt(input.split("\\s+")[1]);
            int positionCol = Integer.parseInt(input.split("\\s+")[2]);
            int distance = Math.abs(entryRow - positionRow) + 1;
            int tempColLeft = 0 >= positionCol - 1 ? 1 : positionCol - 1;
            int tempColRight = positionCol + 1 >= parkingLot[0].length - 1 ? positionCol : positionCol + 1;

            while (parkingLot[positionRow][tempColLeft]) {
                if (tempColLeft == 0) {
                    break;
                }
                tempColLeft--;
            }

            while (parkingLot[positionRow][tempColRight]) {
                if (tempColRight == parkingLot[0].length - 1) {
                    break;
                }
                tempColRight++;
            }

            if (isRowFull(positionRow, parkingLot)) {
                System.out.printf("Row %d full\n", positionRow);
                continue;
            }

            if (!parkingLot[positionRow][positionCol]) {
                parkingLot[positionRow][positionCol] = true;
                distance += positionCol;
                System.out.println(distance);
                continue;
            } else {
                if ((positionCol - tempColLeft) > (Math.abs(tempColRight - positionCol))) {
                    positionCol = tempColRight;
                } else {
                    positionCol = tempColLeft;
                }
            }

            if (positionCol <= 1 && parkingLot[positionRow][positionCol]) {
                positionCol = tempColRight;
            }

            if (parkingLot[positionRow][positionCol] && tempColRight == parkingLot[0].length - 1) {
                positionCol = tempColLeft;
            }

            parkingLot[positionRow][positionCol] = true;
            distance += positionCol;
            System.out.println(distance);
        }
    }

    public static boolean isRowFull(int row, boolean[][] parkingLot) {

        for (int col = 1; col < parkingLot[0].length; col++) {
            if (!parkingLot[row][col]) {
                return false;
            }
        }

        return true;
    }

    private static boolean[][] initializeParkingLot(Scanner scanner) {

        boolean[][] parkingLot = new boolean[scanner.nextInt()][scanner.nextInt()];
        for (int row = 0; row < parkingLot.length; row++) {
            parkingLot[row][0] = true;
        }
        scanner.nextLine();

        return parkingLot;
    }
}
/*The parking lot in front of SoftUni is one of the busiest in the country, and it's a common cause of conflicts
between the doorkeeper Svetlin and the students. The SoftUni team wants to proactively resolve all conflicts,
so an automated parking system should be implemented. They are organizing a competition – Parkoniada –
and the author of the best parking system will win a romantic dinner with RoYaL. That's exactly what you've been
dreaming of, so you decide to join in.
The parking lot is a rectangular matrix; the first column is always free, and all other cells are parking spots.
A car can enter from any cell of the first column and then decides to go to a specific spot. If that spot is not free,
the car searches for the closest free spot on the same row. If all the cells on that specific row are used, the car
cannot park and leaves. If two free cells are located at the same distance from the initial parking spot, the cell
which is closer to the entrance is preferred. A car can pass through a used parking spot.
Your task is to calculate the distance traveled by each car to its parking spot.
Example: A car enters the parking in row 1. It wants to go to cell 2, 2 so it moves through exactly four cells to reach
its parking spot.
Input
•	On the first line of input, you are given the integers R and C, defining the dimensions of the parking lot.
•	On the next several lines, you are given the integers Z, X, Y, where Z is the entry row and X, Y are the coordinates
of the desired parking spot.
•	The input stops with the command "stop". A single space separates all integers.
Output
•	Print the distance traveled to the desired spot or the first free spot for each car.
•	If a car cannot park on its desired row, print the message "Row {row number} full".
Constraints
•	2 ≤ R, C ≤ 10000.
•	Z, X, and Y are inside the dimensions of the matrix. Y is never on the first column.
•	There are no more than 1000 input lines.
•	Allowed time/space: 100ms/16MB.
*/
