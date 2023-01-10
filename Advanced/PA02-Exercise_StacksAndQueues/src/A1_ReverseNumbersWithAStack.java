import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A1_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> reversedStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+")).forEach(num -> reversedStack.push(Integer.valueOf(num)));
        while (!reversedStack.isEmpty()) {
            System.out.print(reversedStack.pop() + " ");
        }
    }
}
/*Write a program that reads N integers from the console and reverses them using a stack.
Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.*/
