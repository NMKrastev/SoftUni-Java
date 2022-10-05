import java.util.Arrays;
import java.util.Scanner;

public class A3_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[num];
        int[] arrayTwo = new int[num];

        for (int i = 0; i < num; i++) {

            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

            if (i % 2 == 0) {
                arrayOne[i] = input[0];
                arrayTwo[i] = input[1];
            } else {
                arrayOne[i] = input[1];
                arrayTwo[i] = input[0];
            }

        }

        for (int printArrayOne :
                arrayOne) {

            System.out.print(printArrayOne + " ");
        }

        System.out.println();

        for (int printArrayTwo :
                arrayTwo) {

            System.out.print(printArrayTwo + " ");
        }
    }
}
/*Write a program that creates 2 arrays. You will be given an integer n.
On the next n lines, you get 2 integers. Form 2 arrays as shown below.*/