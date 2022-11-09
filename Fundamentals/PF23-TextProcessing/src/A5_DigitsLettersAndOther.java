import java.util.Scanner;

public class A5_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        for (int i = 0; i < text.length; i++) {

            if (Character.isDigit(text[i])) {
                digits.append(text[i]);
            } else if (Character.isLetter(text[i])) {
                letters.append(text[i]);
            } else {
                others.append(text[i]);
            }
        }
        System.out.printf("%s\n%s\n%s\n", digits.toString(), letters.toString(), others.toString());
    }
}
/*Write a program that receives a single string and on the first line prints all the digits, on the second –
all the letters, and on the third – all the other characters.
There will always be at least one digit, one letter, and one other character.*/