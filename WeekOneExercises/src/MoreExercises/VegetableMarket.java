package MoreExercises;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double vegetablePricePerKg = Double.parseDouble(scanner.nextLine());
        double fruitPricePerKg = Double.parseDouble(scanner.nextLine());
        int vegetableKg = Integer.parseInt(scanner.nextLine());
        int fruitKg = Integer.parseInt(scanner.nextLine());

        double totalPrice = (vegetableKg * vegetablePricePerKg + fruitKg * fruitPricePerKg) / 1.94;

        System.out.printf("%.2f", totalPrice);

    }
}
