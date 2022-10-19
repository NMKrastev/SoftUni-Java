import java.util.*;
import java.util.stream.Collectors;

public class A3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        double averageNum = findAverageNum(numsList);
        List<Integer> biggerNumsList = findBiggerNumsThanAverage(numsList, averageNum);
        biggerNumsList = sortInDescendingOrder(biggerNumsList);
        printBiggerNumsList(biggerNumsList);

    }

    private static void printBiggerNumsList(List<Integer> biggerNumsList) {

        if (biggerNumsList.size() == 0) {
            System.out.println("No");
        } else {
            for (int i = 0; i < biggerNumsList.size(); i++) {

                System.out.print(biggerNumsList.get(i) + " ");
                if (i == 4) {
                    break;
                }
            }
        }
    }

    private static List<Integer> sortInDescendingOrder(List<Integer> biggerNumsList) {

        biggerNumsList.sort(Collections.reverseOrder());
        return biggerNumsList;
    }

    private static List<Integer> findBiggerNumsThanAverage(List<Integer> numsList, double averageNum) {

        List<Integer> biggerNumsList = new ArrayList<>();
        for (int i = 0; i < numsList.size(); i++) {
            if (averageNum < numsList.get(i)) {
                biggerNumsList.add(numsList.get(i));
            }
        }
        return biggerNumsList;
    }

    private static double findAverageNum(List<Integer> numsList) {

        int sum = 0;
        for (int i = 0; i < numsList.size(); i++) {
            sum += numsList.get(i);
        }

        return sum * 1.0 / numsList.size();
    }
}
/*Write a program to read a sequence of integers and find and print the top 5 numbers greater
than the average value in the sequence, sorted in descending order.
Input
•	Read from the console a single line holding space-separated integers.
Output
•	Print the above-described numbers on a single line, space-separated.
•	If less than 5 numbers hold the property mentioned above, print less than 5 numbers.
•	Print "No" if no numbers hold the above property.
Constraints
•	All input numbers are integers in the range [-1 000 000 … 1 000 000].
•	The count of numbers is in the range [1…10 000].
*/