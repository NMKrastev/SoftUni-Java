import java.util.Scanner;

public class A1_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder rawActivationKey = new StringBuilder(scanner.nextLine());

        String input;

        while (!(input = scanner.nextLine()).equals("Generate")) {

            if (input.contains("Contains")) {
                checkForSubstring(rawActivationKey, input);
            } else if (input.contains("Flip")) {
                substringToLowerOrUpperCase(rawActivationKey, input);
                System.out.println(rawActivationKey);
            } else if (input.contains("Slice")){
                deleteSubstring(rawActivationKey, input);
                System.out.println(rawActivationKey);
            }
        }

        System.out.printf("Your activation key is: %s", rawActivationKey);
    }

    private static StringBuilder deleteSubstring(StringBuilder rawActivationKey, String input) {

        int startIndex = Integer.parseInt(input.split(">>>\\s*".trim())[1]);
        int endIndex = Integer.parseInt(input.split(">>>\\s*".trim())[2]);
        //String substringToDelete = rawActivationKey.substring(startIndex, endIndex);
        rawActivationKey.delete(startIndex, endIndex);

        return rawActivationKey;
    }

    private static StringBuilder substringToLowerOrUpperCase(StringBuilder rawActivationKey, String input) {

        if (input.contains("Upper")) {
            int startIndex = Integer.parseInt(input.split(">>>\\s*".trim())[2]);
            int endIndex = Integer.parseInt(input.split(">>>\\s*".trim())[3]);
            //String substring = rawActivationKey.substring(startIndex, endIndex);
            String substringToUpperCase = rawActivationKey.substring(startIndex, endIndex).toUpperCase();
            rawActivationKey.replace(startIndex, endIndex, substringToUpperCase);
        } else if (input.contains("Lower")) {
            int startIndex = Integer.parseInt(input.split(">>>\\s*".trim())[2]);
            int endIndex = Integer.parseInt(input.split(">>>\\s*".trim())[3]);
            //String substring = rawActivationKey.substring(startIndex, endIndex);
            String substringToLowerCase = rawActivationKey.substring(startIndex, endIndex).toLowerCase();
            rawActivationKey.replace(startIndex, endIndex, substringToLowerCase);
        }

        return rawActivationKey;
    }

    private static void checkForSubstring(StringBuilder rawActivationKey, String input) {

        String substring = input.split(">>>\\s*".trim())[1];
        if (rawActivationKey.toString().contains(substring)) {
            System.out.printf("%s contains %s\n", rawActivationKey, substring);
        } else {
            System.out.println("Substring not found!");
        }
    }
}
/*The first line of the input will be your raw activation key. It will consist of letters and numbers only.
After that, until the "Generate" command is given, you will be receiving strings with instructions for different
operations that need to be performed upon the raw activation key.
There are several types of instructions, split by ">>>":
•	"Contains>>>{substring}":
o	If the raw activation key contains the given substring, prints: "{raw activation key} contains {substring}".
o	Otherwise, prints: "Substring not found!"
•	"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case and then
prints the activation key.
o	All given indexes will be valid.
•	"Slice>>>{startIndex}>>>{endIndex}":
o	Deletes the characters between the start and end indices (the end index is exclusive) and prints the activation key.
o	Both indices will be valid.
Input
•	The first line of the input will be a string consisting of letters and numbers only.
•	After the first line, until the "Generate" command is given, you will be receiving strings.
Output
•	After the "Generate" command is received, print:
o	"Your activation key is: {activation key}"*/