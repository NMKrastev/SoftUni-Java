import java.util.ArrayDeque;
import java.util.Scanner;

public class A5_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> characterStack = new ArrayDeque<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            for (char character : line.toCharArray()) {

                if (character == '(' || character == '[' || character == '{') {
                    characterStack.push(character);
                    continue;
                }
                if (character == ')' && !characterStack.isEmpty() && characterStack.peek() == '(') {
                    characterStack.pop();
                    continue;
                }
                if (character == ']' && !characterStack.isEmpty() && characterStack.peek() == '[') {
                    characterStack.pop();
                    continue;
                }
                if (character == '}' && !characterStack.isEmpty() && characterStack.peek() == '{') {
                    characterStack.pop();
                    continue;
                }
                if (character == ')' || character == ']' || character == '}') {
                    characterStack.push(character);
                    break;
                }
            }

            System.out.println(characterStack.isEmpty() ? "YES" : "NO");
        }
    }
}
/*Given a sequence consisting of parentheses, determine whether the expression is balanced. A sequence of parentheses
is balanced if every open parenthesis can be paired uniquely with a closing parenthesis that occurs after the former.
Also, the interval between them must be balanced.
You will be given three types of parentheses: (, {, and [.
{[()]} - This is a balanced parenthesis.
{[(])} - This is not a balanced parenthesis.
Input
•	Each input consists of a single line, the sequence of parentheses.
•	1 ≤ Length of sequence ≤ 1000.
•	Each character of the sequence will be one of the following: {, }, (, ), [, ].
Output
•	For each test case, print on a new line "YES" if the parentheses are balanced. Otherwise, print "NO".
*/
