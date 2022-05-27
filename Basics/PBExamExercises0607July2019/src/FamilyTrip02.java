import java.util.Scanner;

public class FamilyTrip02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int percentForOther = Integer.parseInt(scanner.nextLine());
        double totalPriceForNights = 0;
        double otherExpenses = 0;
        double total = 0;
        double percent = percentForOther / 100.00;

        if (nights > 7) {
            pricePerNight = pricePerNight * 0.95;
        }

        totalPriceForNights = nights * pricePerNight;
        otherExpenses = budget * percent;
        total = totalPriceForNights + otherExpenses;

        if (budget >= total) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - total);
        } else {
            System.out.printf("%.2f leva needed.", total - budget);
        }
    }
}
