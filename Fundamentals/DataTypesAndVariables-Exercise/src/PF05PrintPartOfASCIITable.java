import java.util.Scanner;

public class PF05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startASCCI = Integer.parseInt(scanner.nextLine());
        int endASCCI = Integer.parseInt(scanner.nextLine());

        for (int i = startASCCI; i <= endASCCI ; i++) {
            char currentSymbol = (char) i;
            System.out.printf("%c ", currentSymbol);
        }

    }
}
/*Find online more information about ASCII (American Standard Code for Information Interchange) and
write a program that prints part of the ASCII table of characters at the console.
On the first line of input, you will receive the char index you should start with, and on the
second line - the index of the last character you should print.
*/