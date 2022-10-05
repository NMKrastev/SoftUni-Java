import java.util.Scanner;

public class A1_DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int day = Integer.parseInt(scanner.nextLine());

        switch (day) {
            case 1:
                System.out.println(daysOfWeek[0]);
                break;
            case 2:
                System.out.println(daysOfWeek[1]);
                break;
            case 3:
                System.out.println(daysOfWeek[2]);
                break;
            case 4:
                System.out.println(daysOfWeek[3]);
                break;
            case 5:
                System.out.println(daysOfWeek[4]);
                break;
            case 6:
                System.out.println(daysOfWeek[5]);
                break;
            case 7:
                System.out.println(daysOfWeek[6]);
                break;
            default:
                System.out.println("Invalid day!");
                break;
        }
    }
}
/*Enter a day number and print the day name (in English)
or "Invalid day!". Use an array of strings*/