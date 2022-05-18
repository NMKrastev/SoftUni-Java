import java.util.Scanner;

public class InvalidNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean isInRange = (n >= 100 && n <= 200) || n == 0;

        if (!isInRange) {
            System.out.println("invalid");
        }
    }
}