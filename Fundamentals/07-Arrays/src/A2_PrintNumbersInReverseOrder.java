import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A2_PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[num];

        for (int i = num - 1; i >= 0; i--) {

            numbers[i] = Integer.parseInt(scanner.nextLine());

        }

        for (int i = 0; i < num; i++) {

            System.out.print(numbers[i] + " ");

        }
    }
}
/*Read n numbers and print them in reverse order.*/