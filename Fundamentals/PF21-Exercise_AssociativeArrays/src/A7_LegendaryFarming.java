import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A7_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materialsMap = new LinkedHashMap<>();
        boolean isObtained = false;
        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);

        while (true) {

            String[] line = scanner.nextLine().split("\\s+");

            for (int i = 0; i < line.length; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String material = line[i + 1].toLowerCase();

                if (!materialsMap.containsKey(material)) {
                    materialsMap.putIfAbsent(material, quantity);
                } else {
                    int allQuantity = materialsMap.get(material);
                    allQuantity += quantity;
                    materialsMap.put(material, allQuantity);
                }

                if (material.equals("shards") && materialsMap.get(material) >= 250) {
                    int materialsLeft = materialsMap.get(material) - 250;
                    materialsMap.put(material, materialsLeft);
                    System.out.println("Shadowmourne obtained!");
                    printResult(materialsMap);
                    isObtained = true;
                    break;
                } else if (material.equals("fragments") && materialsMap.get(material) >= 250) {
                    int materialsLeft = materialsMap.get(material) - 250;
                    materialsMap.put(material, materialsLeft);
                    System.out.println("Valanyr obtained!");
                    printResult(materialsMap);
                    isObtained = true;
                    break;
                } else if (material.equals("motes") && materialsMap.get(material) >= 250) {
                    int materialsLeft = materialsMap.get(material) - 250;
                    materialsMap.put(material, materialsLeft);
                    System.out.println("Dragonwrath obtained!");
                    printResult(materialsMap);
                    isObtained = true;
                    break;
                }
            }
            if (isObtained) {
                break;
            }
        }
    }

    private static void printResult(Map<String, Integer> materialsMap) {

        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
/**/