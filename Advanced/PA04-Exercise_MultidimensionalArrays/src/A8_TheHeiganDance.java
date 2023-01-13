import java.util.Scanner;

public class A8_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganHealth = 3000000;
        int playerHealth = 18500;
        int playerStartRow = 7;
        int playerStartCol = 7;
        String lastSpell = "";
        boolean isActiveCloud = false;
        double playerDamage = Double.parseDouble(scanner.nextLine());

        while (playerHealth > 0 && playerHealth > 0) {

            heiganHealth -= playerDamage;

            if (isActiveCloud) {
                playerHealth -= 3500;
                isActiveCloud = false;
                if (playerHealth <= 0) {
                    break;
                }
            }
            if (heiganHealth <= 0) {
                break;
            }

            String input = scanner.nextLine();
            String spell = input.split("\\s+")[0];
            int spellPositionRow = Integer.parseInt(input.split("\\s+")[1]);
            int spellPositionCol = Integer.parseInt(input.split("\\s+")[2]);

            boolean[][] spellInGameField = initializeSpellInGameField(spellPositionRow, spellPositionCol);

            if (spellInGameField[playerStartRow][playerStartCol]) {
                if (isAbleToMoveUpDown(spellInGameField, playerStartRow - 1) && !spellInGameField[playerStartRow - 1][playerStartCol]) {
                    playerStartRow--;
                } else if (isAbleToMoveRightLeft(spellInGameField, playerStartCol + 1) && !spellInGameField[playerStartRow][playerStartCol + 1]) {
                    playerStartCol++;
                } else if (isAbleToMoveUpDown(spellInGameField, playerStartRow + 1) && !spellInGameField[playerStartRow + 1][playerStartCol]) {
                    playerStartRow++;
                } else if (isAbleToMoveRightLeft(spellInGameField, playerStartCol - 1) && !spellInGameField[playerStartRow][playerStartCol - 1]) {
                    playerStartCol--;
                }


                if (spellInGameField[playerStartRow][playerStartCol]) {
                    if (spell.equals("Cloud")) {
                        playerHealth -= 3500;
                        isActiveCloud = true;
                        lastSpell = "Plague Cloud";

                    } else if (spell.equals("Eruption")) {
                        playerHealth -= 6000;
                        lastSpell = spell;
                    }
                }
            }
        }

        System.out.println(heiganHealth > 0 ? String.format("Heigan: %.2f", heiganHealth) : "Heigan: Defeated!");
        System.out.println(playerHealth > 0 ? "Player: " + playerHealth : "Player: Killed by " + lastSpell);
        System.out.printf("Final position: %d, %d", playerStartRow, playerStartCol);

    }

    private static boolean[][] initializeSpellInGameField(int spellPositionRow, int spellPositionCol) {

        boolean[][] spellInGameField = new boolean[15][15];
        for (int i = spellPositionRow - 1; i <= spellPositionRow + 1; i++) {
            if (isIndexesInBounds(i, spellInGameField)) {
                for (int j = spellPositionCol - 1; j <= spellPositionCol + 1; j++) {
                    if (isIndexesInBounds(i, j, spellInGameField)) {
                        spellInGameField[i][j] = true;
                    }
                }
            }
        }

        return spellInGameField;
    }

    private static boolean isAbleToMoveRightLeft(boolean[][] spellInGameField, int playerStartCol) {

        return playerStartCol >= 0 && playerStartCol < spellInGameField.length;
    }

    private static boolean isAbleToMoveUpDown(boolean[][] spellInGameField, int playerStartRow) {

        return playerStartRow >= 0 && playerStartRow < spellInGameField[playerStartRow].length;
    }

    private static boolean isIndexesInBounds(int row, int col, boolean[][] spellInGameField) {

        return col >= 0 && col < spellInGameField[row].length;
    }

    private static boolean isIndexesInBounds(int row, boolean[][] spellInGameField) {

        return row >= 0 && row < spellInGameField.length;

    }
}
/*At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by
the famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and
Eruptions, and you'll be just fine.
Heigan's chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn,
Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1),
he also hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player's current position is within the area of damage, the player
tries to move. First, he tries to move up. If there's damage/wall, he tries to move right, down, and left. If he
cannot move in any direction because the cell is damaged or there is a wall, the player stays in place and takes the damage.
Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage
when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud damage
is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have cast is ignored.
The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage
to Heigan. The fight is over either when the player is killed, or Heigan is defeated.
Input
•	On the first line, you receive a floating-point number D – the damage done to Heigan each turn.
•	On the next several lines – you receive input in format "{spell} {row} {col} – {spell}" is either Cloud or Eruption.
Output
•	    On the first line
o	If Heigan is defeated: "Heigan: Defeated!"
o	Else: "Heigan: {remaining}", where remaining is rounded to two digits after the decimal separator.
•	    On the second line:
o	If the player is killed: "Player: Killed by {spell}".
o	Else "Player: {remaining}".
•	    On the third line: "Final position: {row, col}" -> the last coordinates of the player.
Constraints
•	D is a floating-point number in the range [0 … 500000].
•	A damaging spell will always affect at least one cell.
•	Allowed memory: 250ms/16MB.
*/
