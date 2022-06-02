import java.util.Scanner;

public class PF06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            char firstLetter = (char) ('a' + i);
            for (int j = 0; j < n; j++) {
                char secondLetter = (char) ('a' + j);
                for (int k = 0; k < n; k++) {
                    char thirdLetter = (char) ('a' + k);
                    System.out.printf("%c%c%c\n", firstLetter, secondLetter, thirdLetter);
                }
            }
        }
    }
}
/*Write a program to read an integer n and print all triples of the first n small Latin letters,
ordered alphabetically*/