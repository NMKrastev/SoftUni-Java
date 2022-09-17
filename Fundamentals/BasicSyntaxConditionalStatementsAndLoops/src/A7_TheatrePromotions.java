import java.util.Scanner;

public class A7_TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        if (age >= 0 && age <= 18) {
            switch (typeOfDay) {
                case "Weekday":
                    System.out.println("12$");
                    break;
                case "Weekend":
                    System.out.println("15$");
                    break;
                case "Holiday":
                    System.out.println("5$");
                    break;
            }
        } else if (age > 18 && age <= 64) {
            switch (typeOfDay) {
                case "Weekday":
                    System.out.println("18$");
                    break;
                case "Weekend":
                    System.out.println("20$");
                    break;
                case "Holiday":
                    System.out.println("12$");
                    break;
            }
        } else if (age > 64 && age <= 122) {
            switch (typeOfDay) {
                case "Weekday":
                    System.out.println("12$");
                    break;
                case "Weekend":
                    System.out.println("15$");
                    break;
                case "Holiday":
                    System.out.println("10$");
                    break;
            }
        } else {
            System.out.println("Error!");
        }
    }
}
/*A theatre is having a ticket sale, but they need a program to
calculate the price of a single ticket. If the given age does not
fit one of the categories, you should print "Error!".
You can see the prices in the table below:*/