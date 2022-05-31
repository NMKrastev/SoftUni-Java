import java.util.Scanner;

public class PF03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double totalPrice = 0, singlePrice = 0;

        if (groupType.equals("Students")) {
            switch (dayOfWeek) {
                case "Friday":
                   singlePrice = 8.45;
                    break;
                case "Saturday":
                    singlePrice = 9.80;
                    break;
                case "Sunday":
                    singlePrice = 10.46;
                    break;
            }
        } else if (groupType.equals("Business")) {
            switch (dayOfWeek) {
                case "Friday":
                    singlePrice = 10.90;
                    break;
                case "Saturday":
                    singlePrice = 15.60;
                    break;
                case "Sunday":
                    singlePrice = 16;
                    break;
            }
        } else if (groupType.equals("Regular")) {
            switch (dayOfWeek) {
                case "Friday":
                    singlePrice = 15;
                    break;
                case "Saturday":
                    singlePrice = 20;
                    break;
                case "Sunday":
                    singlePrice = 22.50;
                    break;
            }
        }

        totalPrice = people * singlePrice;

        if (groupType.equals("Students") && people >= 30) {
            totalPrice *= 0.85;
        }
        if (groupType.equals("Business") && people >= 100) {
            totalPrice = (people - 10) * singlePrice;
        }
        if (groupType.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice *= 0.95;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
/*You are given a group of people, type of the group, on which day of the week they are going to stay.
Based on that information calculate how much they have to pay and print that price on the console.
Use the table below. In each cell is the price for a single person. The output should look like that:
"Total price: {price}". The price should be formatted to the second decimal point.
	            Friday	    Saturday	Sunday
Students	    8.45    	9.80	    10.46
Business	    10.90	    15.60   	16
Regular	        15      	20      	22.50
There are also discounts based on some conditions:
•	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
•	Business – if the group is bigger than or equal to 100 people 10 of them can stay for free.
•	Regular – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the total price by 5%
You should reduce the prices in that EXACT order.
*/