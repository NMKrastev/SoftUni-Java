import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysGone = Integer.parseInt(scanner.nextLine());
        int foodForDaysGone = Integer.parseInt(scanner.nextLine());
        double dogFoodKgPerDay = Double.parseDouble(scanner.nextLine());
        double catFoodKgPerDay = Double.parseDouble(scanner.nextLine());
        double turtFoodGrPerDay = Double.parseDouble(scanner.nextLine()) / 1000;
        double totalFood = (dogFoodKgPerDay + catFoodKgPerDay + turtFoodGrPerDay) * daysGone;

        if (totalFood <= foodForDaysGone) {
            System.out.printf("%.0f kilos of food left.",
                    foodForDaysGone - Math.ceil(totalFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.",
                    Math.ceil(totalFood - foodForDaysGone));
        }

    }
}