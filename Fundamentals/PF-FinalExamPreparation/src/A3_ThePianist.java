import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A3_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, String>> pianoPiecesMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        addPiecesToMap(scanner, pianoPiecesMap, n);

        String command;

        while (!(command = scanner.nextLine()).equals("Stop")) {

            if (command.contains("Add")) {
                addPieceToMap(pianoPiecesMap, command);
            } else if (command.contains("Remove")) {
                removePieceFromMap(pianoPiecesMap, command);
            } else if (command.contains("Change")) {
                changeKey(pianoPiecesMap, command);
            }
        }

        printResult(pianoPiecesMap);

    }

    private static void printResult(Map<String, Map<String, String>> pianoPiecesMap) {

        pianoPiecesMap.forEach((piece, value) ->
                value.forEach((composer, key) ->
                        System.out.printf("%s -> Composer: %s, Key: %s\n", piece, composer, key)));
    }

    private static void changeKey(Map<String, Map<String, String>> pianoPiecesMap, String command) {

        String piece = command.split("\\|")[1];
        if (isPieceExist(pianoPiecesMap, piece)) {
            String key = command.split("\\|")[2];
            for (Map.Entry<String, String> entry : pianoPiecesMap.get(piece).entrySet()) {
                entry.setValue(key);
                break;
            }
            System.out.printf("Changed the key of %s to %s!\n", piece, key);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
        }
    }

    private static void removePieceFromMap(Map<String, Map<String, String>> pianoPiecesMap, String command) {

        String piece = command.split("\\|")[1];
        if (isPieceExist(pianoPiecesMap, piece)) {
            pianoPiecesMap.remove(piece);
            System.out.printf("Successfully removed %s!\n", piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
        }
    }

    private static void addPieceToMap(Map<String, Map<String, String>> pianoPiecesMap, String command) {

        String piece = command.split("\\|")[1];
        if (isPieceExist(pianoPiecesMap, piece)) {
            System.out.printf("%s is already in the collection!\n", piece);
        } else {
            String composer = command.split("\\|")[2];
            String key = command.split("\\|")[3];
            pianoPiecesMap.put(piece, new LinkedHashMap<>());
            pianoPiecesMap.get(piece).put(composer, key);
            System.out.printf("%s by %s in %s added to the collection!\n", piece, composer, key);
        }
    }

    private static boolean isPieceExist(Map<String, Map<String, String>> pianoPiecesMap, String piece) {

        for (Map.Entry<String, Map<String, String>> entry : pianoPiecesMap.entrySet()) {
            if (entry.getKey().equals(piece)) {
                return true;
            }
        }

        return false;
    }

    private static Map<String, Map<String, String>> addPiecesToMap(Scanner scanner, Map<String, Map<String, String>> pianoPiecesMap, int n) {

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            pianoPiecesMap.putIfAbsent(piece, new LinkedHashMap<>());
            pianoPiecesMap.get(piece).put(composer, key);
        }
        return pianoPiecesMap;
    }
}
/*On the first line of the standard input, you will receive an integer n – the number of pieces you will initially have.
On the next n lines, the pieces themselves will follow with their composer and key, separated by "|"
in the following format: "{piece}|{composer}|{key}".
Then, you will be receiving different commands, each on a new line, separated by "|", until the "Stop" command is given:
•	"Add|{piece}|{composer}|{key}":
o	You need to add the given piece with the information about it to the other pieces and print:
"{piece} by {composer} in {key} added to the collection!"
o	If the piece is already in the collection, print:
"{piece} is already in the collection!"
•	"Remove|{piece}":
o	If the piece is in the collection, remove it and print:
"Successfully removed {piece}!"
o	Otherwise, print:
"Invalid operation! {piece} does not exist in the collection."
•	"ChangeKey|{piece}|{new key}":
o	If the piece is in the collection, change its key with the given one and print:
"Changed the key of {piece} to {new key}!"
o	Otherwise, print:
"Invalid operation! {piece} does not exist in the collection."
Upon receiving the "Stop" command, you need to print all pieces in your collection in the following format:
"{Piece} -> Composer: {composer}, Key: {key}"
Input/Constraints
•	You will receive a single integer at first – the initial number of pieces in the collection
•	For each piece, you will receive a single line of text with information about it.
•	Then you will receive multiple commands in the way described above until the command "Stop".
Output
•	All the output messages with the appropriate formats are described in the problem description.*/