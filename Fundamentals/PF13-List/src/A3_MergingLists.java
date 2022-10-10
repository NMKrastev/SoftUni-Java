import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = mergingLists(listOne, listTwo);
        printList(result);
    }

    private static void printList(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static List mergingLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> result = new ArrayList<>();
        int size = 0;
        int i = 0;
        if (listOne.size() >= listTwo.size()) {
            size = listOne.size();
            while (size > 0) {
                if (i > listTwo.size() - 1) {
                    result.add(listOne.get(i));
                } else {
                    result.add(listOne.get(i));
                    result.add(listTwo.get(i));
                }
                i++;
                size--;
            }
        } else {
            size = listTwo.size();
            while (size > 0) {
                if (i > listOne.size() - 1) {
                    result.add(listTwo.get(i));
                } else {
                    result.add(listOne.get(i));
                    result.add(listTwo.get(i));
                }
                i++;
                size--;
            }
        }
        return result;
    }
}
/*You are going to receive two lists with numbers. Create a result list that contains the numbers from both of the lists.
The first element should be from the first list, the second from the second list, and so on. If the length of the two
lists is not equal, just add the remaining elements at the end of the list.*/