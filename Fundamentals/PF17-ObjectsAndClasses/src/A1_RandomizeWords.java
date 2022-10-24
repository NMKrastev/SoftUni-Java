import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        List<String> lineList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        for (int i = 0; i < lineList.size(); i++) {
            int randomIndex = random.nextInt(lineList.size());
            String replacementWord = lineList.get(randomIndex);
            String currentWord = lineList.get(i);

            lineList.set(randomIndex, currentWord);
            lineList.set(i, replacementWord);
        }

        for (String word : lineList) {
            System.out.println(word);
        }
    }
}
/*You are given a list of words in one line. Randomize their order and print each word on a separate line.*/