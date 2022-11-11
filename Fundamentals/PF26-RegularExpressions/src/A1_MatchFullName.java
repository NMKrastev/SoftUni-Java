import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\b[A-Z][a-z]+\\s[A-Z][a-z]+\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
/*Write a Java Program to match full names from a list of names and print them on the console.
Writing the Regular Expression
First, write a regular expression to match a valid full name, according to these conditions:
· A valid full name has the following characteristics:
o It consists of two words.
o Each word starts with a capital letter.
o After the first letter, it only contains lowercase letters afterward.
o Each of the two words should be at least two letters long.
o The two words are separated by a single space.
To help you out, we've outlined several steps:
1. Use an online regex tester like https://regex101.com/
2. Check out how to use character sets (denoted with square brackets - '[]')
3. Specify that you want two words with a space between them (the space character ' ', and not any whitespace symbol)
4. For each word, specify that it should begin with an uppercase letter using a character set. The desired characters are in a range – from 'A' to 'Z'.
5. For each word, specify that what follows the first letter are only lowercase letters, one or more – use another character set and the correct quantifier.
6. To prevent letters' capture across new lines, put "\b" at the beginning and the end of your regex.
This will ensure that what precedes and what follows the match is a word boundary (like a new line).

To check your RegEx, use these values for reference (paste all of them in the Test String field):*/