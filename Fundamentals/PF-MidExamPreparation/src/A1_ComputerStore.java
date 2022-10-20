import java.util.Scanner;

public class A1_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalPriceNoTaxes = 0;
        double totalPrice = 0;
        double taxes = 0;
        String input = scanner.nextLine().trim();

        while (!input.equals("special") && !input.equals("regular")) {

            double partPrice = Double.parseDouble(input);

            if (partPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceNoTaxes += partPrice;
            }
            input = scanner.nextLine().trim();
        }

        taxes = totalPriceNoTaxes * 0.2;
        totalPrice = totalPriceNoTaxes + taxes;

        if (input.equals("special")) {
            totalPrice *= 0.9;
            if (totalPrice == 0) {
                System.out.println("Invalid order!");
            } else {
                System.out.printf("Congratulations you've just bought a new computer!\n" +
                        "Price without taxes: %.2f$\n" +
                        "Taxes: %.2f$\n" +
                        "-----------\n" +
                        "Total price: %.2f$\n", totalPriceNoTaxes, taxes, totalPrice);
            }
        } else {
            if (totalPrice == 0) {
                System.out.println("Invalid order!");
            } else {
                System.out.printf("Congratulations you've just bought a new computer!\n" +
                        "Price without taxes: %.2f$\n" +
                        "Taxes: %.2f$\n" +
                        "-----------\n" +
                        "Total price: %.2f$\n", totalPriceNoTaxes, taxes, totalPrice);
            }
        }
    }
}
/*Write a program that prints you a receipt for your new computer. You will receive the parts' prices (without tax)
until you receive what type of customer this is - special or regular. Once you receive the type of
customer you should print the receipt.
The taxes are 20% of each part's price you receive.
If the customer is special, he has a 10% discount on the total price with taxes.
If a given price is not a positive number, you should print "Invalid price!" on the console and
continue with the next price.
If the total price is equal to zero, you should print "Invalid order!" on the console.
Input
•	You will receive numbers representing prices (without tax) until command "special" or "regular":
Output
•	The receipt should be in the following format:
"Congratulations you've just bought a new computer!
Price without taxes: {total price without taxes}$
Taxes: {total amount of taxes}$
-----------
Total price: {total price with taxes}$"
Note: All prices should be displayed to the second digit after the decimal point! The discount is applied only on the
total price. Discount is only applicable to the final price!
*/