import java.util.Scanner;

public class A1_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        System.out.println(printSmallestNumber(one, two, three));

    }

    private static int printSmallestNumber(int one, int two, int three) {

        if (one < two && one < three) {
            return one;
        } else if (two < one && two < three) {
            return two;
        }
        return three;
    }
}
/*Write a method to print the smallest of three integer numbers.
Use an appropriate name for the method.*/