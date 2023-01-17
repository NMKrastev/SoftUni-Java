import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class A11_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterialsMap = new TreeMap<>();
        Map<String, Integer> junkMaterialsMap = new TreeMap<>();
        boolean isObtained = false;
        keyMaterialsMap.put("shards", 0);
        keyMaterialsMap.put("fragments", 0);
        keyMaterialsMap.put("motes", 0);

        while (true) {

            String[] line = scanner.nextLine().split("\\s+");

            for (int i = 0; i < line.length; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String material = line[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterialsMap.put(material, keyMaterialsMap.get(material) + quantity);
                } else {
                    junkMaterialsMap.putIfAbsent(material, 0);
                    junkMaterialsMap.put(material, junkMaterialsMap.get(material) + quantity);
                }

                if (material.equals("shards") && keyMaterialsMap.get(material) >= 250) {
                    int materialsLeft = keyMaterialsMap.get(material) - 250;
                    keyMaterialsMap.put(material, materialsLeft);
                    System.out.println("Shadowmourne obtained!");
                    printResult(keyMaterialsMap, junkMaterialsMap);
                    isObtained = true;
                    break;
                } else if (material.equals("fragments") && keyMaterialsMap.get(material) >= 250) {
                    int materialsLeft = keyMaterialsMap.get(material) - 250;
                    keyMaterialsMap.put(material, materialsLeft);
                    System.out.println("Valanyr obtained!");
                    printResult(keyMaterialsMap, junkMaterialsMap);
                    isObtained = true;
                    break;
                } else if (material.equals("motes") && keyMaterialsMap.get(material) >= 250) {
                    int materialsLeft = keyMaterialsMap.get(material) - 250;
                    keyMaterialsMap.put(material, materialsLeft);
                    System.out.println("Dragonwrath obtained!");
                    printResult(keyMaterialsMap, junkMaterialsMap);
                    isObtained = true;
                    break;
                }
            }
            if (isObtained) {
                break;
            }
        }
    }

    private static void printResult(Map<String, Integer> keyMaterialsMap, Map<String, Integer> junkMaterialsMap) {

        keyMaterialsMap = keyMaterialsMap.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        keyMaterialsMap.forEach((keyFragments, quantities) ->
            System.out.printf("%s: %d\n", keyFragments, quantities));
        junkMaterialsMap.forEach((keyFragments, quantities) ->
                System.out.printf("%s: %d\n", keyFragments, quantities));
    }
}
/*You've beaten all the content, and the last thing left to accomplish is to own a legendary item. However, it's a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible items are:
•	Shadowmourne – requires 250 Shards;
•	Valanyr – requires 250 Fragments;
•	Dragonwrath – requires 250 Motes;
Shards, Fragments, and Motes are the key materials, all else is junk. You will be given lines of input, such as
2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, and motes, ordered by quantity in descending order, each on a new line. Finally, print the collected junk items in alphabetical order.
Input
•	Each line of input is in format "{quantity} {material} {quantity} {material} … {quantity} {material}".
Output
•	On the first line, print the obtained item in the format "{Legendary item} obtained!".
•	On the next three lines, print the remaining key materials in descending order by quantity.
o	If two key materials have the same quantity, print them in alphabetical order.
•	On the final several lines, print the junk items in alphabetical order.
o	All materials are printed in format "{material}: {quantity}".
o	All output should be lowercase, except the first letter of the legendary.
Constraints
•	The quantity-material pairs are between 1 and 25 per line.
•	The number of lines is in the range [1..10].
•	All materials are case-insensitive.
•	Allowed time: 250ms/16MB.
*/
