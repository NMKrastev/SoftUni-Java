import java.util.*;
import java.util.stream.Collectors;

public class A1_ApocalypsePreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String patch = "Patch";
        String bandage = "Bandage";
        String medKit = "MedKit";
        Map<String, Integer> itemsCreated = new LinkedHashMap<>(Map.of(
                "Patch", 0,
                "Bandage", 0,
                "MedKit", 0
        ));
        Deque<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textiles::offer);
        Deque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicaments::push);

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {

            int currentTextile = textiles.peek();
            int currentMedicament = medicaments.peek();
            int product = currentTextile + currentMedicament;

            if (product == 30) {
                itemsCreated.put(patch, itemsCreated.get(patch) + 1);
                textiles.poll();
                medicaments.pop();
            } else if (product == 40) {
                itemsCreated.put(bandage, itemsCreated.get(bandage) + 1);
                textiles.poll();
                medicaments.pop();
            } else if (product == 100) {
                itemsCreated.put(medKit, itemsCreated.get(medKit) + 1);
                textiles.poll();
                medicaments.pop();
            } else if (product > 100) {
                itemsCreated.put(medKit, itemsCreated.get(medKit) + 1);
                textiles.poll();
                medicaments.pop();
                int remainingResource = product - 100;
                int nextElement = medicaments.pop();
                nextElement += remainingResource;
                medicaments.push(nextElement);
            } else {
                textiles.poll();
                medicaments.pop();
                currentMedicament += 10;
                medicaments.push(currentMedicament);
            }
        }

        Map<String, Integer> sortedItems = itemsCreated.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            printItems(sortedItems);
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
            printItems(sortedItems);
            System.out.printf("Medicaments left: %s\n", medicaments.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        } else {
            System.out.println("Medicaments are empty.");
            printItems(sortedItems);
            System.out.printf("Textiles left: %s\n", textiles.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }

    private static void printItems(Map<String, Integer> sortedItems) {
        sortedItems.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue()));
    }
}
/*On the first line, you will be given a sequence representing textiles. On the second line,
you will be given another sequence, which represents medicaments.
While both collections contain any elements, you will have to combine elements from the collections
in order to create healing items. You should start by getting the first value of textile and the last value of medicaments:
•	if their sum is equal to any of the items in the table below create that item and remove both values.
•	Otherwise, check if the sum is bigger than the value of the MedKit, create the MedKit, remove both values,
and add the remaining resources(of the sum) to the next value in the medicament collection
(Take the element from the collection, add the remaining sum to it, and put the element back to its place).
•	If you can’t create anything, remove the textile value, add 10 to the medicament value,
and return the medicament back to its place, into its collection.
You need to stop creating healing items when either the textile or the medicaments are exhausted.
Healing item	Resources needed
Patch	30
Bandage	40
MedKit	100
In the end, you should print on the console message for the sequence that has ended, then the created items,
and in the end the remaining items (if any).
Input
•	On the first line, you will receive a sequence of integers representing the textiles, separated by a single space (" ").
•	On the second line, you will receive a sequence of integers representing the medicaments, separated by a single space (" ").
Output
•	On the first line, print which one of the collections is over:
o	If the textile is over print: "Textiles are empty."
o	If the medicaments are over print: "Medicaments are empty."
o	If both are empty print: "Textiles and medicaments are both empty."
•	On the next n lines print only the created items (if any) ordered by the amount created descending, then by name alphabetically:
"{item name} - {amount created}
 {item name} - {amount created}
…"
Hint: Do not print items, which are not created.
•	On the last line print the remaining items (if any):
o	If there are any medicaments left:
"Medicaments left: {medicament1}, {medicament2}…"
o	If there are any textiles left:
"Textiles left: {textile1}, {textile2}…"
*/
