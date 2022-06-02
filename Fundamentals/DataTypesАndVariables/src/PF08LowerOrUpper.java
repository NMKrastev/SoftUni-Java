import java.util.Scanner;

public class PF08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.nextLine();
        char checker = letter.charAt(0);

        if (Character.isUpperCase(checker)) {
            System.out.printf("upper-case");
        } else {
            System.out.printf("lower-case");
        }
    }
}
/*Write a program that prints whether a given character is upper-case or lower-case.*/