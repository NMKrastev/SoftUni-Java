import java.util.Arrays;
import java.util.Scanner;

public class A5_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < array.length; i++) {

            boolean isBigger = true;

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] <= array[j]) {

                    isBigger = false;

                }

            }

            if (isBigger) {

                System.out.print(array[i] + " ");

            }
        }
    }
}
/*Write a program to find all the top integers in an array.
A top integer is an integer that is bigger than all the elements to its right.*/