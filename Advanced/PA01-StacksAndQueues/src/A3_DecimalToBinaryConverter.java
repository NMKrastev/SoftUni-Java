import java.util.ArrayDeque;
import java.util.Scanner;

public class A3_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (num == 0) {
            System.out.println(0);
        } else {

            while (num != 0) {
                stack.push(num % 2);
                num /= 2;
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
/*Create a simple program that can convert a decimal number to its binary representation. Implement an elegant solution using a Stack.
Print the binary representation back at the terminal.
*/
