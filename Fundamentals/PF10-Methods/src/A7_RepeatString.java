import java.util.Scanner;

public class A7_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        //String result = printDuplicatedString(input, count);

        System.out.println(printDuplicatedString(input, count));
    }

    private static String printDuplicatedString(String input, int count) {

        String result = "";

        for (int i = 0; i < count; i++) {
            result += input;
        }

        return result;
    }
}
/*Write a method that receives a string and a repeat count n (integer).
The method should return a new string (the old one repeated n times).*/