package A2_Collection;

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
                case "PrintAll":
                    listyIterator.printAll();
                    break;

            }
        }
    }
}
/*Using the ListyIterator from the last problem, extend it by implementing the Iterable interface, and implement all
methods desired by the interface manually. Add a new method to the class PrintAll(), the method should foreach the
collection and print all elements on a single line separated by a space.
Input
Input will come from the console as lines of commands. The first line will always be the "Create" command in the input
and it will always be the first command passed. The last command received will always be the "END" command.
Output
For every command from the input (with the exception of the "END" and "Create" commands) print the result of that
command on the console, each on a new line. In the case of Move or HasNext commands print the returned value of the method,
in the case of a "Print" command, you don't have to do anything additional as the method itself should already
print on the console. In the case of a "PrintAll" command, you should print all elements on a single line separated
by spaces. Your program should catch any exceptions thrown because of validations and print their messages instead.
Constraints
•	Do not use the built-in iterators!
•	The number of commands received will be between [1…100].
*/
