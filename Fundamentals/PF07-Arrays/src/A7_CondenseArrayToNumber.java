import java.util.Arrays;
import java.util.Scanner;

public class A7_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        while (numbers.length != 1) {

            int[] condensed = new int[numbers.length - 1];

            for (int i = 0; i < numbers.length - 1; i++) {

                condensed[i] = numbers[i] + numbers[i + 1];

            }

            numbers = Arrays.copyOfRange(condensed, 0, condensed.length);
        }

        System.out.println(numbers[0]);
    }
}
/*Write a program to read an array of integers and condense them by summing
adjacent couples of elements until a single integer is obtained. For example,
if we have 3 elements {2, 10, 3}, we sum the first two and the second two elements
and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.*/