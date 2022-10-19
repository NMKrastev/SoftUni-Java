import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceryList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        groceryList = distribution(scanner, groceryList);
        printGroceryList(groceryList);

    }

    private static void printGroceryList(List<String> groceryList) {
        System.out.println(groceryList.toString().replaceAll("[\\[\\]]", ""));
    }

    private static List<String> distribution(Scanner scanner, List<String> groceryList) {

        String command = "";

        while (!(command = scanner.nextLine()).equals("Go Shopping!")) {

            if (command.contains("Urgent")) {
                String item = command.split("\\s+")[1];
                groceryList = addItemAtTheStart(groceryList, item);
            } else if (command.contains("Unnecessary")) {
                String item = command.split("\\s+")[1];
                groceryList = removeItemFromList(groceryList, item);
            } else if (command.contains("Correct")) {
                String oldItem = command.split("\\s+")[1];
                String newItem = command.split("\\s+")[2];
                groceryList = correctOldWithNewItem(groceryList, oldItem, newItem);
            } else if (command.contains("Rearrange")) {
                String item = command.split("\\s+")[1];
                groceryList = rearrangeItem(groceryList, item);
            }
        }
        return groceryList;
    }

    private static List<String> addItemAtTheStart(List<String> groceryList, String item) {

        if (!groceryList.contains(item)) {
            groceryList.add(0, item);
        }
        return groceryList;
    }

    private static List<String> removeItemFromList(List<String> groceryList, String item) {

        if (groceryList.contains(item)) {
            groceryList.removeAll(Collections.singleton(item));
        }
        return groceryList;
    }

    private static List<String> correctOldWithNewItem(List<String> groceryList, String oldItem, String newItem) {

        if (groceryList.contains(oldItem)) {
            groceryList.set(groceryList.indexOf(oldItem), newItem);
        }
        return groceryList;
    }

    private static List<String> rearrangeItem(List<String> groceryList, String item) {

        String tempItem = item;
        if (groceryList.contains(item)) {
            groceryList.removeAll(Collections.singleton(item));
            groceryList.add(tempItem);
        }
        return groceryList;
    }
}
/*Input
You will receive an initial list with groceries separated by an exclamation mark "!".
After that, you will be receiving 4 types of commands until you receive "Go Shopping!".
•	"Urgent {item}" - add the item at the start of the list.  If the item already exists, skip this command.
•	"Unnecessary {item}" - remove the item with the given name, only if it exists in the list.
Otherwise, skip this command.
•	"Correct {oldItem} {newItem}" - if the item with the given old name exists, change its name with the new one.
Otherwise, skip this command.
•	"Rearrange {item}" - if the grocery exists in the list, remove it from its current position and add it at
the end of the list. Otherwise, skip this command.
Constraints
•	There won't be any duplicate items in the initial list
Output
•	Print the list with all the groceries, joined by ", ":
"{firstGrocery}, {secondGrocery}, … {nthGrocery}"
*/