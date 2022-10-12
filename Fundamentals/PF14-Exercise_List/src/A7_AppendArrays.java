import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A7_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numsArrays = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        System.out.println(reverseArrays(numsArrays));
    }

    private static String reverseArrays(List<String> numsArrays) {

        Collections.reverse(numsArrays);
        String result = numsArrays.toString().replaceAll("[\\]\\[,]", "").trim();
        result = result.replaceAll("\\s+", " ");

        return result;
    }
}
/*Write a program to append several arrays of numbers.
	Arrays are separated by "|".
	Values are separated by spaces (" ", one or several).
	Order the arrays from the last to the first and their values from left to right.
*/