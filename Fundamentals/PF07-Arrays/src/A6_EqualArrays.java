import java.util.Arrays;
import java.util.Scanner;

public class A6_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOne = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] arrayTwo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = 0;
        boolean areIdentical = true;

        for (int i = 0; i < arrayOne.length; i++) {

            sum += arrayOne[i];

            if (arrayOne[i] != arrayTwo[i]) {

                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areIdentical = false;
                break;
            }
        }

        if (areIdentical) {

            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
/*Read two arrays and print on the console whether they are identical or not.
Arrays are identical if their elements are equal. If the arrays are identical,
find the sum of the first one and print on the console the following message:
"Arrays are identical. Sum: {sum}", otherwise find the first index where the
arrays differ and print on the console following message: "Arrays are not identical.
Found difference at {index} index."*/