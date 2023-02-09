import java.util.Arrays;
import java.util.Scanner;

public class A7_BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int element = Integer.parseInt(scanner.nextLine());

        int index = getIndex(array, element);

        System.out.println(index);
    }

    private static int getIndex(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element < array[mid]) {
                end = mid - 1;
            } else if (element > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
/*Implement an algorithm that finds the index of an element in a sorted array of integers in logarithmic time*/
