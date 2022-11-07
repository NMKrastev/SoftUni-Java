import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class A3_TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern patternItem = Pattern.compile("&(.+?)&");
        Pattern patternDestination = Pattern.compile("<(.+?)>");
        List<Integer> numsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input;

        while (!(input = scanner.nextLine()).equals("find")) {

            List<String> codeList = Arrays.stream(input.split("")).collect(Collectors.toList());

            String hiddenMessage = getHiddenMessage(numsList, codeList);
            Matcher matcherItem = patternItem.matcher(hiddenMessage);
            Matcher matcherDestination = patternDestination.matcher(hiddenMessage);

            if (matcherItem.find() && matcherDestination.find()) {
                System.out.printf("Found %s at %s\n", matcherItem.group(1), matcherDestination.group(1));
            }
        }
    }

    private static String getHiddenMessage(List<Integer> numsList, List<String> codeList) {
        int index = 0;
        for (int i = 0; i < codeList.size(); i++) {
            if (index == numsList.size()) {
                index = 0;
            }
            char symbol = codeList.get(i).charAt(0);
            int num = numsList.get(index);
            symbol = (char) (symbol - num);
            codeList.set(i, String.valueOf(symbol));
            index++;
        }

        return codeList.toString().replaceAll("[\\[\\], ]", "");
    }
}
/*Write a program that decrypts a message by a given key and gathers information about the hidden treasure type and
its coordinates. On the first line, you will receive a key (sequence of numbers). On the next few lines, until you
receive "find", you will get lines of strings. You have to loop through every string and decrease the ASCII code of
each character with a corresponding number of the key sequence. The way you choose a key number from the sequence is
by just looping through it. If the length of the key sequence is less than the string sequence, you start looping from
the beginning of the key. For more clarification, see the example below. After decrypting the message, you will get a
type of treasure and its coordinates. The type will be between the symbol "&" and the coordinates will be between the
symbols "<" and ">". For each line print the type and the coordinates in format "Found {type} at {coordinates}".*/