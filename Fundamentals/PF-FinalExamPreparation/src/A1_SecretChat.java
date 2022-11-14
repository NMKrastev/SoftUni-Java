import java.util.Scanner;

public class A1_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder message = new StringBuilder(input);
        String command;

        while (!(command = scanner.nextLine()).equals("Reveal")) {

            if (command.contains("Insert")) {
                int index = Integer.parseInt(command.split(":\\|:")[1]);
                message.insert(index, " ");
                System.out.println(message);
            } else if (command.contains("Reverse")) {
                String substring = command.split(":\\|:")[1];
                if (message.toString().contains(substring)) {
                    reverseSubstring(message, substring);
                    System.out.println(message);
                } else {
                    System.out.println("error");
                }
            } else if (command.contains("ChangeAll")) {
                String substring = command.split(":\\|:")[1];
                String replacement = command.split(":\\|:")[2];
                changeAll(message, substring, replacement);
                System.out.println(message);
            }
        }
        System.out.printf("You have a new text message: %s\n", message);
    }

    private static StringBuilder reverseSubstring(StringBuilder message, String substring) {

        message.delete(message.indexOf(substring), message.indexOf(substring) + substring.length());
        String[] subArray = substring.split("");
        StringBuilder reversedSubstring = new StringBuilder();
        for (int i = substring.length() - 1; i >= 0 ; i--) {
            reversedSubstring.append(subArray[i]);
        }
        message.append(reversedSubstring);
        return message;
    }

    private static StringBuilder changeAll(StringBuilder message, String substring, String replacement) {

        int index = message.indexOf(substring);
        while (index != -1) {
            message.replace(index, index + substring.length(), replacement);
            index = message.indexOf(substring);
        }
        return message;
    }
}
/*On the first line of the input, you will receive the concealed message. After that, until the "Reveal" command is
given, you will receive strings with instructions for different operations that need to be performed upon the concealed
message to interpret it and reveal its actual content. There are several types of instructions, split by ":|:"
•	"InsertSpace:|:{index}":
o	Inserts a single space at the given index. The given index will always be valid.
•	"Reverse:|:{substring}":
o	If the message contains the given substring, cut it out, reverse it and add it at the end of the message.
o	If not, print "error".
o	This operation should replace only the first occurrence of the given substring if there are two or more occurrences.
•	"ChangeAll:|:{substring}:|:{replacement}":
o	Changes all occurrences of the given substring with the replacement text.
Input / Constraints
•	On the first line, you will receive a string with a message.
•	On the following lines, you will be receiving commands, split by ":|:".
Output
•	After each set of instructions, print the resulting string.
•	After the "Reveal" command is received, print this message:
"You have a new text message: {message}"
*/