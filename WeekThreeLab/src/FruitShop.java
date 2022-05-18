import java.util.Scanner;

public class FruitShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine().toLowerCase();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;

        if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday")
                || day.equals("thursday") || day.equals("friday")) {
            if (fruit.equals("banana")) {
                price = 2.5;
            } else if (fruit.equals("apple")) {
                price = 1.2;
            } else if (fruit.equals("orange")) {
                price = 0.85;
            } else if (fruit.equals("grapefruit")) {
                price = 1.45;
            } else if (fruit.equals("kiwi")) {
                price = 2.7;
            } else if (fruit.equals("pineapple")) {
                price = 5.5;
            } else if (fruit.equals("grape")) {
                price = 3.85;
            } else {
                System.out.println("error");
            }
        } else if (day.equals("saturday") || day.equals("sunday")) {
            if (fruit.equals("banana")) {
                price = 2.7;
            } else if (fruit.equals("apple")) {
                price = 1.25;
            } else if (fruit.equals("orange")) {
                price = 0.90;
            } else if (fruit.equals("grapefruit")) {
                price = 1.60;
            } else if (fruit.equals("kiwi")) {
                price = 3;
            } else if (fruit.equals("pineapple")) {
                price = 5.6;
            } else if (fruit.equals("grape")) {
                price = 4.2;
            }
        } else {
            System.out.println("error");
        }

        if (price > 0) {
            System.out.printf("%.2f", price * quantity);
        } else {
            System.out.println("error");
        }
    }
}