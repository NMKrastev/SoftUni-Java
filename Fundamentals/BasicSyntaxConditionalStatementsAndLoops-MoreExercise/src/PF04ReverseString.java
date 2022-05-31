import java.util.Scanner;

public class PF04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String reverse = new StringBuilder(input).reverse().toString();

        System.out.println(reverse);
    }
}
/*Write a program that reverses a string and prints it on the console.*/