import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyNeeded = Double.parseDouble(scanner.nextLine());
        int cashCount = 0, cardCount = 0, count = 1;
        double totalCash = 0, totalCard = 0;
        boolean isEnd = false;

        while (moneyNeeded > 0) {

            String input = scanner.nextLine();

            if (input.equals("End")) {
                isEnd = true;
                break;
            }

            double price = Double.parseDouble(input);

            if (count % 2 == 0) {
                if (price < 10) {
                    System.out.println("Error in transaction!");
                    count++;
                    continue;
                }

                totalCard += price;
                cardCount++;

            } else {
                if (price > 100) {
                    System.out.println("Error in transaction!");
                    count++;
                    continue;
                }

                totalCash += price;
                cashCount++;

            }
            count++;
            System.out.println("Product sold!");

            moneyNeeded -= price;

        }

        if (isEnd) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f\nAverage CC: %.2f\n",
                    totalCash / cashCount, totalCard / cardCount);
        }
    }
}