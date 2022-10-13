import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A4_MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsListOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numsListTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> middleElements = getMiddleElements(numsListOne, numsListTwo);
        List<Integer> inBetweenMiddleElements = getInBetweenElements(numsListOne, numsListTwo);

        printInBetweenMiddleElements(inBetweenMiddleElements, middleElements);
    }

    private static void printInBetweenMiddleElements(List<Integer> inBetweenMiddleElements, List<Integer> middleElements) {

        int middleHigh = Math.max(middleElements.get(0), middleElements.get(1));
        int middleMin = Math.min(middleElements.get(0), middleElements.get(1));
        for (int num : inBetweenMiddleElements) {
            if (num > middleMin && num < middleHigh) {
                System.out.print(num + " ");
            }
        }
    }

    private static List<Integer> getInBetweenElements(List<Integer> numsListOne, List<Integer> numsListTwo) {

        List<Integer> inBetweenMiddleElements = new ArrayList<>();
        List<Integer> merge = Stream.of(numsListOne, numsListTwo).flatMap(Collection::stream)
                .collect(Collectors.toList());

        for (int i = 0; i < merge.size(); i++) {

            if (i < merge.size() / 2 - 1) {
                inBetweenMiddleElements.add(merge.get(i));
                inBetweenMiddleElements.add(merge.get(merge.size() - 1 - i));
            } else {
                break;
            }
        }

        Collections.sort(inBetweenMiddleElements);
        return inBetweenMiddleElements;
    }

    private static List<Integer> getMiddleElements(List<Integer> numsListOne, List<Integer> numsListTwo) {

        List<Integer> merge = Stream.of(numsListOne, numsListTwo).flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<Integer> middleElements = new ArrayList<>();
        middleElements.add(merge.get(merge.size() / 2 - 1));
        middleElements.add(merge.get(merge.size() / 2));

        return middleElements;
    }
}
/*Write a program that mixes up two lists by some rules. You will receive two lines of input,
each one being a list of numbers. The mixing rules are:
•	Start from the beginning of the first list and the ending of the second.
•	Add element from the first and element from the second.
•	In the end, there will always be a list in which there are 2 elements remaining.
•	These elements will be the range of the elements you need to print.
•	Loop through the result list and take only the elements that fulfill the condition.
•	Print the elements ordered in ascending order and separated by a space.
*/