import java.util.Scanner;

public class A5_MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());

        getPositiveNegative(numOne, numTwo, numThree);

    }

    private static void getPositiveNegative(int numOne, int numTwo, int numThree) {

        if (numOne == 0 || numTwo == 0 || numThree == 0) {
            System.out.println("zero");
        } else if (numOne > 0 && numTwo > 0 && numThree > 0) {
            System.out.println("positive");
        } else if (numOne < 0 && numTwo < 0 && numThree > 0
                || numTwo < 0 && numThree < 0 && numOne > 0
                || numOne < 0 && numThree < 0 && numTwo > 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
}
/*You are given a number num1, num2, and num3. Write a program that finds if num1 * num2 * num3 (the product)
is negative, positive, or zero. Try to do this WITHOUT multiplying the 3 numbers.*/