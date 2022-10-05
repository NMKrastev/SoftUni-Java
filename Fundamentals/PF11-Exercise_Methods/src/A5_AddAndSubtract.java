import java.util.Scanner;

public class A5_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        sumFirstTwoInts(one, two, three);

    }

    private static void sumFirstTwoInts(int one, int two, int three) {

        int result = one + two;

        subtractSumAndIntThree(result, three);
    }

    private static void subtractSumAndIntThree(int result, int three) {
        System.out.println(result - three);
    }
}
/*You will receive 3 integers. Write a method sum to get the sum of the first two integers and subtract
the method that subtracts the third integer from the result from the sum method.*/