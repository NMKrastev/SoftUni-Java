import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern patternName = Pattern.compile("@(.+?)\\|", Pattern.DOTALL);
        Pattern patternAge = Pattern.compile("#(.+?)\\*", Pattern.DOTALL);
        int index = 0;
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            Matcher matcherName = patternName.matcher(line);
            Matcher matcherAge = patternAge.matcher(line);

            if (matcherName.find() && matcherAge.find()) {
                System.out.printf("%s is %s years old.\n", matcherName.group(1), matcherAge.group(1));
            }
            index++;
        }
    }
}
/*Write a program that reads n lines of strings and extracts the name and age of a given person.
The person's name will be between "@" and "|". The person's age will be between "#" and "*".
Example: "Hello my name is @Peter| and I am #20* years old."
For each found name and age, print a line in the following format "{name} is {age} years old."
*/