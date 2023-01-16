import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> valueOccurrences = new LinkedHashMap<>();

        for (double value : values) {
            if (!valueOccurrences.containsKey(value)) {
                valueOccurrences.put(value, 1);
            } else {
                valueOccurrences.put(value, valueOccurrences.get(value) + 1);
            }
        }

        valueOccurrences.forEach((key, value) -> System.out.printf("%.1f -> %d\n", key, value));
    }
}
/*Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated
by a space. Print the numbers in the order of appearance. All numbers must be formatted to one digit after the decimal point.*/
