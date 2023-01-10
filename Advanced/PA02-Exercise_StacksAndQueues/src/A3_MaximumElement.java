import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class A3_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numOfCommands; i++) {

            int command = scanner.nextInt();

            if (command == 1) {
                int numToPush = scanner.nextInt();
                stack.push(numToPush);
                if (numToPush >= max) {
                    max = numToPush;
                    maxStack.push(max);
                }
            } else if (command == 2) {
                int poppedItem = stack.pop();
                if (poppedItem == max) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        max = maxStack.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(max);
            }
        }
    }
}
/*You have an empty sequence, and you will be given N commands. Each command is one of the following types:
•	"1 X" - Push the element X into the stack.
•	"2" - Delete the element present at the top of the stack.
•	"3" - Print the maximum element in the stack.
Input
•	The first line of input contains an integer N, where 1 ≤ N ≤ 105.
•	The next N lines contain commands. All commands will be valid and in the format described.
•	The element X will be in the range 1 ≤ X ≤ 109.
•	The type of the command will be in the range 1 ≤ Type ≤ 3.
Output
•	For each command of type "3", print the maximum element in the stack on a new line.
*/
