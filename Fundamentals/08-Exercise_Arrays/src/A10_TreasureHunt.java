import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A10_TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while(!line.equals("Yohoho!")) {

            List<String> treasure = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String command = treasure.get(0);

            if (command.equals("Loot")) {

                for (int i = 1; i < treasure.size(); i++) {

                    if (!initialLoot.contains(treasure.get(i))) {

                     initialLoot.add(0, treasure.get(i));

                    }
                }
            }

            if (command.equals("Drop")) {

                int index = Integer.parseInt(treasure.get(1));

                if (index >= 0 && index < initialLoot.size()) {

                    String item = initialLoot.get(index);
                    initialLoot.remove(index);
                    initialLoot.add(item);

                }
            }

            if (command.equals("Steal")) {

                int count = Integer.parseInt(treasure.get(1));

                if (count > initialLoot.size()) {

                    count = initialLoot.size();

                }

                List<String> subList = initialLoot.subList(initialLoot.size() - count, initialLoot.size());
                System.out.println(String.join(", ", subList));
                initialLoot = initialLoot.subList(0, initialLoot.size() - count);

            }

            line = scanner.nextLine();
        }

        if (!initialLoot.isEmpty()) {

            int sumLength = 0;

            for (String currentItem : initialLoot) {

                sumLength += currentItem.length();

            }

            double averageGains = sumLength * 1.0 / initialLoot.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageGains);

        } else {

            System.out.println("Failed treasure hunt.");

        }
    }
}
/*The pirates must safely carry a treasure chest back to the ship, looting along the way.
Create a program that manages the state of the treasure chest along the way. On the first
line, you will receive the initial loot of the treasure chest, a string of items separated by a "|".
"{loot1}|{loot2}|{loot3} … {lootn}"
The following lines represent commands until "Yohoho!" which ends the treasure hunt:
· "Loot {item1} {item2}…{itemn}":
o Pick up treasure loot along the way. Insert the items at the beginning of the chest.
o If an item is already contained, don't insert it.
· "Drop {index}":
o Remove the loot at the given position and add it to the end of the treasure chest.
o If the index is invalid, skip the command.
· "Steal {count}":
o Someone steals the last count loot items. If there are fewer items than the given count, remove as many as there are.
o Print the stolen items separated by ", ":
"{item1}, {item2}, {item3} … {itemn}"
In the end, output the average treasure gain, which is the sum of all treasure items length
divided by the count of all items inside the chest formatted to the second decimal point:
"Average treasure gain: {averageGain} pirate credits."
If the chest is empty, print the following message:
"Failed treasure hunt."
Input:
· On the 1st line, you will receive the initial treasure chest (loot separated by "|").
· On the following lines, you will receive commands until "Yohoho!".
Output:
· Print the output in the format described above.
Constraints:
· The loot items will be strings containing any ASCII code.
· The indexes will be integers in the range [-200…200].
· The count will be an integer in the range [1….100].*/