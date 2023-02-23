package A5_Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private final static BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private final static double COFFEE_MILLILITERS = 50;
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        setCaffeine(caffeine);
    }

    public double getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
