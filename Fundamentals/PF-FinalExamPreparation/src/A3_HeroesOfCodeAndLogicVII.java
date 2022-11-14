import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A3_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, Integer>> heroesStatsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        addHeroesStats(scanner, heroesStatsMap, n);

        String command;

        while (!(command = scanner.nextLine()).equals("End")) {

            if (command.contains("CastSpell")) {
                castSpell(heroesStatsMap, command);
            } else if (command.contains("TakeDamage")) {
                takeDamage(heroesStatsMap, command);
            } else if (command.contains("Recharge")) {
                rechargeMana(heroesStatsMap, command);
            } else if (command.contains("Heal")) {
                healHero(heroesStatsMap, command);
            }
        }

        printResult(heroesStatsMap);
    }

    private static void printResult(Map<String, Map<Integer, Integer>> heroesStatsMap) {

        heroesStatsMap.forEach((hero, stats) ->
                stats.forEach((hp, mana) ->
                        System.out.printf("%s\n  HP: %d\n  MP: %d\n", hero, hp, mana)));
    }

    private static void healHero(Map<String, Map<Integer, Integer>> heroesStatsMap, String command) {
        String heroName = command.split("\\s+-\\s+")[1];
        int HPAmount = Integer.parseInt(command.split("\\s+-\\s+")[2]);

        for (Map.Entry<Integer, Integer> entry : heroesStatsMap.get(heroName).entrySet()) {
            int currentHP = entry.getKey();
            int currentMana = entry.getValue();
            if (currentHP + HPAmount > 100) {
                heroesStatsMap.get(heroName).clear();
                heroesStatsMap.get(heroName).put(100, currentMana);
                System.out.printf("%s healed for %d HP!\n", heroName, 100 - currentHP);
                break;
            } else {
                heroesStatsMap.get(heroName).clear();
                heroesStatsMap.get(heroName).put(currentHP + HPAmount, currentMana);
                System.out.printf("%s healed for %d HP!\n", heroName, HPAmount);
                break;
            }
        }
    }

    private static void rechargeMana(Map<String, Map<Integer, Integer>> heroesStatsMap, String command) {

        String heroName = command.split("\\s+-\\s+")[1];
        int manaAmount = Integer.parseInt(command.split("\\s+-\\s+")[2]);

        for (Map.Entry<Integer, Integer> entry : heroesStatsMap.get(heroName).entrySet()) {
            int currentMana = entry.getValue();
            if (currentMana + manaAmount > 200) {
                entry.setValue(200);
                System.out.printf("%s recharged for %d MP!\n", heroName, 200 - currentMana);
                break;
            } else {
                entry.setValue(currentMana + manaAmount);
                System.out.printf("%s recharged for %d MP!\n", heroName, manaAmount);
                break;
            }
        }
    }

    private static void takeDamage(Map<String, Map<Integer, Integer>> heroesStatsMap, String command) {

        String heroName = command.split("\\s+-\\s+")[1];
        int damageTaken = Integer.parseInt(command.split("\\s+-\\s+")[2]);
        String attacker = command.split("\\s+-\\s+")[3];

        for (Map.Entry<Integer, Integer> entry : heroesStatsMap.get(heroName).entrySet()) {
            int currentHP = entry.getKey();
            int currentMana = entry.getValue();
            if (currentHP > damageTaken) {
                heroesStatsMap.get(heroName).clear();
                heroesStatsMap.get(heroName).put(currentHP - damageTaken, currentMana);
                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                        heroName, damageTaken, attacker, currentHP - damageTaken);
                break;
            } else {
                heroesStatsMap.remove(heroName);
                System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                break;
            }
        }
    }

    private static void castSpell(Map<String, Map<Integer, Integer>> heroesStatsMap, String command) {

        String heroName = command.split("\\s+-\\s+")[1];
        int manaNeeded = Integer.parseInt(command.split("\\s+-\\s+")[2]);
        String spellName = command.split("\\s+-\\s+")[3];

        for (Map.Entry<Integer, Integer> entry : heroesStatsMap.get(heroName).entrySet()) {
            int currentMana = entry.getValue();
            if (currentMana >= manaNeeded) {
                entry.setValue(currentMana - manaNeeded);
                System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                        heroName, spellName, currentMana - manaNeeded);
                break;
            } else {
                System.out.printf("%s does not have enough MP to cast %s!\n",
                        heroName, spellName);
                break;
            }
        }
    }

    private static void addHeroesStats(Scanner scanner, Map<String, Map<Integer, Integer>> heroesStatsMap, int n) {

        for (int i = 0; i < n; i++) {
            String heroStats = scanner.nextLine();
            String heroName = heroStats.split("\\s+")[0];
            int heroHitPoints = Integer.parseInt(heroStats.split("\\s+")[1]);
            int heroManaPoints = Integer.parseInt(heroStats.split("\\s+")[2]);

            heroesStatsMap.putIfAbsent(heroName, new LinkedHashMap<>());
            heroesStatsMap.get(heroName).put(heroHitPoints, heroManaPoints);
        }
    }
}
/*On the first line of the standard input, you will receive an integer n – the number of heroes that you can choose for
your party. On the next n lines, the heroes themselves will follow with their hit points and mana points separated by a
single space in the following format:
"{hero name} {HP} {MP}"
-	HP stands for hit points and MP for mana points
-	a hero can have a maximum of 100 HP and 200 MP
After you have successfully picked your heroes, you can start playing the game. You will be receiving different commands,
each on a new line, separated by " – ", until the "End" command is given.
There are several actions that the heroes can perform:
"CastSpell – {hero name} – {MP needed} – {spell name}"
•	If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
o	"{hero name} has successfully cast {spell name} and now has {mana points left} MP!"
•	If the hero is unable to cast the spell print:
o	"{hero name} does not have enough MP to cast {spell name}!"
"TakeDamage – {hero name} – {damage} – {attacker}"
•	Reduce the hero HP by the given damage amount. If the hero is still alive (his HP is greater than 0) print:
o	"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
•	If the hero has died, remove him from your party and print:
o	"{hero name} has been killed by {attacker}!"
"Recharge – {hero name} – {amount}"
•	The hero increases his MP. If it brings the MP of the hero above the maximum value (200), MP is increased to 200.
(the MP can't go over the maximum value).
•	 Print the following message:
o	"{hero name} recharged for {amount recovered} MP!"
"Heal – {hero name} – {amount}"
•	The hero increases his HP. If a command is given that would bring the HP of the hero above the maximum value (100),
HP is increased to 100 (the HP can't go over the maximum value).
•	 Print the following message:
o	"{hero name} healed for {amount recovered} HP!"
Input
•	On the first line of the standard input, you will receive an integer n
•	On the following n lines, the heroes themselves will follow with their hit points and mana points separated by a
space in the following format
•	You will be receiving different commands, each on a new line, separated by " – ", until the "End" command is given
Output
•	Print all members of your party who are still alive, in the following format (their HP/MP need to be indented 2 spaces):
"{hero name}
  HP: {current HP}
  MP: {current MP}"
Constraints
•	The starting HP/MP of the heroes will be valid, 32-bit integers will never be negative or exceed the respective limits.
•	The HP/MP amounts in the commands will never be negative.
•	The hero names in the commands will always be valid members of your party. No need to check that explicitly.*/