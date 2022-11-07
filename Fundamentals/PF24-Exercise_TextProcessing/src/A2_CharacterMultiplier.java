import java.util.Scanner;

public class A2_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordOne = scanner.next().split("\\s+")[0];
        String wordTwo = scanner.nextLine().split("\\s+")[1];

        int sum = getSumOfChars(wordOne, wordTwo);
        System.out.println(sum);
    }

    private static int getSumOfChars(String wordOne, String wordTwo) {

        int sum = 0;
        char symbolOne;
        char symbolTwo;

        if (wordOne.length() >= wordTwo.length()) {
            for (int i = 0; i < wordOne.length(); i++) {
                if (i < wordTwo.length()) {
                    symbolOne = wordOne.charAt(i);
                    symbolTwo = wordTwo.charAt(i);
                    sum += symbolOne * symbolTwo;
                } else {
                    symbolOne = wordOne.charAt(i);
                    sum += symbolOne;
                }
            }
        } else {
            for (int i = 0; i < wordTwo.length(); i++) {
                if (i < wordOne.length()) {
                    symbolOne = wordOne.charAt(i);
                    symbolTwo = wordTwo.charAt(i);
                    sum += symbolOne * symbolTwo;
                } else {
                    symbolTwo = wordTwo.charAt(i);
                    sum += symbolTwo;
                }
            }
        }
        return sum;
    }
}
/*Create a method that takes two strings as arguments and returns the sum of their character codes multiplied
(multiply str1[0] with str2[0] and add to the total sum). Then continue with the next two characters. If one
of the strings is longer than the other, add the remaining character codes to the total sum without multiplication.*/