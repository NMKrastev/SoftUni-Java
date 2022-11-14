import java.util.Scanner;

public class A1_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder password = new StringBuilder(input);

        while (!(input = scanner.nextLine()).equals("Done")) {

            if (input.contains("TakeOdd")) {
                password = getCharAtOddPositions(password);
                System.out.println(password);
            } else if (input.contains("Cut")) {
                deleteSubstring(input, password);
                System.out.println(password);
            } else if (input.contains("Substitute")) {
                String substringToReplace = input.split("\\s")[1];
                String substringReplacement = input.split("\\s")[2];
                if (password.toString().contains(substringToReplace)) {
                    replaceAllOccurrencesOfSubstring(password, substringToReplace, substringReplacement);
                    System.out.println(password);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
        }

        System.out.printf("Your password is: %s", password);
    }

    private static void replaceAllOccurrencesOfSubstring(StringBuilder password, String substringToReplace, String substringReplacement) {

        int index = password.indexOf(substringToReplace);
        while (index != -1) {
            password.replace(password.indexOf(substringToReplace),
                    password.indexOf(substringToReplace) + substringToReplace.length(), substringReplacement);
            index = password.indexOf(substringToReplace);
        }
    }

    private static void deleteSubstring(String input, StringBuilder password) {

        int index = Integer.parseInt(input.split("\\s")[1]);
        int length = Integer.parseInt(input.split("\\s")[2]);
        password.delete(index, index + length);
    }

    private static StringBuilder getCharAtOddPositions(StringBuilder password) {

        StringBuilder rawPassword = new StringBuilder();
        for (int i = 1; i < password.length(); i += 2) {
            rawPassword.append(password.charAt(i));
        }
        password = rawPassword;
        return password;
    }
}
/*Write a password reset program that performs a series of commands upon a predefined string. First, you will receive
a string, and afterward, until the command "Done" is given, you will be receiving strings with commands split by
a single space. The commands will be the following:
•	"TakeOdd"
o	 Takes only the characters at odd indices and concatenates them to obtain the new raw password and then prints it.
•	"Cut {index} {length}"
o	Gets the substring with the given length starting from the given index from the password and removes its first
occurrence, then prints the password on the console.
o	The given index and the length will always be valid.
•	"Substitute {substring} {substitute}"
o	If the raw password contains the given substring, replaces all of its occurrences with the substitute text given
and prints the result.
o	If it doesn't, prints "Nothing to replace!".
Input
•	You will be receiving strings until the "Done" command is given.
Output
•	After the "Done" command is received, print:
o	"Your password is: {password}"
Constraints
•	The indexes from the "Cut {index} {length}" command will always be valid.*/