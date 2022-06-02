import java.util.Scanner;

public class PF06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);
        System.out.printf("%c%c%c", firstChar, secondChar, thirdChar);
    }
}
/*Write a program that reads 3 lines of input. On each line, you get a single character. Combine all the
characters into one string and print it on the console.*/