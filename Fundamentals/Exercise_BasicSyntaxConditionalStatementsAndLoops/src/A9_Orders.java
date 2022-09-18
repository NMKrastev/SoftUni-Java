import java.util.Scanner;

public class A9_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOrders = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 0; i < numberOfOrders; i++) {

            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            double currentPrice = (days * capsuleCount) * pricePerCapsule;
            totalPrice += currentPrice;

            System.out.printf("The price for the coffee is: $%.2f\n", currentPrice);

        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
/*We are placing N orders at a time. You need to calculate the
price on the following formula:
((daysInMonth * capsulesCount) * pricePerCapsule)

Input / Constraints
· On the first line, you will receive integer N – the count of
orders the shop will receive.
· For each order, you will receive the following information:
o Price per capsule - floating-point number in the range [0.00…1000.00].
o Days – integer in the range [1…31].
o Capsules count - integer in the range [0…2000].
The input will be in the described format, there is no need to
check it explicitly.*/