import java.util.Arrays;
import java.util.Scanner;

public class A6_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {

            int sumLeft = 0;

            for (int j = 0; j < i; j++) {

                sumLeft += array[j];

            }

            int sumRight = 0;

            for (int k = array.length - 1; k > i; k--) {

                sumRight += array[k];

            }

            if (sumLeft == sumRight && !isFound) {

                System.out.println(i);
                isFound = true;

            }
        }

        if (!isFound) {

            System.out.println("no");
        }
    }
}
/*Write a program that determines if an element exists in the array
such that the sum of the elements on its left is equal to the sum of
the elements on its right. If there are no elements to the left/right,
their sum is considered to be 0. Print the index that satisfies the
required condition or "no" if there is no such index*/