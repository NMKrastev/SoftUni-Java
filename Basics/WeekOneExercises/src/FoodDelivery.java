import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int veganMenu = Integer.parseInt(scanner.nextLine());
        double sweets = ((chickenMenu * 10.35) + (fishMenu * 12.40) + (veganMenu * 8.15)) * 0.2;
        double totalPrice = ((chickenMenu * 10.35) + (fishMenu * 12.40) + (veganMenu * 8.15)) + sweets + 2.50;

        System.out.println(totalPrice);

    }
}
