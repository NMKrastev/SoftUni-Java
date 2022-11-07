import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A6_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lettersList = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int i = 0; i < lettersList.size(); i++) {

            if (i + 1 <= lettersList.size() - 1 && lettersList.get(i).equals(lettersList.get(i + 1))) {
                for (int j = i + 1; j < lettersList.size(); j++) {
                    if (lettersList.get(i).equals(lettersList.get(j))) {
                        lettersList.remove(j);
                        j--;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(lettersList.toString().replaceAll("[\\[\\],\\s+]", ""));
    }
}
/*Write a program that reads a string from the console and replaces any sequence of the same
letters with a single corresponding letter.*/