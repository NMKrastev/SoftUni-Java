import java.util.Scanner;

public class A2_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = scanner.nextInt();
            }
        }

        int searchNum = scanner.nextInt();
        boolean isFound = false;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == searchNum) {
                    System.out.printf("%d %d\n", row, col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
