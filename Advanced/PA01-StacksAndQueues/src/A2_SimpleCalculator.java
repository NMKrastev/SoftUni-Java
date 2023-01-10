import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class A2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);
        //Arrays.stream(input.split("\\s+")).forEach(n -> stack.push(n));

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operator.equals("+")) {
                stack.push(String.valueOf(firstNum + secondNum));
            } else {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }

        System.out.println(stack.pop());
    }
}
/*Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction. There will not be parentheses or operator precedence.
Solve the problem using a Stack.
*/