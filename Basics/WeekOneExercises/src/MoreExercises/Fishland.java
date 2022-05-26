package MoreExercises;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double mackerelPricePerKg = Double.parseDouble(scanner.nextLine());
        double spratPricePerKg = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double scadKg = Double.parseDouble(scanner.nextLine());
        double musselsKg = Double.parseDouble(scanner.nextLine()) * 7.50;

        double bonitoPrice = ((mackerelPricePerKg * 0.60) + mackerelPricePerKg) * bonitoKg;
        double scadPrice = ((spratPricePerKg * 0.80) + spratPricePerKg) * scadKg;
        double totalPrice = bonitoPrice + scadPrice + musselsKg;

        System.out.printf("%.2f", totalPrice);

    }
}
