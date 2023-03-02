package solid.products.foods;

public class Chips extends Food {

    private static final double CALORIES_PER_100_GRAMS = 529.00;

    public Chips(double grams) {
        super(grams, CALORIES_PER_100_GRAMS);
    }
}
