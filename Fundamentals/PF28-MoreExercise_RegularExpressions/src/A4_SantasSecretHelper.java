import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A4_SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)([^-@!:>]+)?!G!");

        int key = Integer.parseInt(scanner.nextLine());
        String input;

        while (!(input = scanner.nextLine()).equals("end")) {

            String decryptedMessage = String.valueOf(decryptMessage(input, key));
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                System.out.println(matcher.group("name"));
            }
        }
    }

    private static StringBuilder decryptMessage(String input, int key) {

        StringBuilder decryptedMessage = new StringBuilder(input);
        for (int i = 0; i < decryptedMessage.length(); i++) {
            char currentSymbol = decryptedMessage.charAt(i);
            currentSymbol -= key;
            decryptedMessage.setCharAt(i, currentSymbol);
        }

        return decryptedMessage;
    }
}
/*After the successful second Christmas, Santa needs to gather information about children's behavior to plan the
presents for next Christmas. He has a secret helper who is sending him encrypted information. Your task is to decrypt
it and create a list of the good children.
You will receive an integer, which represents a key, and afterward some messages, which you must decode by subtracting
the key from the value of each character. After the decryption, to be considered a valid match, a message should:
•	Have a name that starts after '@' and contains only letters from the Latin alphabet
•	Have a behavior type - "G"(good) or "N"(naughty) and must be surrounded by "!" (exclamation mark).
The order in the message should be the child’s name -> child’s behavior. They can be separated from the others by any
character except: '@', '-', '!', ':' and '>'.
You will be receiving messages until you are given the "end" command. Afterward, print the names of the children who
will receive a present on a new line.
Input / Constraints
•	The first line holds n – the number you must subtract from the characters – integer in the range [1…100].
•	On the next lines, you will be receiving encrypted messages.
Output
Print the names of the children, each on a new line
*/