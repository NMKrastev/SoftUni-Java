package solid.products.drinks;

public class Coke extends Drink {

    private static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }
}
