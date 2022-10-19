import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        //int count = 1;
        boolean isDead = false;
        List<String> roomsList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        for (int i = 0; i < roomsList.size(); i++) {

            if (roomsList.get(i).contains("potion")) {
                int healHealth = Integer.parseInt(roomsList.get(i).split(" ")[1]);
                if (health + healHealth > 100) {
                    healHealth = 100 - health;
                    health = 100;
                } else {
                    health += healHealth;
                }
                System.out.printf("You healed for %d hp.\n", healHealth);
                System.out.printf("Current health: %d hp.\n", health);
            } else if (roomsList.get(i).contains("chest")) {
                int foundBitcoins = Integer.parseInt(roomsList.get(i).split(" ")[1]);
                System.out.printf("You found %d bitcoins.\n", foundBitcoins);
                bitcoins += foundBitcoins;
            } else {
                String monsterName = roomsList.get(i).split(" ")[0];
                int monsterAttackDMG = Integer.parseInt(roomsList.get(i).split(" ")[1]);
                health -= monsterAttackDMG;

                if (health <= 0) {
                    System.out.printf("You died! Killed by %s.\n", monsterName);
                    System.out.printf("Best room: %d\n", i + 1);
                    isDead = true;
                    break;
                } else {
                    System.out.printf("You slayed %s.\n", monsterName);
                }
            }
        }

        if (!isDead) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + bitcoins);
            System.out.println("Health: " + health);
        }
    }
}

/*You have initial health 100 and initial bitcoins 0. You will be given a string representing the dungeon's rooms.
Each room is separated with '|' (vertical bar): "room1|room2|room3…"
Each room contains a command and a number, separated by space. The command can be:
•	"potion"
o	You are healed with the number in the second part. But your health cannot exceed your initial health (100).
o	First print: "You healed for {amount} hp."
o	After that, print your current health: "Current health: {health} hp."
•	"chest"
o	You've found some bitcoins, the number in the second part.
o	Print: "You found {amount} bitcoins."
•	In any other case, you are facing a monster, which you will fight. The second part of the room contains the attack
of the monster. You should remove the monster's attack from your health.
o	If you are not dead (health <= 0), you've slain the monster, and you should print: "You slayed {monster}."
o	If you've died, print "You died! Killed by {monster}." and your quest is over. Print the best room you've manage
to reach: "Best room: {room}"
If you managed to go through all the rooms in the dungeon, print on the following three lines:
"You've made it!"
"Bitcoins: {bitcoins}"
"Health: {health}"
Input / Constraints
You receive a string representing the dungeon's rooms, separated with '|' (vertical bar): "room1|room2|room3…".
Output
Print the corresponding messages described above.
*/