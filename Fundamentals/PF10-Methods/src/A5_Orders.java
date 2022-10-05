import java.util.Scanner;

public class A5_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printTotalPrice(product, quantity);
    }

    private static void printTotalPrice(String product, int quantity) {

        switch (product) {
            case "coffee" -> System.out.printf("%.2f", quantity * 1.50);
            case "water" -> System.out.printf("%.2f", quantity * 1.00);
            case "coke" -> System.out.printf("%.2f", quantity * 1.40);
            case "snacks" -> System.out.printf("%.2f", quantity * 2.00);
        }
    }
}
/*Write a method that calculates the total price of an order and prints it on the console.
The method should receive one of the following products: coffee, water, coke, snacks, and a
quantity of the product. The prices for a single piece of each product are:
•	coffee – 1.50
•	water – 1.00
•	coke – 1.40
•	snacks – 2.00
Print the result rounded to the second decimal place.
*/