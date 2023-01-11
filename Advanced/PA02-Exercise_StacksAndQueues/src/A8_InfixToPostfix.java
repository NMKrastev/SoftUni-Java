import java.util.ArrayDeque;
import java.util.Scanner;

public class A8_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < input.length; i++) {
            String currentSymbol = input[i];

            if (currentSymbol.chars().allMatch(Character::isLetterOrDigit)) {
                output.append(currentSymbol);
                output.append(" ");
            } else if (currentSymbol.equals("(")) {
                stack.push(currentSymbol);
            } else if (currentSymbol.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.append(stack.pop());
                    output.append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getOpPrecedence(currentSymbol) <= getOpPrecedence(stack.peek())
                        && hasPreviousOperator(currentSymbol)) {
                    output.append(stack.pop());
                    output.append(" ");
                }

                stack.push(currentSymbol);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
            output.append(" ");
        }

        System.out.println(output.toString().trim());
    }

    private static boolean hasPreviousOperator(String currentSymbol) {

        return currentSymbol.equals("+") || currentSymbol.equals("-")
                || currentSymbol.equals("/") || currentSymbol.equals("*");
    }

    private static int getOpPrecedence(String currentSymbol) {

        if (currentSymbol.equals("+") || currentSymbol.equals("-")) {
            return 1;
        } else if (currentSymbol.equals("/") || currentSymbol.equals("*")) {
            return 2;
        } else if (currentSymbol.equals("^")) {
            return 3;
        } else {
            return -1;
        }
    }
}
/*Mathematical expressions are written in an infix notations, for example "5 / ( 3 + 2 )". However, this kind of
notation is not efficient for computer processing, as you first need to evaluate the expression inside the brackets,
so there is a lot of back and forth movement. A more suitable approach is to convert it into the so-called postfix
notations (also called Reverse Polish Notation), in which the expression is evaluated from left to right, for example, "3 2 + 5 /".
Implement an algorithm that converts the mathematical expression from infix notation into a postfix notation.
Use the famous Shunting-yard algorithm.
Input
•	You will receive an expression on a single line consisting of tokens.
•	Tokens could be numbers 0-9, variables a-z, operators +, -, *, / and brackets ( or ).
•	Each token is separated by exactly one space.
Output
•	The output should be on a single line, consisting of tokens separated by exactly one space.
*/
