package EP13_JavaAdvancedRetakeExam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class A1_Blacksmith {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gladius = "Gladius";
        String katana = "Katana";
        String sabre = "Sabre";
        String shamshir = "Shamshir";
        Map<String, Integer> swordsMap = new TreeMap<>(Map.of(
                gladius, 0,
                katana, 0,
                sabre, 0,
                shamshir, 0
        ));
        int swordsCount = 0;
        Deque<Integer> steel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steel::offer);
        Deque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int currentSteel = steel.poll();
            int currentCarbon = carbon.pop();
            int product = currentSteel + currentCarbon;

            if (product == 70) {
                swordsMap.put(gladius, swordsMap.get(gladius) + 1);
                swordsCount++;
            } else if (product == 80) {
                swordsMap.put(shamshir, swordsMap.get(shamshir) + 1);
                swordsCount++;
            } else if (product == 90) {
                swordsMap.put(katana, swordsMap.get(katana) + 1);
                swordsCount++;
            } else if (product == 110) {
                swordsMap.put(sabre, swordsMap.get(sabre) + 1);
                swordsCount++;
            } else {
                currentCarbon += 5;
                carbon.push(currentCarbon);
            }
        }

        System.out.println(swordsCount > 0
                ? String.format("You have forged %d swords.", swordsCount)
                : "You did not have enough resources to forge a sword.");
        System.out.println(steel.isEmpty()
                ? "Steel left: none"
                : String.format("Steel left: %s", steel.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))));
        System.out.println(carbon.isEmpty()
                ? "Carbon left: none"
                : String.format("Carbon left: %s", carbon.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))));
        swordsMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }
}
/*First, you will be given a sequence representing steel. Afterward, you will be given another sequence representing carbon.
You should start from the first steel and try to mix it with the last carbon. If the sum of their values is equal
to any of the swords in the table below you should forge the sword corresponding to the value and remove both the steel
and the carbon. Otherwise, remove only the steel, increase the value of the carbon by 5 and insert it back into the collection.
You need to stop forging when you have no more steel or carbon left.
Forge as many swords as possible.
Input
•	On the first line, you will receive the steel, separated by a single space (" ").
•	On the second line, you will receive the carbon, separated by a single space (" ").
Output
•	On the first line of output depending on the result:
o	If at least one sword was forged: "You have forged {totalNumberOfSwords} swords."
o	If no sword was forged: "You did not have enough resources to forge a sword."
•	On the second line - print all steel you have left:
o	If there are no steel: "Steel left: none"
o	If there are steel: "Steel left: {steel1}, {steel2}, {steel3}, (…)"
•	On the third line - print all carbon you have left:
o	If there are no carbon: "Carbon left: none"
o	If there are carbon: "Carbon left: {carbon1}, {carbon2}, {carbon3}, (…)"
•	Then, you need to print only the swords that you manage to forge and how many of them, ordered alphabetically:
o	"Sabre: {amount}"
o	"Katana: {amount}"
o	"Shamshir: {amount}"
o	"Gladius: {amount}"
Constraints
•	All of the given numbers will be valid resources in the range [0, 130].

*/
