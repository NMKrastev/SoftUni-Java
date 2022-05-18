import java.util.Scanner;

public class Volleyball {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine().toLowerCase();
        int holidays = Integer.parseInt(scanner.nextLine());
        int weekendsHome = Integer.parseInt(scanner.nextLine());
        double sofiaWeekends = ((48 - weekendsHome) * (3.0 / 4.0));
        double playHolydays = holidays * (2.0 / 3.0);
        double playedDays = sofiaWeekends + playHolydays + weekendsHome;

        if ("leap".equals(year)) {
            playHolydays = playedDays + playedDays * 0.15;
            System.out.printf("%.2f", Math.floor(playHolydays));
        } else if ("normal".equals(year)) {
            System.out.printf("%.2f", Math.floor(playedDays));
        }
    }
}