import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A3_TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numsList = takeNumbersFromInput(input);
        List<String> nonNumsList = takeNonNumsList(input);

        List<Integer> takeList = getTakeList(numsList);
        List<Integer> skipList = getSkipList(numsList);

        String message = takeMessage(nonNumsList, takeList, skipList);
        System.out.println(message);

    }

    private static String takeMessage(List<String> nonNumsList, List<Integer> takeList, List<Integer> skipList) {

        StringBuilder message = new StringBuilder();
        int i = 0;
        int startIndex = 0;
        int endIndex = 0;
        int length = 0;
        int takeCount = 0;
        int skipCount = 0;

        while (i < takeList.size()) {
            startIndex = length;
            endIndex = length + takeList.get(i);
            while (startIndex < endIndex && startIndex <= nonNumsList.size() - 1) {
                message.append(nonNumsList.get(startIndex));
                startIndex++;
            }
            length = startIndex + skipList.get(i);
            i++;
        }
        return message.toString();
    }

    private static List<Integer> getSkipList(List<Integer> numsList) {

        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numsList.size(); i++) {
            if (i % 2 != 0) {
                skipList.add(numsList.get(i));
            }
        }
        return skipList;
    }

    private static List<Integer> getTakeList(List<Integer> numsList) {

        List<Integer> takeList = new ArrayList<>();
        for (int i = 0; i < numsList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numsList.get(i));
            }
        }
        return takeList;
    }

    private static List<String> takeNonNumsList(String input) {

        input = input.replaceAll("\\d", "");
        List<String> nonNumsList = new ArrayList<String>(Arrays.asList(input.split("")));

        return nonNumsList;
    }

    private static List<Integer> takeNumbersFromInput(String input) {

        List<Integer> numsList = new ArrayList<>();
        String numbers = input.replaceAll("[^0-9]", "");

        for (int i = 0; i < numbers.length(); i++) {
            numsList.add(Character.digit(numbers.charAt(i), 10));
        }

        return numsList;
    }
}
/*Write a program that reads a string and skips through it, extracting a hidden message.
The algorithm you have to implement is as follows:
Let's take the string "skipTest_String044170" as an example.
Take every digit from the string and store it somewhere. After that, remove all the digits from the string.
After this operation, you should have two lists of items: the numbers list and the non-numbers list:
•	Numbers list: [0, 4, 4, 1, 7, 0]
•	Non-numbers: [s, k, i, p, T, e, s, t, _, S, t, r, i, n, g]
After that, take every digit in the numbers list and split it up into a take list and a skip list, depending on whether
the digit is in an even or an odd index:
•	Numbers list: [0, 4, 4, 1, 7, 0]
•	Take list: [0, 4, 7]
•	Skip list: [4, 1, 0]
Afterward, iterate over both of the lists and skip {skipCount} characters from the non-numbers list, then take
{takeCount} characters and store it in a result string. Note that the skipped characters are summed up as they go.
The process would look like this on the aforementioned non-numbers list:
Example: "skipTest_String"
1.	Take 0 characters -> Taken: "", skip 4 characters  Skipped: "skip" -> Result: ""
2.	Take 4 characters -> Taken: "Test", skip 1 characters  Skipped: "_" -> Result: "Test"
3.	Take 7 characters -> Taken: "String", skip 0 characters  Skipped: "" -> Result: "TestString"
After that, just print the result string on the console.
Input
The encrypted message is a string.
Output
The decrypted message is a string.
Constraints
•	The count of digits in the input string will always be even.
•	The encrypted message will contain any printable ASCII character.
*/