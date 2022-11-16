import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class A3_PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern lettersPattern = Pattern.compile("([#$%*&])(?<letters>[A-Z]+)\\1");
        Pattern asciiCodeAndLengthPattern = Pattern.compile("(?<asciiCode>[0-9]{2}):(?<length>[0-9]{2})");

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Matcher lettersMatcher = lettersPattern.matcher(input.get(0));

        if (lettersMatcher.find()) {
            String partOne = lettersMatcher.group("letters");
            for (int i = 0; i < partOne.length(); i++) {
                int currentLetter = partOne.charAt(i);
                Matcher asciiCodeAndLengthMather = asciiCodeAndLengthPattern.matcher(input.get(1));
                while (asciiCodeAndLengthMather.find()) {
                    if (Integer.parseInt(asciiCodeAndLengthMather.group("asciiCode")) == currentLetter) {
                        int length = Integer.parseInt(asciiCodeAndLengthMather.group("length")) + 1;
                        String[] words = input.get(2).split("\\s+");
                        Arrays.stream(words).filter(s ->
                                        s.length() == length && s.charAt(0) == (char) (currentLetter))
                                .forEach(System.out::println);
                        break;
                    }
                }
            }
        }
    }
}
/*You read a single line of ASCII symbols, and the message is somewhere inside it. You must find it.
 The input consists of three parts separated with "|" like this:
"{firstPart}|{secondPart}|{thirdPart}"
Each word starts with a capital letter and has a fixed length; you can find those in each different input part.
The first part carries the capital letters for each word inside the message. You must find those capital letters 1
or more from A to Z. The capital letters should be surrounded from both sides with any of the following symbols
– "#, $, %, *, &". And those symbols should match on both sides. This means that $AOTP$ - is a valid pattern for the
capital letters. $AKTP% - is invalid since the symbols do not match.
The second part of the data contains the starting letter ASCII code and words length /between 1 – 20 characters/,
in the following format: "{asciiCode}:{length}". For example, "67:05" – means that '67' - ASCII code equal to the
capital letter "C", represents a word starting with "C" with the following 5 characters: like "Carrot". The ASCII code
should be a capital letter equal to a letter from the first part. Word's length should be exactly 2 digits. Length less
than 10 will always have a padding zero. You don't need to check that.
The third part of the message are words separated by spaces. Those words have to start with the Capital letter [A…Z]
equal to the ASCII code and have exactly the length for each capital letter you have found in the second part.
Those words can contain any ASCII symbol without spaces.
When you find the valid word, you must print it on a new line.
Input / Constraints
•	In the first line – the text is in the form of three different parts separated by "|".
Any ASCII character can be inside the input, except '|'.
•	Input will always be valid - you don’t need to check it.
•	The input will always have three different parts that will always be separated by "|".
Output
•	Print all extracted words, each on a new line.
•	Allowed working time / memory: 100ms / 16MB.
*/