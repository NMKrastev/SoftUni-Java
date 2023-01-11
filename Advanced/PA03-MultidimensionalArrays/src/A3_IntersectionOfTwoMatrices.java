import java.util.Scanner;

public class A3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstArray = new char[rows][cols];
        initializeArray(scanner, firstArray);

        char[][] secondArray = new char[rows][cols];
        initializeArray(scanner, secondArray);

        char[][] outputArray = compareArrays(firstArray, secondArray);

        for (char[] row : outputArray) {
            for (char symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    private static char[][] compareArrays(char[][] firstArray, char[][] secondArray) {

        char[][] output = new char[firstArray.length][firstArray[0].length];
        for (int row = 0; row < firstArray.length; row++) {
            for (int col = 0; col < firstArray[row].length; col++) {
                if (firstArray[row][col] == secondArray[row][col]) {
                    output[row][col] = firstArray[row][col];
                } else {
                    output[row][col] = '*';
                }
            }
        }

        return output;
    }

    private static void initializeArray(Scanner scanner, char[][] array) {

        for (int row = 0; row < array.length; row++) {
            char[] current = scanner.nextLine().replaceAll(" ", "").toCharArray();
            array[row] = current;
        }
    }
}
