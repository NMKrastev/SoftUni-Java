import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourOfExam = Integer.parseInt(scanner.nextLine());
        int minutesOfExam = Integer.parseInt(scanner.nextLine());
        int hourOfArrival = Integer.parseInt(scanner.nextLine());
        int minutesOfArrival = Integer.parseInt(scanner.nextLine());
        int examAllMinutes = (hourOfExam * 60) + minutesOfExam;
        int arrivalAllMinutes = (hourOfArrival * 60) + minutesOfArrival;
        int diff = Math.abs(examAllMinutes - arrivalAllMinutes);
        int diffHour = diff / 60;
        int diffMin = diff % 60;

        if (examAllMinutes < arrivalAllMinutes) {
            System.out.println("Late");
            if (diffHour == 0) {
                System.out.printf("%d minutes after the start", diff);
            } else {
                System.out.printf("%d:%02d hours after the start", diffHour, diffMin);
            }
        } else if (examAllMinutes == arrivalAllMinutes || diff <= 30) {
            System.out.println("On time");
            if (diff != 0) {
                System.out.printf("%d minutes before the start", diffMin);
            }
        } else {
            if (diffHour == 0) {
                System.out.printf("Early\n" +
                        "%d minutes before the start", diffMin);
            } else {
                System.out.printf("Early\n" +
                        "%d:%02d hours before the start", diffHour, diffMin);
            }
        }
    }
}
