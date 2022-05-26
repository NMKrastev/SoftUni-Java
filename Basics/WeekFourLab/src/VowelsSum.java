import java.util.Scanner;

public class VowelsSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();
        int sum = 0;

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == 'a') {
                sum += 1;
            } else if (word.charAt(i) == 'e') {
                sum += 2;
            } else if (word.charAt(i) == 'i') {
                sum += 3;
            } else if (word.charAt(i) == 'o') {
                sum += 4;
            } else if (word.charAt(i) == 'u') {
                sum += 5;
            }
        }

        System.out.println("Vowels sum = " + sum);

    }
}