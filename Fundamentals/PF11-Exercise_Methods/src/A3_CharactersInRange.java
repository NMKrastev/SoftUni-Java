import java.util.Scanner;

public class A3_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);

        printCharsInbetween(one, two);
    }

    private static void printCharsInbetween(char one, char two) {


        int start = Math.min(one, two);
        int end = Math.max(one, two);

        for (int i = start + 1; i < end; i++) {

            char temp = (char) i;
            System.out.print(temp + " ");
        }
    }
}
/*Write a method that receives two characters and prints all the characters in
between them on a single line according to ASCII.*/