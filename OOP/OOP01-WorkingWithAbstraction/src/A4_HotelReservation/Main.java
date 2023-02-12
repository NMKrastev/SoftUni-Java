package A4_HotelReservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(input[3].toUpperCase());
        double holidayPrice = PriceCalculator.calculateHolidayPrice(pricePerDay, days, season, discountType);
        System.out.printf("%.2f", holidayPrice);

    }
}
/*Create a class PriceCalculator that calculates the total price of a holiday, given the price per day,
number of days, the season, and a discount type. The discount type and season should be an enum.
Use the class in your main() method to read input and print on the console the price of the whole holiday.
The price per day will be multiplied depending on the season by:
•	1 during Autumn
•	2 during Spring
•	3 during Winter
•	4 during Summer
The discount is applied to the total price and is one of the following:
•	20% for VIP clients - VIP
•	10% for clients, visiting for a second time - SecondVisit
•	0% if there is no discount - None
Input
On a single line you will receive all the information about the reservation in the format:
"{pricePerDay} {numberOfDays} {season} {discountType}", where:
•	The price per day will be a valid decimal in the range [0.01…1000.00].
•	The number of days will be a valid integer in the range [1…1000].
•	The season will be one of Spring, Summer, Autumn, Winter.
•	The discount will be one of VIP, SecondVisit, None.
Output
On a single line, print the total price of the holiday, rounded to 2 digits after the decimal separator.
*/
