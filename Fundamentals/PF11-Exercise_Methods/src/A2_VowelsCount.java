import java.util.Scanner;

public class A2_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printNumberOfVowels(input);

    }

    private static void printNumberOfVowels(String input) {

        String[] letters = input.split("");
        int count = 0;

        for (int i = 0; i < letters.length; i++) {

            if (letters[i].equals("a") || letters[i].equals("e") || letters[i].equals("i") || letters[i].equals("o") || letters[i].equals("u") ||
                    letters[i].equals("A") || letters[i].equals("E") || letters[i].equals("I") || letters[i].equals("O") || letters[i].equals("U")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
/*Write a method that receives a single string and prints the count of the vowels.
Use an appropriate name for the method.*/