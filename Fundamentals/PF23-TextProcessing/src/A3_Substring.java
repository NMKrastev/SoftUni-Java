import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String text = scanner.nextLine();
        int index = text.indexOf(toRemove);

        while (index != -1) {
            text = text.replace(toRemove, "");
            index = text.indexOf(toRemove);
        }
        System.out.println(text);
    }
}
/*On the first line, you will receive a string. On the second line, you will receive a second string.
Write a program that removes all of the occurrences of the first string in the second until there is no match.
At the end print the remaining string.*/