import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class A1_NumberInRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("Range: [%d...%d]\n", range[0], range[1]);

        boolean isValidInput = false;

        while (!isValidInput) {

            String nextInput = scanner.nextLine();

            Optional<Integer> number = Optional.empty();

            try {
                number = Optional.of(Integer.parseInt(nextInput));
            } catch (NumberFormatException ignored) {
            }

            String output = String.format("Invalid number: %s", nextInput);

            if (number.isPresent() && isInRange(range, number.get())) {
                output = String.format("Valid number: %d\n", number.get());
                isValidInput = true;
            }

            System.out.println(output);

        }
    }

    private static boolean isInRange(int[] range, int number) {
        return range[0] <= number && number <= range[1];
    }
}
/*Write a program to enter an integer in a certain range. Until the number is not valid,
enter a new number from the console. When the number is valid - end the program.
Input
	Read a range - two numbers, separated by a space.
	On the next line, read the String.
Output
	Print the range in the following format: "Range: [{startIndex}...{endIndex}]".
	When an invalid number is entered, String or the number is out of range, print "Invalid number: {num}".
	When the entered number is valid, print "Valid number: {num}".
*/
