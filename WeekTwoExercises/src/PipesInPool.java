import java.util.Scanner;

public class PipesInPool {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int volume = Integer.parseInt(scanner.nextLine());
        int pipe1 = Integer.parseInt(scanner.nextLine());
        int pipe2 = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());
        double water = (pipe1 + pipe2) * hours;

        if (water <= volume) {
            System.out.printf("The pool is %.2f%% full." +
                            "Pipe 1: %.2f%%. Pipe 2: %.2f%%.",
                    (water / volume * 100),
                    (pipe1 * hours / water * 100),
                    (pipe2 * hours / water * 100));
        } else {
            System.out.printf("For %f hours the pool" + " overflows with %f liters.", hours, water - volume);
        }
    }
}