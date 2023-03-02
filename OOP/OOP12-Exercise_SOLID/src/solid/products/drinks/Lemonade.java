package solid.products.drinks;

public class Lemonade extends Drink {

    private static final double CALORIES_PER_100_GRAMS = 53.0;
    private static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }
}
