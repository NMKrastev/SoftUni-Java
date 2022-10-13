import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<String> messageList = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String secretMessage = sumOfDigitsAtIndex(numsList, messageList);
        System.out.println(secretMessage);

    }

    private static String sumOfDigitsAtIndex(List<Integer> numsList, List<String> messageList) {

        StringBuilder secretMessage = new StringBuilder();
        for (int i = 0; i < numsList.size(); i++) {

            int sum = 0;
            int currentNum = numsList.get(i);
            while (currentNum > 0) {

                int digit = currentNum % 10;
                sum += digit;
                currentNum = currentNum / 10;
            }
            int index = findIndex(messageList, sum);
            secretMessage.append(findLetter(messageList, index));
        }

        return secretMessage.toString();
    }

    private static int findIndex(List<String> messageList, int sum) {

        int index = 0;
        if (sum > messageList.size()) {
            index = sum % messageList.size();
        } else {
            index = sum;
        }

        return index;
    }

    private static String findLetter(List<String> messageList, int index) {

        String letter = messageList.get(index);
        messageList.remove(index);
        return letter;
    }
}
/*You will be given a list of numbers and a string. For each element of the list, you have to take the sum of
its digits and take the element corresponding to that index from the text. If the index is greater than the length
of the text, start counting from the beginning (so that you always have a valid index). After getting the element
from the text, you must remove the character you have taken from it (so for the next index,
the text will be with one characterless).*/