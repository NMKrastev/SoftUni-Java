import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A4_CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> characterMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            characterMap.putIfAbsent(current, 0);
            characterMap.put(current, characterMap.get(current) + 1);
        }

        characterMap.forEach((character, occurrence) ->
                System.out.printf("%s: %d time/s\n", character, occurrence));
    }
}
/*Write a program that reads some text from the console and counts the occurrences of each character in it.
Print the results in alphabetical (lexicographical) order.*/
