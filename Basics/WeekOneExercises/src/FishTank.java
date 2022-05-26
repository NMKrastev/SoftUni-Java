import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int wight = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine()) / 100;
        double poolCapacity = length * wight * height / 1000.00;
        double literNeeded = poolCapacity *  (1 - percent);

        System.out.println(literNeeded);

    }
}
