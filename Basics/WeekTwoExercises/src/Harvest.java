import java.util.Scanner;

public class Harvest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int vineyardArea = Integer.parseInt(scanner.nextLine());
        double grapeKgPerSq = Double.parseDouble(scanner.nextLine());
        int litersNeeded = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double harvest = (vineyardArea * 0.4) * grapeKgPerSq;
        double wineLiters = harvest / 2.5;
        double wineLeft = Math.abs(wineLiters - litersNeeded);
        double litersPerWorker = wineLeft / workers;

        if (wineLiters >= litersNeeded) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",
                    Math.floor(wineLiters));
            System.out.printf("%.0f liters left -> %.0f liters per person.",
                    Math.ceil(wineLeft), Math.ceil(litersPerWorker));
        } else {
            System.out.printf("It will be a tough winter! " +
                    "More %.0f liters wine needed.",
                    Math.floor(wineLeft));
        }
    }
}