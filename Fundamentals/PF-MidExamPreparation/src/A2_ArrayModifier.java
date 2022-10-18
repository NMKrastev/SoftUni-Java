import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        numsList = distribution(scanner, numsList);
        printNums(numsList);
    }

    private static void printNums(List<Integer> numsList) {
        String result = numsList.toString().replaceAll("[\\[\\]]", "");
        System.out.println(String.join(", ", result));
    }

    private static List<Integer> distribution(Scanner scanner, List<Integer> numsList) {
        String input = "";

        while (!(input = scanner.nextLine()).equals("end")) {

            if (input.contains("swap")) {
                int indexOne = Integer.parseInt(input.split(" ")[1]);
                int indexTwo = Integer.parseInt(input.split(" ")[2]);
                numsList = swapElements(numsList, indexOne, indexTwo);
            }
            if (input.contains("multiply")) {
                int indexOne = Integer.parseInt(input.split(" ")[1]);
                int indexTwo = Integer.parseInt(input.split(" ")[2]);
                numsList = multiplyElements(numsList, indexOne, indexTwo);
            }
            if (input.contains("decrease")) {
                numsList = decreaseAllElementsByOne(numsList);
            }
        }
        return numsList;
    }

    private static List<Integer> swapElements(List<Integer> numsList, int indexOne, int indexTwo) {

        int temp = numsList.get(indexOne);
        numsList.set(indexOne, numsList.get(indexTwo));
        numsList.set(indexTwo, temp);
        return numsList;
    }

    private static List<Integer> multiplyElements(List<Integer> numsList, int indexOne, int indexTwo) {

        numsList.set(indexOne, numsList.get(indexOne) * numsList.get(indexTwo));
        return numsList;
    }

    private static List<Integer> decreaseAllElementsByOne(List<Integer> numsList) {

        for (int i = 0; i < numsList.size(); i++) {
            numsList.set(i, numsList.get(i) - 1);
        }
        return numsList;
    }
}
/*You are given an array with integers. Write a program to modify the elements after receiving the following commands:
•	"swap {index1} {index2}" takes two elements and swap their places.
•	"multiply {index1} {index2}" takes the element at the 1st index and multiplies it with the element at 2nd index.
Save the product at the 1st index.
•	"decrease" decreases all elements in the array with 1.
Input
On the first input line, you will be given the initial array values separated by a single space.
On the next lines, you will receive commands until you receive the command "end". The commands are as follows:
•	"swap {index1} {index2}"
•	"multiply {index1} {index2}"
•	"decrease"
Output
The output should be printed on the console and consist of elements of the modified array – separated by a comma and a
single space ", ".
Constraints
•	Elements of the array will be integer numbers in the range [-231...231].
•	Count of the array elements will be in the range [2...100].
•	Indexes will be always in the range of the array.
*/