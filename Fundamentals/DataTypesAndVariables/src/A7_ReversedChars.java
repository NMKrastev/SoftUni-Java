import java.util.Scanner;

public class A7_ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();

            sb.append(input);
            sb.append(" ");

        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();

        System.out.println(sb);

        /*char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);
        System.out.printf("%c %c %c", thirdChar, secondChar, firstChar);*/

    }
}
/*Write a program that takes 3 lines of characters and
prints them in reversed order with a space between them.*/