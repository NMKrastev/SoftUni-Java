import java.util.Scanner;

public class A1_SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printSignOfInt(num);

    }

    public static void printSignOfInt(int num) {

        if (num > 0) {
            System.out.printf("The number %d is positive.", num);
        } else if (num < 0) {
            System.out.printf("The number %d is negative.", num);
        } else {
            System.out.println("The number 0 is zero.");
        }
    }
}
/*Create a method that prints the sign of an integer number.*/