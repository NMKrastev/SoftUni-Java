import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine()) + 15;

        if (minutes > 59) {
            minutes -= 60;
            hours++;
        }
        if (hours == 24) {
            hours = 0;
        }
        if (minutes < 10) {
            System.out.println(hours + ":0" + minutes);
        } else {
            System.out.println(hours + ":" + minutes);
        }
    }
}
