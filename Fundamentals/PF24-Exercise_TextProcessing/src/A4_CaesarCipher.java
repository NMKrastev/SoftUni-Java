import java.util.Scanner;

public class A4_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String result = getEncryption(text);
        System.out.println(result);
    }

    private static String getEncryption(String text) {

        String result = "";
        char symbol;

        for (int i = 0; i < text.length(); i++) {
            symbol = text.charAt(i);
            symbol += 3;

            result += symbol;
        }
        return result;
    }
}
/*Write a program that returns an encrypted version of the same text. Encrypt the text by shifting each character with
three positions forward. For example, A would be replaced by D, B would become E, and so on. Print the encrypted text.*/