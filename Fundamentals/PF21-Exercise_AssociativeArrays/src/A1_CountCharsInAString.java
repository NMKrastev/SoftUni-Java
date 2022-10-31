import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class A1_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().replaceAll(" ", "");
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char currentLetter = word.charAt(i);

            map.putIfAbsent(currentLetter, 0);
            int count = map.get(currentLetter);
            map.put(currentLetter, count + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
/*Write a program that counts all characters in a string except space (' ').
Print all occurrences in the following format:
"{char} -> {occurrences}"
*/