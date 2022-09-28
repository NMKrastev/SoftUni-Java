import java.util.Arrays;
import java.util.Scanner;

public class A4_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {

            int temp = array[0];

            for (int j = 0; j < array.length - 1; j++) {

                array[j] = array[j + 1];

            }

            array[array.length - 1] = temp;
        }

        for (int numers :
                array) {

            System.out.print(numers + " ");
        }
    }
}
/*Write a program that receives an array and the number of rotations
you have to perform (the first element goes at the end). Print the resulting array.*/