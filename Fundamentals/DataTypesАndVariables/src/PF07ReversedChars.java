import java.util.Collection;
import java.util.Scanner;

public class PF07ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            String currentChar = scanner.nextLine();
            sb.append(currentChar);
            sb.append(" ");

        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();

        System.out.println(sb);

    }
}
/*Write a program that takes 3 lines of characters and prints them in
reversed order with a space between them.*/