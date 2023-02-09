import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A5_MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(array, array.length);
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void mergeSort(int[] array, int length) {
        if (length == 1) {
            return;
        }

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < length; i++) {
            rightArray[i - middle] = array[i];
        }

        mergeSort(leftArray, middle);
        mergeSort(rightArray, length - middle);

        merge(array, leftArray, rightArray, middle, length - middle);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray, int leftLength, int rightLength) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftLength) {
            array[k++] = leftArray[i++];
        }
        while (j < rightLength) {
            array[k++] = rightArray[j++];
        }
    }
}
/*Sort an array of elements using the famous merge sort.*/
