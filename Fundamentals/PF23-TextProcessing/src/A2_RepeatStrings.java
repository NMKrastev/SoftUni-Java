import java.util.Scanner;

public class A2_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : line) {

            for (int i = 0; i < word.length(); i++) {
                result.append(word);
            }
        }

        System.out.println(result.toString());
    }
}
/*Write a Program That Reads an Array of Strings.
Each String is Repeated N Times, Where N is the length of the String. Print the Concatenated String.*/