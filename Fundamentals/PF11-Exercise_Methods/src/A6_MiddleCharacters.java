import java.util.Scanner;

public class A6_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleCharacters(input);

    }

    private static void printMiddleCharacters(String input) {

        String[] array = input.split("");

        if (array.length % 2 == 0) {
            System.out.println(array[array.length / 2 - 1] + array[array.length / 2]);
        } else {
            System.out.println(array[array.length / 2]);
        }

    }
}
/*You will receive a single string. Write a method that prints the middle character.
If the length of the string is even, there are two middle characters.*/