import java.util.Scanner;

public class A10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        //int result = getMultipleOfEvensAndOdds(number);
        System.out.println(getMultipleOfEvensAndOdds(number));

    }

    private static int getMultipleOfEvensAndOdds(int number) {

        String temp = Integer.toString(Math.abs(number));
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
        int evenSum = 0;
        int oddSum = 0;

        for (int j : numbers) {

            if (j % 2 == 0) {
                evenSum += j;
            } else {
                oddSum += j;
            }
        }

        return evenSum * oddSum;
    }
}
/*Create a program that reads an integer number and multiplies the
sum of all its even digits by the sum of all its odd digits*/