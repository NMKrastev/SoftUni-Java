import java.util.Scanner;

public class A3_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            printLine(1, i);
        }

        printLine(1, num);

        for (int i = num - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    private static void printLine(int start, int end) {

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
/*Create a method for printing triangles as shown below:
Input: 3
1
1 2
1 2 3
1 2
1*/