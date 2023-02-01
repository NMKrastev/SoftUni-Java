package A3_StackIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack<Integer> customStack = new CustomStack<>();

        String input;
        while (!(input = scanner.nextLine()).trim().equals("END")) {
            if (input.contains("Push")) {
                input = input.replace("Push ", "");
                String[] data = input.split(",\\s+");
                for (String num : data) {
                    customStack.push(Integer.valueOf(num));
                }
            } else if (input.contains("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalArgumentException e) {
                    System.out.println("No elements");
                }
            }
        }

        customStack.forEach(System.out::println);
        customStack.forEach(System.out::println);
    }
}
/*Since you have passed the basics algorithms course, now you have a task to create your custom stack.
You are aware of the Stack structure. There is a collection to store the elements and two functions
(not from the functional programming) - to push an element and to pop it. Keep in mind that the first element,
which is popped, is the last in the collection. The push method adds an element to the top of the collection,
and the pop method returns the top element and removes it.
Write your custom implementation of Stack<Integer> and implement your custom iterator.
There is a way that IntelliJ could help you, your Stack class should implement the Iterable<Integer> interface,
and your Iterator Class should implement the Iterator<Integer> interface. Your Custom Iterator should follow the
rules of the Abstract Data Type - Stack. As we said, the first element is the element at the top and so on.
Iterators are used only for iterating through the collection, they should not remove or mutate the elements.
Input
The input will come from the console as lines of commands. Commands always will be "Push", "Pop" and "END",
followed by integers for the push command and no other input for the pop command.
Output
When you receive "END", the input is over. Foreach the stack twice and print all elements. Each element should be on a new line.
Constraints
•	The elements in the push command will be valid integers between [2-32…232-1].
•	There will be no more than 16 elements in the "Push" command.
•	If the "Pop" command could not be executed as expected (e.g., no elements in the stack), print on the console: "No elements".
*/
