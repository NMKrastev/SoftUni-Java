import java.util.*;

public class A2_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymsMap = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {

            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonymsMap.containsKey(word)) {
                synonymsMap.put(word, new ArrayList<>());
                synonymsMap.get(word).add(synonym);
            } else {
                synonymsMap.get(word).add(synonym);
            }
        }

        for (Map.Entry<String, List<String>> entry : synonymsMap.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), String.join(", ", entry.getValue()));
        }

    }
}
/*Write a program that keeps a map with synonyms. The key of the map will be the word. The value will be a list of all
the synonyms of that word. You will be given a number n. On the next 2 * n lines you will be given a word and a synonym
each on a separate line like this:
•	{word}
•	{synonym}
If you get the same word for the second time, just add the new synonym to the list.
Print the words in the following format:
*/