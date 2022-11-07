import java.util.Scanner;

public class A8_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lettersArray = {"0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        double totalSum = 0;
        String[] inputArray = scanner.nextLine().split("\\s+");

        for (int i = 0; i < inputArray.length; i++) {
            double currentSum = 0;
            int letterNum = 0;
            String firstLetter = inputArray[i].substring(0, 1);
            double number = Double.parseDouble(inputArray[i].substring(1, inputArray[i].length() - 1));
            String lastLetter = inputArray[i].substring(inputArray[i].length() - 1);

            if (isUpperCase(firstLetter)) {
                letterNum = checkLetter(firstLetter, lettersArray);
                currentSum = number / letterNum;

            } else {
                letterNum = checkLetter(firstLetter, lettersArray);
                currentSum = number * letterNum;
            }

            if (isUpperCase(lastLetter)) {
                letterNum = checkLetter(lastLetter, lettersArray);
                currentSum -= letterNum;
            } else {
                letterNum = checkLetter(lastLetter, lettersArray);
                currentSum += letterNum;
            }
            totalSum += currentSum;
        }
        System.out.printf("%.2f\n", totalSum);
    }

    private static boolean isUpperCase(String letter) {

        char currentLetter = letter.charAt(0);

        if (Character.isUpperCase(currentLetter)) {
            return true;
        }
        return false;
    }

    private static int checkLetter(String letter, String[] letterArray) {

        int letterNum = 0;
        for (int i = 1; i < letterArray.length; i++) {
            if (letterArray[i].equalsIgnoreCase(letter)) {
                letterNum = i;
                break;
            }
        }
        return letterNum;
    }
}
/*Nakov likes Math. But he also likes the English alphabet a lot. He invented a game with numbers and letters from the
English alphabet. The game was simple. You get a string consisting of a number between two letters. Depending on whether
the letter was in front of the number or after it you would perform different mathematical operations on the
number to achieve the result.
First, you start with the letter before the number.
•	If it's uppercase you divide the number by the letter's position in the alphabet.
•	If it's lowercase you multiply the number with the letter's position in the alphabet.
Then you move to the letter after the number.
•	If it's uppercase you subtract its position from the resulted number.
•	If it's lowercase you add its position to the resulted number.
But the game became too easy for Nakov was really quick. He decided to complicate it a bit by doing the same but
with multiple strings keeping track of only the total sum of all results. Once he started to solve this with more
strings and bigger numbers it became quite hard to do it only in his mind. So he kindly asks you to write a program
that calculates the sum of all numbers after the operations on each number have been done.
For example, you are given the sequence "A12b s17G":
We have two strings – "A12b" and "s17G". We do the operations on each and sum them. We start with the letter before
the number on the first string. A is Uppercase and its position in the alphabet is 1. So we divide the number 12 with
position 1 (12/1 = 12). Then we move to the letter after the number. b is lowercase and its position is 2. So we add 2
to the resulting number (12+2=14). Similarly for the second string s is lowercase and its position is 19 so we multiply
it with the number (17*19 = 323). Then we have Uppercase G with position 7, so we subtract it from the resulted
number (323 – 7 = 316). Finally, we sum the 2 results and we get 14 + 316=330.
Input
The input comes from the console as a single line, holding the sequence of strings.
Strings are separated by one or more white spaces.
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
Print at the console a single number: the total sum of all processed numbers rounded up to two
digits after the decimal separator.
*/