import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventoryList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        inventoryList = distribution(scanner, inventoryList);
        printInventoryList(inventoryList);
    }

    private static void printInventoryList(List<String> inventoryList) {
        System.out.println(inventoryList.toString().replaceAll("[\\[\\]]", ""));
    }

    private static List<String> distribution(Scanner scanner, List<String> inventoryList) {
        String command = "";

        while (!(command = scanner.nextLine()).equals("Craft!")) {

            if (command.contains("Collect")) {
                String item = command.split(" ")[2];
                inventoryList = collectItem(inventoryList, item);
            }
            if (command.contains("Drop")) {
                String item = command.split(" ")[2];
                inventoryList = dropItem(inventoryList, item);
            }
            if (command.contains("Combine")) {
                String itemOne = command.split(":| ")[3];
                String itemTwo = command.split(":| ")[4];
                inventoryList = combineItems(inventoryList, itemOne, itemTwo);
            }
            if (command.contains("Renew")) {
                String item = command.split(" ")[2];
                inventoryList = renewItem(inventoryList, item);
            }
        }
        return inventoryList;
    }

    private static List<String> collectItem(List<String> inventoryList, String item) {

        if (!inventoryList.contains(item)) {
            inventoryList.add(item);
        }
        return inventoryList;
    }

    private static List<String> dropItem(List<String> inventoryList, String item) {

        if (inventoryList.contains(item)) {
            inventoryList.removeAll(Collections.singleton(item));
        }
        return inventoryList;
    }

    private static List<String> combineItems(List<String> inventoryList, String itemOne, String itemTwo) {

        if (inventoryList.contains(itemOne)) {
            int index = inventoryList.indexOf(itemOne);
            inventoryList.add(index + 1, itemTwo);
        }
        return inventoryList;
    }

    private static List<String> renewItem(List<String> inventoryList, String item) {

        if (inventoryList.contains(item)) {
            int index = inventoryList.indexOf(item);
            inventoryList.add(item);
            inventoryList.remove(index);
        }
        return inventoryList;
    }
}
/*You will receive a journal with some collecting items, separated with a comma and a space (", "). After that,
until receiving "Craft!" you will be receiving different commands split by " - ":
•	"Collect - {item}" - you should add the given item to your inventory. If the item already exists,
you should skip this line.
•	"Drop - {item}" - you should remove the item from your inventory if it exists.
•	"Combine Items - {old_item}:{new_item}" - you should check if the old item exists. If so, add the new item after
the old one. Otherwise, ignore the command.
•	"Renew – {item}" – if the given item exists, you should change its position and put it last in your inventory.
Output
After receiving "Craft!" print the items in your inventory, separated by ", ".
*/