import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int coolThreshold = getCoolThreshold(input);
        List<String> coolEmojisList = getCoolEmojisList(input, coolThreshold);
        int count = getCountOfEmojis(input);

        System.out.printf("Cool threshold: %d\n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", count);
        coolEmojisList.forEach(e -> System.out.printf("%s\n", e));

    }

    private static List<String> getCoolEmojisList(String input, int coolThreshold) {

        List<String> coolEmojisList = new ArrayList<>();
        Pattern emojiPattern = Pattern.compile("(?<emoji>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))");
        Matcher matcher = emojiPattern.matcher(input);

        while (matcher.find()) {
            String currentEmoji = matcher.group("emoji");
            int currentAsciiSum = 0;
            for (int i = 2; i < currentEmoji.length() - 2; i++) {
                char currentSymbol = currentEmoji.charAt(i);
                currentAsciiSum += (int) currentSymbol;
            }

            if (currentAsciiSum > coolThreshold) {
                coolEmojisList.add(matcher.group("emoji"));
            }
        }

        return coolEmojisList;
    }

    private static int getCountOfEmojis(String input) {

        int count = 0;
        Pattern emojiPattern = Pattern.compile("(?<emoji>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))");
        Matcher matcher = emojiPattern.matcher(input);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    private static int getCoolThreshold(String input) {

        int coolThreshold = 1;
        Pattern digitsPattern = Pattern.compile("\\d");
        Matcher matcher = digitsPattern.matcher(input);

        while (matcher.find()) {
            coolThreshold *= Integer.parseInt(matcher.group(0));
        }

        return coolThreshold;
    }
}
/*Your task is to write a program that extracts emojis from a text and find the threshold based on the input.
You have to get your cool threshold. It is obtained by multiplying all the digits found in the input.
The cool threshold could be a huge number, so be mindful.
An emoji is valid when:
•	It is surrounded by 2 characters, either "::" or "**"
•	It is at least 3 characters long (without the surrounding symbols)
•	It starts with a capital letter
•	Continues with lowercase letters only
Examples of valid emojis: ::Joy::, **Banana**, ::Wink::
Examples of invalid emojis: ::Joy**, ::fox:es:, **Monk3ys**, :Snak::Es::
You need to count all valid emojis in the text and calculate their coolness. The coolness of the emoji is determined
by summing all the ASCII values of all letters in the emoji.
Examples: ::Joy:: - 306, **Banana** - 577, ::Wink:: - 409
You need to print the result of the cool threshold and, after that to take all emojis out of the text, count them and
print only the cool ones on the console.
Input
•	On the single input, you will receive a piece of string.
Output
•	On the first line of the output, print the obtained Cool threshold in the format:
"Cool threshold: {coolThresholdSum}"
•	On the following line, print the count of all emojis found in the text in format:
"{countOfAllEmojis} emojis found in the text. The cool ones are:
{cool emoji 1}
{cool emoji 2}
…
{cool emoji N}"
Constraints
There will always be at least one digit in the text!*/