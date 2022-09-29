import java.util.Arrays;
import java.util.Scanner;

public class A9_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        boolean isEnd = false;

        while (!isEnd) {

            String input = scanner.nextLine();
            String[] splitArray = input.split(" ");
            int[] indexArray = new int[splitArray.length - 1];

            if (indexArray.length > 1) {

                for (int i = 0; i < indexArray.length; i++) {

                    indexArray[i] = Integer.parseInt(splitArray[i + 1]);

                }
            }

            if (splitArray[0].equals("swap")) {

                int temp = numArray[indexArray[0]];
                numArray[indexArray[0]] = numArray[indexArray[1]];
                numArray[indexArray[1]] = temp;

            }

            if (splitArray[0].equals("multiply")) {

                int index = indexArray[0];
                int temp = numArray[indexArray[0]];
                numArray[index] = numArray[index] * numArray[indexArray[1]];

            }

            if (splitArray[0].equals("decrease")) {

                for (int i = 0; i < numArray.length; i++) {

                    numArray[i] = numArray[i] - 1;

                }
            }

            if (splitArray[0].equals("end")) {

                isEnd = true;

            }
        }

        for (int i = 0; i < numArray.length; i++) {

            if (i == numArray.length - 1) {

                System.out.print(numArray[i]);

            } else {

                System.out.print(numArray[i] + ", ");

            }
        }
    }
}
/*You are given an array with integers. Write a program to modify the
elements after receiving the following commands:
· "swap {index1} {index2}" takes two elements and swap their places.
· "multiply {index1} {index2}" takes the element at the 1st index and multiplies
it with the element at 2nd index. Save the product at the 1st index.
· "decrease" decreases all elements in the array with 1.
Input:
On the first input line, you will be given the initial array values separated by a single space.
On the next lines, you will receive commands until you receive the command "end".
The commands are as follows:
· "swap {index1} {index2}"
· "multiply {index1} {index2}"
· "decrease" by 1 numbers in the array
Output:
The output should be printed on the console and consist of elements of the modified array –
separated by a comma and a single space ", ".
Constraints:
· Elements of the array will be integer numbers in the range [-231...231].
· The count of the array elements will be in the range [2...100].
· Indexes will always be in the range of the array.*/