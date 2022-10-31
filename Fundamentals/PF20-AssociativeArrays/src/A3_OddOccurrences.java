import java.util.*;

public class A3_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] word = scanner.nextLine().split("\\s+");

        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < word.length; i++) {
            String currentWord = word[i].toLowerCase();

            map.putIfAbsent(currentWord, 0);
            int value = map.get(currentWord);
            map.put(currentWord, value + 1);

        }

        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", odds));
    }
}
/*Write a program that extracts from a given sequence of words all elements that are present
in it an odd number of times (case-insensitive).
•	Words are given in a single line, space-separated.
•	Print the result elements in lowercase in their order of appearance.
*/