package EP12_JavaAdvancedExam19February2022;

import java.util.*;
import java.util.stream.Collectors;

public class A1_FoodFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vowels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> consonants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        while (!consonants.isEmpty()) {

            String vowel = vowels.removeFirst();
            String consonant = consonants.removeLast();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(vowel);
                int indexConsonant = word.indexOf(consonant);
                if (indexVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }
                if (indexConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowels.addLast(vowel);
        }
        List<String> output = Arrays.stream(foundWords).filter(e -> !e.contains("*")).collect(Collectors.toList());
        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);
    }
}
/*You will be given two sequences of characters, representing vowels and consonants.
Your task is to start checking if the following words could be created:
•	"pear"
•	"flour"
•	"pork"
•	"olive"
Start by taking the first character of the vowels collection and the last character from the consonants collection.
Then check if these letters are present in one or more of the given words. If these letters are present,
you should store the information. Then process to the next couple of letters until there are no more consonant letters left.
A letter (vowels or consonants) could participate in more than one word, for example:
The letter 'o' is present in  "flour", "pork", and "olive".
The letter 'l' is present in "flour", and "olive".
Keep in mind that:
•	A vowel letter is always returned to the collection, whether used or not.
•	A consonant letter is always removed from the collection, whether used or not.
As a result, you should check how many of the given words were found and print:
"Words found: {numberOfWordsFound}
{wordOne}
{wordTwo}
…"
Look at the provided examples for a better understanding of the problem.
Input
•	On the first line, you will receive characters representing the vowels, separated by a single space (" ").
•	On the second line, you will receive characters representing the consonants, separated by a single space (" ").
Output
•	As a result, print on the first line how many words have been found and on the next N lines, every word:
"Words found: {numberOfWordsFound}
{wordOne}
{wordTwo}
…"
Print words in the same order as in the problem's description.
Constraints
•	All letters will be lowercase.
•	All letters in the given words are unique.
•	There will be no case where no word is matched.
•	The letter 'y' will be always vowel.
*/
