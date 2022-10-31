import java.util.Arrays;
import java.util.Scanner;

public class A4_WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split("\\s+")).filter(e -> e.length() % 2 == 0).toArray(String[]::new);

        System.out.println(String.join(System.lineSeparator(), words));
    }
}
/*Read an array of strings, take only words which length is even. Print each word on a new line.*/