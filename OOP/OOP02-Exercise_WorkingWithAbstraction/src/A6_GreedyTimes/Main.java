package A6_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i].toLowerCase();
            long amount = Long.parseLong(safe[i + 1]);

            String itemType = "";

            if (itemName.equals("cash")) {
                itemType = "Cash";
            } else if (itemName.equals("gem")) {
                itemType = "Gem";
            } else if (itemName.equals("gold")) {
                itemType = "Gold";
            }

            long bagCurrentSize = bag.values().stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e).sum() + amount;
            if (capacity < bagCurrentSize) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemType)) {
                bag.put((itemType), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(itemType).containsKey(itemName)) {
                bag.get(itemType).put(itemName, 0L);
            }


            bag.get(itemType).put(itemName, bag.get(itemType).get(itemName) + amount);
            if (itemType.equals("Gold")) {
                gold += amount;
            } else if (itemType.equals("Gem")) {
                gems += amount;
            } else if (itemType.equals("Cash")) {
                cash += amount;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}