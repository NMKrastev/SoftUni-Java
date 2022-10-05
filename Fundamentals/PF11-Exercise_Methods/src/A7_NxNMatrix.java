import java.util.Scanner;

public class A7_NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printNxNMatrix(number);

    }

    private static void printNxNMatrix(int number) {

        for (int i = 0; i < number; i++) {

            for (int j = 0; j < number; j++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
/*Write a method that receives a single integer n and prints an nxn matrix with that number.*/