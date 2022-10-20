import java.util.Scanner;

public class A1_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        encryptedMessage = distribution(scanner, encryptedMessage);
        printDecodedMessage(encryptedMessage);

    }

    private static void printDecodedMessage(String encryptedMessage) {
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }

    private static String distribution(Scanner scanner, String encryptedMessage) {
        String command = "";

        while (!(command = scanner.nextLine()).equals("Decode")) {

            if (command.contains("Move")) {
                int numOfPosition = Integer.parseInt(command.split("\\|")[1]);
                encryptedMessage = moveElements(encryptedMessage, numOfPosition);
            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(command.split("\\|")[1]);
                String value = command.split("\\|")[2];
                encryptedMessage = insertValueBeforeIndex(encryptedMessage, index, value);
            } else if (command.contains("ChangeAll")) {
                String substring = command.split("\\|")[1];
                String replacement = command.split("\\|")[2];
                encryptedMessage = changeAllOccurrencesOfSubstring(encryptedMessage, substring, replacement);
            }
        }
        return encryptedMessage;
    }

    private static String moveElements(String encryptedMessage, int numOfPosition) {

        String elementsToMove = encryptedMessage.substring(0, numOfPosition);
        String remainingElements = encryptedMessage.substring(numOfPosition);

        return remainingElements.concat(elementsToMove);
    }

    private static String insertValueBeforeIndex(String encryptedMessage, int index, String value) {

        String leftElements = encryptedMessage.substring(0, index);
        String rightElements = encryptedMessage.substring(index);
        return leftElements.concat(value).concat(rightElements);
    }

    private static String changeAllOccurrencesOfSubstring(String encryptedMessage, String substring, String replacement) {

        return encryptedMessage.replace(substring, replacement);
    }
}
/*On the first line of the input, you will receive the encrypted message. After that, until the "Decode" command is
given, you will be receiving strings with instructions for different operations that need to be performed upon the
concealed message to interpret it and reveal its true content. There are several types of instructions, split by '|'
•	"Move {number of letters}":
o	Moves the first n letters to the back of the string
•	"Insert {index} {value}":
o	Inserts the given value before the given index in the string
•	"ChangeAll {substring} {replacement}":
o	Changes all occurrences of the given substring with the replacement text
Input / Constraints
•	On the first line, you will receive a string with a message.
•	On the following lines, you will be receiving commands, split by '|' .
Output
•	After the "Decode" command is received, print this message:
"The decrypted message is: {message}"
*/