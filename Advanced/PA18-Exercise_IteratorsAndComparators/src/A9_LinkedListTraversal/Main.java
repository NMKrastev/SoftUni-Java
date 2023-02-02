package A9_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<>();
        int numOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCommands; i++) {
            String input = scanner.nextLine();
            if (input.contains("Add")) {
                linkedList.add(Integer.parseInt(input.split("\\s+")[1]));
            } else if (input.contains("Remove")) {
                linkedList.remove(Integer.parseInt(input.split("\\s+")[1]));
            }
        }

        System.out.println(linkedList.getSize());
        linkedList.forEach(e -> System.out.print(e + " "));
    }
}
/*You need to write your simplified implementation of a generic Linked List that has an Iterator.
The list should support the Add and Remove operations, should reveal the amount of elements it has with a getSize
function and should have an implemented iterator (should be foreachable). The add method should add the new element
at the end of the collection. The remove method should remove the first occurrence of the item starting at the
beginning of the collection, if the element is successfully removed, the method returns true, alternatively,
if the element passed is not in the collection, the method should return false. The getSize method should return
the number of elements currently in the list. The iterator should iterate over the collection starting from the first entered element.
Input
On the first line of input, you will receive a number N. On each of the next N lines, you will receive a command
in one of the following formats:
•	"Add {number}" - adds a number to your linked list.
•	"Remove {number}" - removes the first occurrence of the number from the linked list. If there is no such element,
this command leaves the collection unchanged.
Output
The output should consist of exactly 2 lines. First, you should print the result of calling the getSize
function on the Linked list. On the next lines, you should print all elements of the collection by calling foreach on the collection.
Constraints
•	All numbers in the input will be valid integers between [2-32…232-1].
•	All commands received through the input will be valid (will be only "Add" or "Remove").
•	The number N will be a positive integer between [1…500].
*/
