import java.util.Scanner;

public class A2_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        int startIndex = one;
        int endIndex = two;
        char[] array = scanner.nextLine().toCharArray();

        if (startIndex < endIndex) {
            for (int i = startIndex + 1; i < endIndex - 1; i++) {

                for (int j = 0; j < array.length; j++) {
                    if (array[j] == i) {
                        sum += i;
                    }
                }
            }
        } else if (endIndex < startIndex) {
            int count = 127 - startIndex + endIndex + 1;
            while (count-- > 0) {
                startIndex++;
                if (startIndex == 128) {
                    startIndex = -1;
                    continue;
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == startIndex) {
                        sum += startIndex;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
/*Write a program that prints a sum of all characters between two given characters (their ASCII code).
In the first line, you will get a character. In the second line, you get another character.
On the last line, you get a random string. Find all the characters between the two given and print their ASCII sum.*/