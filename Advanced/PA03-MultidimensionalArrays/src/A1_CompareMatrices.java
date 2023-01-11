import java.util.Arrays;
import java.util.Scanner;

public class A1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayRows = scanner.nextInt();
        int arrayCols = scanner.nextInt();
        int[][] firstArray = new int[arrayRows][arrayCols];
        firstArray = initializeArray(scanner, arrayRows, firstArray);

        arrayRows = scanner.nextInt();
        arrayCols = scanner.nextInt();
        int[][] secondArray = new int[arrayRows][arrayCols];
        secondArray = initializeArray(scanner, arrayRows, secondArray);

        boolean isEqual = compareArrays(firstArray, secondArray);

        System.out.println(isEqual ? "equal" : "not equal");

    }

    private static boolean compareArrays(int[][] firstArray, int[][] secondArray) {

        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int row = 0; row < firstArray.length; row++) {
            if (firstArray[row].length != secondArray[row].length) {
                return false;
            }
            for (int col = 0; col < firstArray[row].length; col++) {
               if (firstArray[row][col] != secondArray[row][col]) {
                   return false;
               }
            }
        }

        return true;
    }

    private static int[][] initializeArray(Scanner scanner, int arrayRows, int[][] array) {

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = scanner.nextInt();
            }
            //If there is a String input you can use the code below
            /*int[] current = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            array[row] = current;*/
        }
        return array;
    }
}
/*Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element.
For better code re-usability, you could make the comparison in a method that returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in
the matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces
(each line will have an equal amount of numbers).
The matrices will have at most 10 rows and at most 10 columns.
Print "equal" if the matrices match and "not equal" if they don't match.
*/