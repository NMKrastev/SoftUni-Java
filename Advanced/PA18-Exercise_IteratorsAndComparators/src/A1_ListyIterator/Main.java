package A1_ListyIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] line = input.split("\\s+");

            switch (line[0]) {
                case "Create":
                    if (line.length > 1) {
                        String[] collection = new String[line.length - 1];
                        System.arraycopy(line, 1, collection, 0, line.length - 1);
                        listyIterator = new ListyIterator(collection);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
            }
        }
    }
}
/*Create a class ListyIterator, it should receive the collection of Strings which it will iterate, through its constructor.
You should store the elements in a List. The class should have three main functions:
•	Move - should move an internal index position to the next index in the list, the method should return true
if it successfully moved and false if there is no next index.
•	HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
•	Print - should print the element at the current internal index, calling Print on a collection without elements
should throw an appropriate exception with the message "Invalid Operation!".
By default, the internal index should be pointing to the 0th index of the List.
Input
Input will come from the console as lines of commands. The first line will always be the "Create" command in the input,
and it will always be the first command passed. The last command received will always be the "END" command.
Output
For every command from the input (with the exception of the "END" and "Create" commands),
print the result of that command on the console, each on a new line. In the case of "Move" or "HasNext" commands,
print the returned value of the method, in the case of a "Print" command you don't have to do anything additional
as the method itself should already print on the console. Your program should catch any exceptions thrown because
of validations (calling Print on an empty collection) and print their messages instead.
*/
