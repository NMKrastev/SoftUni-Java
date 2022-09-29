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
