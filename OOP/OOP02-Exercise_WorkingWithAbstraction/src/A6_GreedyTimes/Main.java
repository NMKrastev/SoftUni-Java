package A6_GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);
        Item item;

        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            try {
                item = createItem(itemName, amount);
            } catch (IllegalArgumentException e) {
                continue;
            }
            bag.add(item);
        }
        System.out.println(bag);
    }

    private static Item createItem(String itemName, long amount) {
        ItemType itemType;
        if (itemName.length() == 3) {
            itemType = ItemType.CASH;
        } else if (itemName.length() >= 4 && itemName.toLowerCase().endsWith("gem")) {
            itemType = ItemType.GEM;
        } else if (itemName.equalsIgnoreCase("Gold")) {
            itemType = ItemType.GOLD;
        } else {
            throw new IllegalArgumentException("Not a valid type!");
        }

        return new Item(itemType, itemName, amount);
    }
}
/*Finally, you have unlocked the safe and reached the treasure! Inside there are all kinds of gems,
cash in different currencies, and gold bullions. Next to you, there is a bag which unfortunately has limited space.
You don’t have much time so you need to take as much wealth as possible! But to get a bigger amount of the most valuable
items, you need to keep the following rules:
•	The gold amount in your bag should always be more than or equal to the gem amount at any time
•	The gem amount should always be more than or equal to the cash amount at any time
If you read an item that breaks one of these rules you should not put it in the bag. You should always be careful
not to exceed the overall bag’s capacity because it will tear down and you will lose everything! You will receive
the content of the safe on a single line in the format "{item} {quantity}" pairs, separated by whitespace.
You need to gather only three types of items:
•	Cash - All three letter items
•	Gem - All items which end on "Gem" (at least 4 symbols)
•	Gold - this type has only one item with the name - "Gold"
Each item that does not fall in one of the above categories is useless and you should skip it.
Reading item’s names should be CASE-INSENSITIVE, except when the item is Cash. You should aggregate items’
quantities that have the same name.
If you’ve kept the rules you should escape successfully with a bag full of wealth. Now it’s time to review
what you have managed to get out of the safe. Print all the types ordered by the total amount in descending order.
Inside a type, order the items first alphabetically in descending order and then by their amount in ascending order.
Use the format described below for each type.
Input
•	On the first line, you will receive a number that represents the capacity of the bag.
•	On the second line, you will receive a sequence of item and quantity pairs.
Output
Print only the types from which you have items in the bag ordered by Total Amount descending.
Inside a type order, the items are first alphabetically in descending order and then by an amount in ascending order.
Use the following format for each type:
"<{type}> ${total amount}"
"##{item} - {amount}" - each item on new line
*/
