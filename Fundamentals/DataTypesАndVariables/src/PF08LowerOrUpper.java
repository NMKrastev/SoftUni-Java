import java.util.Scanner;

public class PF08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(letter)) {
            System.out.printf("upper-case");
        } else {
            System.out.printf("lower-case");
        }
    }
}
/*Write a program that prints whether a given character is upper-case or lower-case.*/