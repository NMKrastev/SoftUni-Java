import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_EnterNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        List<Integer> allInRange = new ArrayList<>();

        while (allInRange.size() < 10) {

            try {
                start = readNumber(start, end, scanner);
                allInRange.add(start);
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Number!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(allInRange.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

    }

    public static int readNumber(int start, int end, Scanner scanner) {

        int number = Integer.parseInt(scanner.nextLine());

        if (start >= number || number >= end) {
            throw new IllegalStateException(String.format("Your number is not in range %d - 100!", start));
        }

        return number;
    }
}
/*Write a method readNumber(int start, int end) that enters an integer number in a given range [start…end],
excluding the numbers start and end. If an invalid number or a non-number text is entered,
the method should throw an exception. Using this method, write a program that enters 10 numbers:
a1, a2, … a10, such that 1 < a1 < … < a10 < 100. If the user enters an invalid number,
continue while there are 10 valid numbers entered. Print the array elements, separated with comma and space ", ".
Hints
•	When the entered input holds a non-integer value, print "Invalid Number!".
•	When the entered input holds an integer that is out of range, print "Your number is not in range {currentNumber} - 100!".
*/