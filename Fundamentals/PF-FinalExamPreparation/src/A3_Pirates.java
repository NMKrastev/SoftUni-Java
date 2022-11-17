import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A3_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<Integer, Integer>> targetCitiesMap = addTargetCitiesToMap(scanner);

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            if (input.contains("Plunder")) {
                plunderCity(targetCitiesMap, input);
            } else if (input.contains("Prosper")) {
                addGoldToTreasury(targetCitiesMap, input);
            }
        }

        printResult(targetCitiesMap);
    }

    private static void printResult(Map<String, Map<Integer, Integer>> targetCitiesMap) {

        if (!targetCitiesMap.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", targetCitiesMap.size());
            targetCitiesMap.forEach((city, value) ->
                    value.forEach((population, gold) ->
                            System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", city, population, gold)));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }

    private static void addGoldToTreasury(Map<String, Map<Integer, Integer>> targetCitiesMap, String input) {

        int goldToAdd = Integer.parseInt(input.split("=>")[2]);
        if (goldToAdd < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            String city = input.split("=>")[1];
            int totalGold = 0;
            for (Map.Entry<Integer, Integer> entry : targetCitiesMap.get(city).entrySet()) {
                entry.setValue(entry.getValue() + goldToAdd);
                totalGold = entry.getValue();
            }
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", goldToAdd, city, totalGold);
        }
    }

    private static void plunderCity(Map<String, Map<Integer, Integer>> targetCitiesMap, String input) {
        String city = input.split("=>")[1];
        int populationToKill = Integer.parseInt(input.split("=>")[2]);
        int goldToSteal = Integer.parseInt(input.split("=>")[3]);

        if (targetCitiesMap.containsKey(city)) {
            for (Map.Entry<Integer, Integer> entry : targetCitiesMap.get(city).entrySet()) {
                int currentPopulation = entry.getKey();
                int currentGold = entry.getValue();

                targetCitiesMap.get(city).clear();
                targetCitiesMap.get(city).put(currentPopulation - populationToKill, currentGold - goldToSteal);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", city, goldToSteal, populationToKill);
                if (currentGold - goldToSteal <= 0 || currentPopulation - populationToKill <= 0) {
                    targetCitiesMap.remove(city);
                    System.out.printf("%s has been wiped off the map!\n", city);
                }
            }
        }
    }

    private static Map<String, Map<Integer, Integer>> addTargetCitiesToMap(Scanner scanner) {

        Map<String, Map<Integer, Integer>> targetCitiesMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Sail")) {

            String city = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);
            targetCitiesMap.putIfAbsent(city, new LinkedHashMap<>());
            if (!targetCitiesMap.get(city).isEmpty()) {
                for (Map.Entry<Integer, Integer> entry : targetCitiesMap.get(city).entrySet()) {
                    int currentPopulation = entry.getKey();
                    int currentGold = entry.getValue();
                    population += currentPopulation;
                    gold += currentGold;
                }
                targetCitiesMap.get(city).clear();
                targetCitiesMap.get(city).put(population, gold);
            } else {
                targetCitiesMap.get(city).put(population, gold);
            }
        }

        return targetCitiesMap;
    }
}
/*Until the "Sail" command is given, you will be receiving:
•	You and your crew have targeted cities, with their population and gold, separated by "||".
•	If you receive a city that has already been received, you have to increase the population and gold with the given values.
After the "Sail" command, you will start receiving lines of text representing events until the "End" command is given.
Events will be in the following format:
•	"Plunder=>{town}=>{people}=>{gold}"
o	You have successfully attacked and plundered the town, killing the given number of people and stealing the respective amount of gold.
o	For every town you attack print this message: "{town} plundered! {gold} gold stolen, {people} citizens killed."
o	If any of those two values (population or gold) reaches zero, the town is disbanded.
	You need to remove it from your collection of targeted cities and print the following message: "{town} has been wiped off the map!"
o	There will be no case of receiving more people or gold than there is in the city.
•	"Prosper=>{town}=>{gold}"
o	There has been dramatic economic growth in the given city, increasing its treasury by the given amount of gold.
o	The gold amount can be a negative number, so be careful. If a negative amount of gold is given, print: "Gold added
cannot be a negative number!" and ignore the command.
o	If the given gold is a valid amount, increase the town's gold reserves by the respective amount and print the following message:
"{gold added} gold added to the city treasury. {town} now has {total gold} gold."
Input
•	On the first lines, until the "Sail" command, you will be receiving strings representing the cities with their gold
and population, separated by "||"
•	On the following lines, until the "End" command, you will be receiving strings representing the actions described
above, separated by "=>"
Output
•	After receiving the "End" command, if there are any existing settlements on your list of targets, you need to print
 all of them, in the following format:
"Ahoy, Captain! There are {count} wealthy settlements to go to:
{town1} -> Population: {people} citizens, Gold: {gold} kg
{town2} -> Population: {people} citizens, Gold: {gold} kg
   …
{town…n} -> Population: {people} citizens, Gold: {gold} kg"
•	If there are no settlements left to plunder, print:
"Ahoy, Captain! All targets have been plundered and destroyed!"
Constraints
•	The initial population and gold of the settlements will be valid 32-bit integers, never negative, or exceed the respective limits.
•	The town names in the events will always be valid towns that should be on your list.
*/