import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble)
                .collect(Collectors.toList());

        sumAdjacentEqualNumbers(numbers);
        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);

    }

    static String joinElementsByDelimiter(List<Double> numbers, String delimiter) {

        String output = "";
        for (double num : numbers) {
            output += (new DecimalFormat("0.#").format(num) + delimiter);
        }
        return output;
    }

    public static List<Double> sumAdjacentEqualNumbers(List<Double> numbers) {

        for (int i = 0; i < numbers.size() - 1; i++) {

            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = -1;
            }
        }

        return numbers;
    }
}
/*Write a program to sum all adjacent equal numbers in a list of decimal numbers, starting from left to right.
	After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed as well.
	Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available).
*/