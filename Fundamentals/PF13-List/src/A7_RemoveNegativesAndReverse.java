import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A7_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numsList = removeAllNegatives(numsList);
        printList(numsList);

    }

    private static void printList(List<Integer> numsList) {
        if (numsList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numsList.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static List<Integer> removeAllNegatives(List<Integer> numsList) {

        numsList.removeIf(n -> n < 0);
        reverseList(numsList);
        return numsList;
    }

    private static List<Integer> reverseList(List<Integer> numsList) {

        Collections.reverse(numsList);
        return numsList;
    }
}
/*Read a list of integers, remove all negative numbers from it and print the remaining elements in reversed order.
In case of no elements left in the list, print "empty".*/