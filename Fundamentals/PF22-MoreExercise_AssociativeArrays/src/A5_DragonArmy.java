import java.util.*;

public class A5_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, List<Integer>>> dragonInfoMap = new LinkedHashMap<>();
        String input;

        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            input = scanner.nextLine();
            String type = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            int damage;
            int health;
            int armor;
            if (input.split("\\s+")[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input.split("\\s+")[2]);
            }
            if (input.split("\\s+")[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input.split("\\s+")[3]);
            }
            if (input.split("\\s+")[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input.split("\\s+")[4]);
            }

            dragonInfoMap.putIfAbsent(type, new TreeMap<>());
            dragonInfoMap.get(type).put(name, new ArrayList<>());
            dragonInfoMap.get(type).get(name).add(damage);
            dragonInfoMap.get(type).get(name).add(health);
            dragonInfoMap.get(type).get(name).add(armor);
        }

        List<Double> averageValues = new ArrayList<>();
        averageValues = getAverageValues(averageValues, dragonInfoMap);

        printResult(dragonInfoMap, averageValues);
    }

    private static void printResult(Map<String, TreeMap<String, List<Integer>>> dragonInfoMap, List<Double> averageValues) {

        int listIndex = 0;
        for (Map.Entry<String, TreeMap<String, List<Integer>>> typeEntry : dragonInfoMap.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", typeEntry.getKey(), averageValues.get(listIndex),
                    averageValues.get(listIndex + 1), averageValues.get(listIndex + 2));

            for (Map.Entry<String, List<Integer>> dragonsEntry : typeEntry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragonsEntry.getKey(),
                        dragonsEntry.getValue().get(0), dragonsEntry.getValue().get(1), dragonsEntry.getValue().get(2));
            }
            listIndex += 3;
        }
    }

    private static List<Double> getAverageValues(List<Double> averageValues, Map<String, TreeMap<String, List<Integer>>> dragonInfoMap) {
        double averageDamage = 0;
        double averageHealth = 0;
        double averageArmor = 0;
        int damageCount = 0;
        int healthCount = 0;
        int armorCount = 0;
        int currentSumDamage = 0;
        int currentSumHealth = 0;
        int currentSumArmor = 0;

        for (Map.Entry<String, TreeMap<String, List<Integer>>> treeMapEntry : dragonInfoMap.entrySet()) {
            for (Map.Entry<String, List<Integer>> valuesEntry : treeMapEntry.getValue().entrySet()) {
                int index = 0;
                currentSumDamage += valuesEntry.getValue().get(index);
                damageCount++;
                currentSumHealth += valuesEntry.getValue().get(index + 1);
                healthCount++;
                currentSumArmor += valuesEntry.getValue().get(index + 2);
                armorCount++;

            }
            averageDamage = 1.0 * currentSumDamage / damageCount;
            averageHealth = 1.0 * currentSumHealth / healthCount;
            averageArmor = 1.0 * currentSumArmor / armorCount;
            currentSumDamage = 0;
            currentSumHealth = 0;
            currentSumArmor = 0;
            damageCount = 0;
            healthCount = 0;
            armorCount = 0;
            averageValues.add(averageDamage);
            averageValues.add(averageHealth);
            averageValues.add(averageArmor);
        }
        return averageValues;
    }
}
/*Heroes III is the best game ever. Everyone loves it, and everyone plays it all the time. John is not an exclusion
from this rule. His favorite units in the game are all types of dragons - black, red, gold, azure, etc. He likes them
so much that he gives them names and keeps logs of their stats: damage, health, and armor. The process of aggregating
all the data is quite tedious, so he would like to have a program doing it. Since he is no programmer, it's your task to help him.
You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats.
Type is preserved as in the input order, but dragons are sorted alphabetically by name. For each type, you should
also print the average damage, health, and armor of the dragons. For each dragon, print his stats.
There may be missing stats in the input, though. If a stat is missing, you should assign its default values.
Default values are as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.
The input is in the following format "{type} {name} {damage} {health} {armor}". Any of the integers may be assigned
a null value. See the examples below for a better understanding of your task.
If the same dragon is added a second time, the new stats should overwrite the previous ones. Two dragons are
considered equal if they match by both name and type.
Input
•	On the first line, you are given the number N - the number of dragons to follow.
•	On the next N lines, you are given input in the format described above. There will be a single space separating each element.
Output
•	Print the aggregated data on the console.
•	For each type print average stats of its dragons in format "{Type}::({damage}/{health}/{armor})".
•	Damage, health, and armor should be rounded to two digits after the decimal separator.
•	For each dragon, print its stats in the format:
"-{Name} -> damage: {damage}, health: {health}, armor: {armor}"
Constraints
•	N is in the range [1…100].
•	The dragon type and name are one word only, starting with a capital letter.
•	Damage, health, and armor are integers in the range [0 … 100000] or null.
*/