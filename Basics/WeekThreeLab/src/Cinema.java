import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String projectionType = scanner.nextLine().toLowerCase();
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        int capacity = rows * cols;
        double income = 0;

        switch (projectionType) {
            case "premiere":
                income = capacity * 12;
                break;
            case "normal":
                income = capacity * 7.5;
                break;
            case "discount":
                income = capacity * 5;
                break;
        }

        System.out.printf("%.2f leva", income);

    }
}