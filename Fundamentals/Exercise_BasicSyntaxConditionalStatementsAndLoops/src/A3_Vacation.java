import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class A3_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String typeOfDay = scanner.nextLine();
        double totalPrice = 0, singlePrice = 0;

        if (typeOfGroup.equals("Students")) {
            switch (typeOfDay) {
                case "Friday":
                    singlePrice = 8.45;
                    break;
                case "Saturday":
                    singlePrice = 9.80;
                    break;
                case "Sunday":
                    singlePrice = 10.46;
            }
        } else if (typeOfGroup.equals("Business")) {
            switch (typeOfDay) {
                case "Friday":
                    singlePrice = 10.90;
                    break;
                case "Saturday":
                    singlePrice = 15.60;
                    break;
                case "Sunday":
                    singlePrice = 16;
            }
        } else if (typeOfGroup.equals("Regular")) {
            switch (typeOfDay) {
                case "Friday":
                    singlePrice = 15;
                    break;
                case "Saturday":
                    singlePrice = 20;
                    break;
                case "Sunday":
                    singlePrice = 22.50;
            }
        }

        totalPrice = numberOfPeople * singlePrice;

        if (typeOfGroup.equals("Students") && numberOfPeople >= 30) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (typeOfGroup.equals("Business") && numberOfPeople >= 100) {
            totalPrice = totalPrice - (singlePrice * 10);
        } else if (typeOfGroup.equals("Regular") && numberOfPeople >= 10
        && numberOfPeople <= 20) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
/*You are given a group of people, type of the group, on which day
of the week they will stay. Based on that information, calculate
how much they must pay and print that price on the console. Use the
table below. In each cell is the price for a single person. The
output should look like that: "Total price: {price}".
The price should be formatted to the second decimal point
There are also discounts based on some conditions:
· Students – if the group is bigger than or equal to 30 people, you should reduce the total price by 15%
· Business – if the group is bigger than or equal to 100 people 10 of them can stay for free.
· Regular – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the total price by 5%*/