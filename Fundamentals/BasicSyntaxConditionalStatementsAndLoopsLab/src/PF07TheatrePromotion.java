import java.util.Scanner;

public class PF07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (age < 0 || age > 122) {
            System.out.println("Error!");
        } else {
            switch (day) {
                case "Weekday":
                    if (age <= 18) {
                        price = 12;
                    } else if (age <= 64) {
                        price = 18;
                    } else {
                        price = 12;
                    }
                    break;
                case "Weekend":
                    if (age <= 18) {
                        price = 15;
                    } else if (age <= 64) {
                        price = 20;
                    } else {
                        price = 15;
                    }
                    break;
                case "Holiday":
                    if (age <= 18) {
                        price = 5;
                    } else if (age <= 64) {
                        price = 12;
                    } else {
                        price = 10;
                    }
                    break;
            }
            System.out.printf("%d$", price);
        }
    }
}
/*A theatre is doing a ticket sale, but they need a program to calculate the price of a single ticket.
If the given age does not fit one of the categories, you should print "Error!".  You can see the prices in
the table below:
                Day / Age	0 <= age <= 18	18 < age <= 64	64 < age <= 122
Weekday	                        12$	            18$	            12$
Weekend	                        15$         	20$	            15$
Holiday	                        5$	            12$	            10$
Input
The input comes in two lines. On the first line, you will receive the type of day. On the second – the age of the person.
Output
Print the price of the ticket according to the table, or "Error!" if the age is not in the table.
Constraints
•	The age will be in the interval [-1000…1000].
•	The type of day will always be valid.
*/