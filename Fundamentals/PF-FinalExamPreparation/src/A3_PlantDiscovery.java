import java.util.*;

public class A3_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> rarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> ratingMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        String input = "";
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            rarityMap.putIfAbsent(plant, rarity);
            rarityMap.put(plant, rarity);
        }

        for (Map.Entry<String, Integer> entry : rarityMap.entrySet()) {
            String currentPlant = entry.getKey();
            ratingMap.put(currentPlant, new ArrayList<>());
        }


        while (!(input = scanner.nextLine()).equals("Exhibition")) {

            String command = input.split(":")[0];
            String plant = input.split(":|-".trim())[1].replaceAll(" ", "");
            if (ratingMap.containsKey(plant)) {
                if (command.equals("Rate")) {
                    double rating = Double.parseDouble(input.split("-\\s+".trim())[1]);
                    ratingMap.get(plant).add(rating);
                } else if (command.equals("Update")) {
                    int newRarity = Integer.parseInt(input.split("-\\s+".trim())[1]);
                    rarityMap.put(plant, newRarity);
                } else if (command.equals("Reset")) {
                    ratingMap.put(plant, new ArrayList<>());
                }
            } else {
                System.out.println("error");
            }
        }
        printResult(rarityMap, ratingMap);
    }

    private static void printResult(Map<String, Integer> rarityMap, Map<String, List<Double>> ratingMap) {

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> rarityEntry : rarityMap.entrySet()) {
            for (Map.Entry<String, List<Double>> ratingEntry : ratingMap.entrySet()) {
                if (ratingEntry.getKey().equals(rarityEntry.getKey())) {
                    double sum = 0;
                    for (Double currentRating : ratingEntry.getValue()) {
                        sum += currentRating;
                    }
                    sum /= ratingEntry.getValue().size();
                    if (sum != sum) {
                        sum = 0;
                    }
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", rarityEntry.getKey(), rarityEntry.getValue(), sum);
                    break;
                }
            }
        }
    }
}
/*On the first line, you will receive a number n. On the next n lines, you will be given some information about the plants
that you have discovered in the format: "{plant}<->{rarity}". Store that information because you will need it later.
If you receive a plant more than once, update its rarity.
After that, until you receive the command "Exhibition", you will be given some of these commands:
•	"Rate: {plant} - {rating}" – add the given rating to the plant (store all ratings)
•	"Update: {plant} - {new_rarity}" – update the rarity of the plant with the new one
•	"Reset: {plant}" – remove all the ratings of the given plant
Note: If any given plant name is invalid, print "error"
After the command "Exhibition", print the information that you have about the plants in the following format:
"Plants for the exhibition:
- {plant_name1}; Rarity: {rarity}; Rating: {average_rating}
- {plant_name2}; Rarity: {rarity}; Rating: {average_rating}
…
- {plant_nameN}; Rarity: {rarity}; Rating: {average_rating}"
The average rating should be formatted to the second decimal place.
Input / Constraints
•	You will receive the input as described above
•	JavaScript: you will receive a list of strings
Output
•	Print the information about all plants as described above
*/