import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A10_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] lairMatrix = new char[scanner.nextInt()][scanner.nextInt()];
        scanner.nextLine();
        int playerStartRow = 0;
        int playerStartCol = 0;
        String input;
        ArrayDeque<Integer> bunniesPositionsQueue = new ArrayDeque<>();

        for (int row = 0; row < lairMatrix.length; row++) {
            input = scanner.nextLine();
            for (int col = 0; col < lairMatrix[row].length; col++) {
                lairMatrix[row][col] = input.charAt(col);
                if (lairMatrix[row][col] == 'B') {
                    bunniesPositionsQueue.offer(row);
                    bunniesPositionsQueue.offer(col);
                }
                if (input.charAt(col) == 'P') {
                    playerStartRow = row;
                    playerStartCol = col;
                    lairMatrix[row][col] = '.';
                }
            }
        }

        input = scanner.nextLine();
        int counter = -1;
        boolean isPlayerDead = false;

        while (++counter < input.length()) {

            spreadBunnies(lairMatrix, bunniesPositionsQueue);

            String command = input.split("")[counter];
            int playerRow = playerStartRow;
            int playerCol = playerStartCol;

            if (command.equals("U")) {
                playerRow -= 1;
            } else if (command.equals("D")) {
                playerRow += 1;
            } else if (command.equals("L")) {
                playerCol -= 1;
            } else if (command.equals("R")) {
                playerCol += 1;
            }

            if (!isIndexesInBounds(lairMatrix, playerRow, playerCol)) {
                break;
            }

            playerStartRow = playerRow;
            playerStartCol = playerCol;

            if (!isPositionFree(lairMatrix, playerRow, playerCol)) {
                isPlayerDead = true;
                break;
            }
        }

        printLairMatrix(lairMatrix, isPlayerDead, playerStartRow, playerStartCol);
    }

    private static void printLairMatrix(char[][] lairMatrix, boolean isPlayerDead, int playerStartRow, int playerStartCol) {

        Arrays.stream(lairMatrix)
                .map(String::new)
                .forEach(System.out::println);
        System.out.println(isPlayerDead
                ? String.format("dead: %d %d", playerStartRow, playerStartCol)
                : String.format("won: %d %d", playerStartRow, playerStartCol));
    }

    private static char[][] spreadBunnies(char[][] lairMatrix, ArrayDeque<Integer> bunniesPositionsQueue) {

        int[] rowMovement = {1, -1, 0, 0};
        int[] colMovement = {0, 0, 1, -1};
        int operations = bunniesPositionsQueue.size() / 2;
        for (int i = 0; i < operations; i++) {
            int row = bunniesPositionsQueue.poll();
            int col = bunniesPositionsQueue.poll();
            for (int j = 0; j < rowMovement.length; j++) {
                int currentRow = row + rowMovement[j];
                int currentCol = col + colMovement[j];

                if (!isIndexesInBounds(lairMatrix, currentRow, currentCol)) {
                    continue;
                }
                if (lairMatrix[currentRow][currentCol] == 'B') {
                    continue;
                }

                lairMatrix[currentRow][currentCol] = 'B';
                bunniesPositionsQueue.offer(currentRow);
                bunniesPositionsQueue.offer(currentCol);
            }
        }

        return lairMatrix;
    }

    private static boolean isPositionFree(char[][] lairMatrix, int row, int col) {

        return lairMatrix[row][col] == '.';
    }

    private static boolean isIndexesInBounds(char[][] lairMatrix, int row, int col) {

        return row >= 0 && row < lairMatrix.length && col >= 0 && col < lairMatrix[row].length;
    }
}
/*Browsing through GitHub, you come across an old JS Basics teamwork game. It is about very nasty bunnies that multiply
extremely fast. There's also a player that has to escape from their lair.
The last thing that is left is the algorithm that decides if the player will escape the lair or not. You like the game,
so you decide to port it to Java because that's your language of choice.
First, you will receive a line holding integers N and M, representing the rows and columns in the lair.
Then you receive N strings that can only consist of ".", "B", "P". The bunnies are marked with "B", the player is
marked with "P", and everything else is free space, marked with a dot ".". They represent the initial state of the lair.
There will be only one player. Then you will receive a string with commands such as LLRRUUDD –
where each letter represents the player's next move (Left, Right, Up, Down).
After each step of the player, each of the bunnies spread to the up, down, left, and right
(neighboring cells marked as "." changes their value to B). If the player moves to a bunny cell or a bunny reaches
the player, the player has died. If the player goes out of the lair without encountering a bunny, the player has won.
When the player dies or wins, the game ends. All the activities for this turn continue
(e.g., all the bunnies spread normally), but there are no more turns.
There will be no stalemates where the moves of the player end before he dies or escapes.
Finally, print the final state of the lair with every row on a separate line.
On the last line, print either "dead: {row} {col}" or "won: {row} {col}".
Row and col are the coordinates of the cell where the player has died or the last cell he has been in before escaping the lair.
Input
•	On the first line of input, the numbers N and M are received – the number of rows and columns in the lair.
•	On the next N lines, each row is received as a string. The string will contain only ".", "B", "P".
All strings will be the same length. There will be only one "P" for all the input.
•	On the last line, the directions are received in the form of a string containing "R", "L", "U", "D".
Output
•	On the first N lines, print the final state of the bunny lair.
•	On the last line, print the outcome – "won: {row} {col}"  or "dead: {row} {col}".
Constraints
•	The dimensions of the lair are in the range [3…20].
•	The directions string length is in the range [1…20].
*/
