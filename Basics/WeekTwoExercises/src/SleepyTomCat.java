import java.util.Scanner;

public class SleepyTomCat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int daysOff = Integer.parseInt(scanner.nextLine());
        int daysOfYear = 365;
        int wordDays = daysOfYear - daysOff;
        int totalPlayMinutes = (wordDays * 63) + (daysOff * 127);
        int difference = Math.abs(totalPlayMinutes - 30000);
        double hours = difference / 60;
        double minutes = difference % 60;

        if (totalPlayMinutes > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%.0f hours and %.0f minutes more for play",
                    Math.floor(hours), Math.floor(minutes));
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%.0f hours and %.0f minutes less for play",
                    Math.floor(hours), Math.floor(minutes));
        }
    }
}