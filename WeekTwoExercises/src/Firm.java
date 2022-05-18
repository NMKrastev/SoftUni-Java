import java.util.Scanner;

public class Firm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int daysAvailable = Integer.parseInt(scanner.nextLine());
        int employees = Integer.parseInt(scanner.nextLine());

        double workHours = daysAvailable * 0.9 * 8 * employees;
        double overtime = daysAvailable * 0.9 * 2 * employees;
        double totalHours = Math.floor(workHours + overtime);
        double hoursDifference = Math.abs(totalHours - hoursNeeded);

        if (hoursNeeded <= totalHours) {
            System.out.printf("Yes!%.0f hours left.", hoursDifference);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", hoursDifference);
        }
    }
}