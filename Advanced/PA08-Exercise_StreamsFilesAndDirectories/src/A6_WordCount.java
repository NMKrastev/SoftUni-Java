import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class A6_WordCount {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/words.txt"));
        PrintWriter print = new PrintWriter("PA08-Exercise_StreamsFilesAndDirectories/resources/results.txt");
        Map<String, Integer> occurrencesMap = new LinkedHashMap<>();
        String[] words = reader.readLine().split("\\s+");

        for (String word : words) {
            occurrencesMap.putIfAbsent(word, 0);
        }
        reader.close();

        reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/text.txt"));
        String lineToCheck = reader.readLine();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(lineToCheck);

        while (matcher.find()) {
            String word = matcher.group(0);
            if (occurrencesMap.containsKey(word)) {
                occurrencesMap.put(word, occurrencesMap.get(word) + 1);
            }
        }

        occurrencesMap = occurrencesMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        occurrencesMap.forEach((word, count) -> print.println(String.format("%s - %d", word, count)));

        reader.close();
        print.close();
    }
}
/*Write a program that reads a list of words from the file "words.txt" (from the Resources - Exercises)
and finds how many times each of the words is contained in another file "text.txt" (from the Resources - Exercises).
Matching should be case-insensitive.
Write the results in the file "results.txt". Sort the words by frequency in descending order.
*/
