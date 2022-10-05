import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A1_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfNames = Integer.parseInt(scanner.nextLine());
        String[] arrayOfNames = new String[numOfNames];
        List<Integer> sumOfNames = new ArrayList<Integer>();

        for (int i = 0; i < numOfNames; i++) {

            String names = scanner.nextLine();
            int sum = 0;

            for (int j = 0; j < names.length(); j++) {


                char letter = names.charAt(j);

                if (letter == 'a' || letter == 'e' || letter == 'i' ||
                        letter == 'o' || letter == 'u' ||
                        letter == 'A' || letter == 'E' || letter == 'I' ||
                        letter == 'O' || letter == 'U') {

                    sum += letter * names.length();

                } else {

                    sum += letter / names.length();

                }
            }

            sumOfNames.add(sum);

        }

        Collections.sort(sumOfNames);

        for (int num : sumOfNames) {

            System.out.println(num);

        }
    }
}
/*Write a program that reads a sequence of strings from the console.
Encrypt every string by summing:
· The code of each vowel multiplied by the string length.
· The code of each consonant is divided by the string length.
Sort the number sequence in ascending order and print it on the console.
On the first line, you will always receive the number of strings you must read*/