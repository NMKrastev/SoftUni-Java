import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class A2_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> mirrorWordsList = new ArrayList<>();
        Pattern pattern = Pattern.compile("([#@])(?<wordOne>([A-z]{3,}))\\1\\1(?<wordTwo>([A-z]{3,}))\\1");
        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);
        int countPairs = 0;

        while (matcher.find()) {

            countPairs++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = new StringBuilder(matcher.group("wordTwo")).reverse().toString();

            if (wordOne.equals(wordTwo)) {
                mirrorWordsList.add(List.of(wordOne, matcher.group("wordTwo")));
            }
        }

        if (countPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countPairs);
        }

        if (mirrorWordsList.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");

            System.out.println(mirrorWordsList.stream()
                    .map(pair -> String.join(" <=> ", pair))
                    .collect(Collectors.joining(", ")));
        }
    }
}
/*The SoftUni Spelling Bee competition is here. But it`s not like any other Spelling Bee competition out there.
It`s different and a lot more fun! You, of course, are a participant, and you are eager to show the competition
that you are the best, so go ahead, learn the rules and win!
On the first line of the input, you will be given a text string. To win the competition, you have to find all hidden
word pairs, read them, and mark the ones that are mirror images of each other.
First of all, you have to extract the hidden word pairs. Hidden word pairs are:
•	Surrounded by "@" or "#" (only one of the two) in the following pattern #wordOne##wordTwo# or @wordOne@@wordTwo@
•	At least 3 characters long each (without the surrounding symbols)
•	Made up of letters only
If the second word, spelled backward, is the same as the first word and vice versa (casing matters!), they are a match,
and you have to store them somewhere. Examples of mirror words:
#Part##traP# @leveL@@Level@ #sAw##wAs#
•	If you don`t find any valid pairs, print: "No word pairs found!"
•	If you find valid pairs print their count: "{valid pairs count} word pairs found!"
•	If there are no mirror words, print: "No mirror words!"
•	If there are mirror words print:
"The mirror words are:
{wordOne} <=> {wordtwo}, {wordOne} <=> {wordtwo}, … {wordOne} <=> {wordtwo}"
Input / Constraints
•	You will recive a string.
Output
•	Print the proper output messages in the proper cases as described in the problem description.
•	If there are pairs of mirror words, print them in the end, each pair separated by ", ".
•	Each pair of mirror word must be printed with " <=> " between the words.
*/