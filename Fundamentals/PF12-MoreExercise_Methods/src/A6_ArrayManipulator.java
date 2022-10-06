import java.util.Arrays;
import java.util.Scanner;

public class A6_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {

            switch (command[0]) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    if (isIndexValid(index, numsArray.length)) {
                        makeExchange(numsArray, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (command[1].equals("odd")) {
                        getMaxOdd(numsArray);
                    } else {
                        getMaxEven(numsArray);
                    }
                    break;
                case "min":
                    if (command[1].equals("odd")) {
                        getMinOdd(numsArray);
                    } else {
                        getMinEven(numsArray);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(command[1]);
                    if (count > numsArray.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (command[2].equals("odd")) {
                            getFirstOdds(numsArray, count);
                        } else {
                            getFirstEvens(numsArray, count);
                        }
                    }
                    break;
                case "last":
                    count = Integer.parseInt(command[1]);
                    if (count > numsArray.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (command[2].equals("odd")) {
                            getLastOdds(numsArray, count);
                        } else {
                            getLastEvens(numsArray, count);
                        }
                    }
                    break;
            }

            command = scanner.nextLine().split(" ");
        }

        System.out.println(Arrays.toString(numsArray));
    }

    private static boolean isIndexValid(int index, int length) {
        return index >= 0 && index < length;
    }

    public static void getLastEvens(int[] numsArray, int countFirstEvens) {

        int[] lastEven = new int[numsArray.length];
        for (int i = numsArray.length - 1; i >= 0; i--) {
            if (numsArray[i] % 2 == 0 && countFirstEvens > 0) {
                lastEven[i] = numsArray[i];
                countFirstEvens--;
            } else {
                lastEven[i] = -1;
            }
        }

        printArray(lastEven);
    }

    public static void getLastOdds(int[] numsArray, int countLastOdds) {

        int[] lastOdds = new int[numsArray.length];
        for (int i = numsArray.length - 1; i >= 0; i--) {
            if (numsArray[i] % 2 != 0 && countLastOdds > 0) {
                lastOdds[i] = numsArray[i];
                countLastOdds--;
            } else {
                lastOdds[i] = -1;
            }
        }

        printArray(lastOdds);
    }

    public static void getFirstEvens(int[] numsArray, int countFirstEvens) {

        int[] firstEvens = new int[numsArray.length];
        for (int i = 0; i < numsArray.length; i++) {
            if (numsArray[i] % 2 == 0 && countFirstEvens > 0) {
                firstEvens[i] = numsArray[i];
                countFirstEvens--;
            } else {
                firstEvens[i] = -1;
            }
        }

        printArray(firstEvens);
    }

    public static void getFirstOdds(int[] numsArray, int countFirstOdds) {

        int[] firstOdds = new int[numsArray.length];
        for (int i = 0; i < numsArray.length; i++) {
            if (numsArray[i] % 2 != 0 && countFirstOdds > 0) {
                firstOdds[i] = numsArray[i];
                countFirstOdds--;
            } else {
                firstOdds[i] = -1;
            }
        }

        printArray(firstOdds);
    }

    public static void getMinEven(int[] numsArray) {

        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = -1;
        for (int i = 0; i < numsArray.length; i++) {

            if (numsArray[i] % 2 == 0 && minEven >= numsArray[i]) {
                minEven = numsArray[i];
                minEvenIndex = i;
            }
        }
        if (minEvenIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenIndex);
        }
    }

    public static void getMinOdd(int[] numsArray) {

        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = -1;
        for (int i = 0; i < numsArray.length; i++) {

            if (numsArray[i] % 2 != 0 && minOdd >= numsArray[i]) {
                minOdd = numsArray[i];
                minOddIndex = i;
            }
        }
        if (minOddIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minOddIndex);
        }
    }

    public static void getMaxEven(int[] numsArray) {

        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        for (int i = 0; i < numsArray.length; i++) {

            if (numsArray[i] % 2 == 0 && maxEven <= numsArray[i]) {
                maxEven = numsArray[i];
                maxEvenIndex = i;
            }
        }
        if (maxEvenIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenIndex);
        }
    }

    public static void getMaxOdd(int[] numsArray) {

        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = -1;
        for (int i = 0; i < numsArray.length; i++) {

            if (numsArray[i] % 2 != 0 && maxOdd <= numsArray[i]) {
                maxOdd = numsArray[i];
                maxOddIndex = i;
            }
        }
        if (maxOddIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxOddIndex);
        }
    }

    public static void makeExchange(int[] numsArray, int index) {

        int[] tempArrayOne = Arrays.copyOfRange(numsArray, 0, index + 1);
        int[] tempArrayTwo = Arrays.copyOfRange(numsArray, index + 1, numsArray.length);
        System.arraycopy(tempArrayTwo, 0, numsArray, 0, tempArrayTwo.length);
        System.arraycopy(tempArrayOne, 0, numsArray, tempArrayTwo.length, tempArrayOne.length);

    }

    public static void printArray(int[] numsArray) {

        boolean printFirst = true;
        System.out.print("[");
        for (int i = 0; i < numsArray.length; i++) {
            if (numsArray[i] != -1) {
                if (printFirst) {
                    System.out.print(numsArray[i]);
                    printFirst = false;
                } else {
                    System.out.print(", " + numsArray[i]);
                }
            }
        }
        System.out.println("]");
    }
}
/*Trifon has finally become a junior developer and has received his first task. It's about manipulating an array of integers.
He is not quite happy about it, since he hates manipulating arrays. They will pay him a lot of money, though, and he is
willing to give somebody half of it if to help him do his job. You, on the other hand, love arrays (and money) so you
decide to try your luck.
The array may be manipulated by one of the following commands:
•	exchange {index} – splits the array after the given index and exchanges the places of the two resulting subarrays.
E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
o	If the index is outside the boundaries of the array, print "Invalid index".
•	max even/odd – returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
•	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
o	If there are two or more equal min/max elements, return the index of the rightmost one.
o	If a min/max even/odd element cannot be found, print "No matches".
•	first {count} even/odd – returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
•	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
o	If the count is greater than the array length, print "Invalid count".
o	If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements,
print an empty array "[]".
•	end – stop taking input and print the final state of the array.
Input
•	The input data should be read from the console.
•	On the first line, the initial array is received as a line of integers, separated by a single space.
•	On the next lines, until the command "end" is received, you will receive the array manipulation commands.
•	The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
•	The output should be printed on the console.
•	On a separate line, print the output of the corresponding command.
•	On the last line, print the final array in square brackets with its elements separated by a comma and a space.
•	See the examples below to get a better understanding of your task.
*/