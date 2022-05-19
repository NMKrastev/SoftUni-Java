import java.util.Scanner;

public class Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        int allArea = height * width * 4;
        allArea = allArea - allArea * percent / 100;

        String input = scanner.nextLine();

        while (!input.equals("Tired!")) {

            Double paint = Double.parseDouble(input);
            allArea -= paint;

            if (allArea <= 0) {
                break;
            }

            input = scanner.nextLine();

        }

        if (allArea == 0) {
            System.out.println("All walls are painted! Great job, Pesho!");
        } else if (allArea < 0) {
            System.out.printf("All walls are painted and you have %d l paint left!", Math.abs(allArea));
        } else {
            System.out.printf("%d quadratic m left.", allArea);
        }

    }
}
