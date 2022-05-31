import java.util.Scanner;

public class PF07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumMoney = 0;
        boolean isChange = false;

        while (!input.equals("End")) {

            if (input.equals("Start")) {
                input = scanner.nextLine();

                while (!input.equals("End")) {

                    if ("Nuts".equals(input)) {
                        if (sumMoney >= 2) {
                            sumMoney -= 2;
                            System.out.println("Purchased Nuts");
                        } else {
                            System.out.println("Sorry, not enough money");
                        }
                    } else if ("Water".equals(input)) {
                        if (sumMoney >= 0.7) {
                            sumMoney -= 0.7;
                            System.out.println("Purchased Water");
                        } else {
                            System.out.println("Sorry, not enough money");
                        }
                    } else if ("Crisps".equals(input)) {
                        if (sumMoney >= 1.5) {
                            sumMoney -= 1.5;
                            System.out.println("Purchased Crisps");
                        } else {
                            System.out.println("Sorry, not enough money");
                        }
                    } else if ("Soda".equals(input)) {
                        if (sumMoney >= 0.8) {
                            sumMoney -= 0.8;
                            System.out.println("Purchased Soda");
                        } else {
                            System.out.println("Sorry, not enough money");
                        }
                    } else if ("Coke".equals(input)) {
                        if (sumMoney >= 1.0) {
                            sumMoney -= 1.0;
                            System.out.println("Purchased Coke");
                        } else {
                            System.out.println("Sorry, not enough money");
                        }
                    } else {
                        System.out.println("Invalid product");
                    }
                    input = scanner.nextLine();
                    if (input.equals("End")){
                        isChange = true;
                        break;
                    }
                }
            }

            if (isChange) {
                break;
            }

            double moneyInserted = Double.parseDouble(input);
            if (moneyInserted == 0.1 || moneyInserted == 0.2 || moneyInserted == 0.5
                    || moneyInserted == 1 || moneyInserted == 2) {
                sumMoney += moneyInserted;
            } else {
                System.out.printf("Cannot accept %.2f\n", moneyInserted);
            }
            input = scanner.nextLine();
        }

        if(isChange) {
            System.out.printf("Change: %.2f\n", sumMoney);
        }

    }
}
/*Your task is to calculate the total price of a purchase from a vending machine. Until you receive "Start" you will
be given different coins that are being inserted into the machine. You have to sum them to have the total money inserted.
There is a problem though. Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins. If someone tries to
insert some other coins you have to display "Cannot accept {money}", where the value is formatted to the second
digit after the decimal point and not add it to the total money. On the next few lines until you receive "End" you
will be given products to purchase. Your machine has however only "Nuts", "Water", "Crisps", "Soda", "Coke". The
prices are: 2.0, 0.7, 1.5, 0.8, 1.0 respectively. If the person tries to purchase a not existing product print
“Invalid product”. Be careful that the person may try to purchase a product for which he doesn't have money.
In that case, print "Sorry, not enough money". If the person purchases a product successfully print
"Purchased {product name}". After the "End" command print the money that is left formatted to the second decimal point
in the format "Change: {money left}".*/