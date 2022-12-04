import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([!])(?<command>[A-Z][a-z]{2,})\\1:(\\[)(?<message>[a-zA-Z]{8,})(\\])");
        int num = Integer.parseInt(scanner.nextLine());
        String input;
        for (int i = 0; i < num; i++) {
            input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                printMessage(matcher);
            } else {
                System.out.println("The message is invalid");
            }
        }
    }

    private static void printMessage(Matcher matcher) {
        String currentCommand = matcher.group("command");
        String currentMessage = matcher.group("message");
        System.out.print(currentCommand + ":");
        for (int j = 0; j < currentMessage.length(); j++) {
            System.out.print(" " + (int) currentMessage.charAt(j));
        }
        System.out.println();
    }
}
