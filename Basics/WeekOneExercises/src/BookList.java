import java.util.Scanner;

public class BookList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pages = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysNeeded = Integer.parseInt(scanner.nextLine());
        int hoursNeededPerDay = pages / pagesPerHour / daysNeeded;

        System.out.println(hoursNeededPerDay);

    }
}
