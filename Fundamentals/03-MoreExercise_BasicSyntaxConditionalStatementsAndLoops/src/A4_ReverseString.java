import java.util.Scanner;

public class A4_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        String reverse = new StringBuilder(word).reverse().toString();

        System.out.println(reverse);
    }
}
/*Write a program that reverses a string and prints it on the console.*/