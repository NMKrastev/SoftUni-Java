package A4_HotelReservation;

public class PriceCalculator {

    public static double calculateHolidayPrice(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        double priceForAllDays = pricePerDay * numberOfDays;
        priceForAllDays *= season.getMultiplyCoefficient();
        priceForAllDays -= (priceForAllDays * discountType.getPercent());
        return priceForAllDays;
    }
}
