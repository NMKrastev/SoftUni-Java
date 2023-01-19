import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A6_FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> personInfoMap = new LinkedHashMap<>();
        String input;
        while(!(input = scanner.nextLine()).equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            if (!email.toLowerCase().endsWith(".uk") && !email.toLowerCase().endsWith(".us") && !email.toLowerCase().endsWith(".com")) {
                personInfoMap.put(name, email);
            }
        }

        personInfoMap.forEach((person, email) ->
                System.out.printf("%s -> %s\n", person, email));
    }
}
/*You are given a sequence of strings, each on a new line, until you receive the "stop" command.
The first string is a name of a person. On the second line, you receive his email. Your task is to collect their
names and emails and remove emails whose domain ends with "us", "uk," or "com" (case insensitive).
Print in the following format:
"{name} – > {email}"
*/
