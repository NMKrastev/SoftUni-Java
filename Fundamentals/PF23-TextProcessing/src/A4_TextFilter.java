import java.util.Scanner;

public class A4_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsToRemove = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        for (int i = 0; i < wordsToRemove.length; i++) {
            int index = text.indexOf(wordsToRemove[i]);
            String asterisks = "";
            for (int j = 0; j < wordsToRemove[i].length(); j++) {
                asterisks += "*";
            }

            text = text.replace(wordsToRemove[i], asterisks);
            index = text.indexOf(wordsToRemove[i]);

        }

        System.out.println(text);
    }
}
/*Write a program that takes a text and a string of banned words. All words included in the ban list should be replaced
with asterisks "*", equal to the word's length. The entries in the ban list will be separated by a comma and space ", ".
The ban list should be entered on the first input line and the text on the second input line.
*/