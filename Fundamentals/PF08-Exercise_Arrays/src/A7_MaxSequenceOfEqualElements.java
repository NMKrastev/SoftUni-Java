import java.util.Arrays;
import java.util.Scanner;

public class A7_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int count = 1,  currentCount = 1, number = 0;

        for (int i = 0; i < numArray.length - 1; i++) {

            if (numArray[i] == numArray[i + 1]) {

                currentCount++;

                if (currentCount > count) {

                    count = currentCount;
                    number = numArray[i];

                }

            } else {

                currentCount = 1;

            }
        }

        for (int i = 0; i < count; i++) {

            System.out.print(number + " ");

        }
    }
}
/*Write a program that finds the longest sequence of equal elements in an array of integers.
If several longest sequences exist, print the leftmost one.*/