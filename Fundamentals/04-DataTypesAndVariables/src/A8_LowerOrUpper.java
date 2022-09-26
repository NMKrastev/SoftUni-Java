import java.util.Scanner;

public class A8_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(letter)) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }

    }
}
/*Write a program that prints whether a given character
is upper-case or lower-case*/