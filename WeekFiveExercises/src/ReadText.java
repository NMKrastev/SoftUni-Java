import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        while (!input.equals("stop")) {
            System.out.println(input);
            input = scanner.nextLine().toLowerCase();
        }
    }
}
