import java.util.Scanner;

public class FuelTankPt2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fuelType = scanner.nextLine();
        int liters = Integer.parseInt(scanner.nextLine());
        String clubCard = scanner.nextLine();

        double fuelPrice = 0;
        switch (fuelType) {
            case "Gas":
                fuelPrice = clubCard.equals("Yes") ? 0.93 - 0.08 : 0.93;
                break;
            case "Gasoline":
                fuelPrice = clubCard.equals("Yes") ? 2.22 - 0.18 : 2.22;
                break;
            case "Diesel":
                fuelPrice = clubCard.equals("Yes") ? 2.33 - 0.12 : 2.33;
                break;
        }

        if (liters > 25) {
            fuelPrice *= 0.9;
        } else if (liters >= 20) {
            fuelPrice *= 0.92;
        }

        double result = liters * fuelPrice;
        System.out.printf("%.2f lv.", result);
    }
}