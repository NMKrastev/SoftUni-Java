import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A6_QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }

        int swap = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swap;

        return i + 1;
    }
}
/*Sort an array of elements using the famous quicksort*/
