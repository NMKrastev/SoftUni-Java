import java.util.ArrayDeque;
import java.util.Scanner;

public class A7_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfOperations = Integer.parseInt(scanner.nextLine());
        String input;
        StringBuilder message = new StringBuilder("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(message.toString());

        for (int i = 0; i < numOfOperations; i++) {

            input = scanner.nextLine();
            int command = Integer.parseInt(input.split("\\s+")[0]);
            switch (command) {
                case 1:
                    message.append(input.split("\\s+")[1]);
                    stack.push(message.toString());
                    break;
                case 2:
                    int elementsToDelete = Integer.parseInt(input.split("\\s+")[1]);
                    message.delete(message.length() - elementsToDelete, message.length());
                    stack.push(message.toString());
                    break;
                case 3:
                    int indexOfElement = Integer.parseInt(input.split("\\s+")[1]);
                    String element = String.valueOf(message.charAt(indexOfElement - 1));
                    System.out.println(element);
                    break;
                case 4:
                    stack.pop();
                    message = new StringBuilder();
                    message.append(stack.peek());
                    break;
            }
        }
    }
}
/*You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
•	"1 {string}" - appends [string] to the end of the text.
•	"2 {count}" - erases the last [count] elements from the text.
•	"3 {index}" - returns the element at position [index] from the text.
•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
Input
•	The first line contains N, the number of operations, where 1 ≤ N ≤ 105.
•	Each of the following N lines contains the name of the operation, followed by the command argument, if any,
separated by space in the following format "command argument".
•	The length of the text will not exceed 1000000.
•	All input characters are English letters.
•	It is guaranteed that the sequence of input operations is possible to perform.
Output
•	For each operation of type "3" print a single line with the returned character of that operation.
*/
