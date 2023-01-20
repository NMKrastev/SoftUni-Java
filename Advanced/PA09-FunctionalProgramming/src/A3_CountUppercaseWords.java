import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class A3_CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isStartingWithUppercase = word -> Character.isUpperCase(word.charAt(0));

        ArrayDeque<String> queueOfWords = new ArrayDeque<>();
        Arrays.stream(words).filter(isStartingWithUppercase).forEach(queueOfWords::offer);

        System.out.println(queueOfWords.size());
        while (!queueOfWords.isEmpty()) {
            System.out.println(queueOfWords.poll());
        }
    }
}
/*Write a program that reads one line of text from the console. Print the count of words that start with
an Uppercase letter, after that print all these words in the same order as you found them in the text.
Use a Predicate<String>.
*/
