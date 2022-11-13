import java.util.Scanner;

public class A1_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder stops = new StringBuilder(input);
        String command;

        while (!(command = scanner.nextLine()).equals("Travel")) {
            if (command.contains("Add Stop")) {
                int index = Integer.parseInt(command.split(":")[1]);
                String stop = command.split(":")[2];
                if (isIndexValid(stops, index)) {
                    stops.insert(index, stop);
                }
                System.out.println(stops);
            } else if (command.contains("Remove Stop")) {
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if (isIndexValid(stops, startIndex, endIndex)) {
                    stops.delete(startIndex, endIndex + 1);
                }
                System.out.println(stops);
            } else if (command.contains("Switch")) {
                String toBeReplaced = command.split(":")[1];
                String replaceWith = command.split(":")[2];
                stops.replace(stops.indexOf(toBeReplaced), stops.indexOf(toBeReplaced) + toBeReplaced.length(), replaceWith);
                System.out.println(stops);
            }
        }

        System.out.printf("Ready for world tour! Planned stops: %s\n", stops);
    }

    private static boolean isIndexValid(StringBuilder stops, int startIndex, int endIndex) {
        return startIndex >= 0 && endIndex >= 0 && startIndex < stops.length() && endIndex < stops.length();
    }

    private static boolean isIndexValid(StringBuilder stops, int index) {
        return index >= 0 && index < stops.length();
    }
}
/*On the first line, you will be given a string containing all of your stops. Until you receive the command "Travel",
you will be given some commands to manipulate that initial string. The commands can be:
•	"Add Stop:{index}:{string}":
o	Insert the given string at that index only if the index is valid
•	"Remove Stop:{start_index}:{end_index}":
o	Remove the elements of the string from the starting index to the end index (inclusive) if both indices are valid
•	"Switch:{old_string}:{new_string}":
o	If the old string is in the initial string, replace it with the new one (all occurrences)
Note: After each command, print the current state of the string if it is valid!
After the "Travel" command, print the following: "Ready for world tour! Planned stops: {string}"
Input / Constraints
•	JavaScript: you will receive a list of strings
•	An index is valid if it is between the first and the last element index (inclusive) (0 ….. Nth) in the sequence.
Output
•	Print the proper output messages in the proper cases as described in the problem description
*/