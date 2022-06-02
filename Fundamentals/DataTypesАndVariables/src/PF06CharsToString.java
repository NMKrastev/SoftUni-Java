import java.util.Scanner;

public class PF06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = "";
        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();

            result += input;
        }
        System.out.println(result);
    }
}
/*Write a program that reads 3 lines of input. On each line, you get a single character. Combine all the
characters into one string and print it on the console.*/