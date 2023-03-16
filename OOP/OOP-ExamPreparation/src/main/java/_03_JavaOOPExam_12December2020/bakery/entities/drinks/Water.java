package _03_JavaOOPExam_12December2020.bakery.entities.drinks;

public class Water extends BaseDrink {

    private static final double waterPrice = 1.50;

    public Water(String name, int portion, String brand) {
        super(name, portion, waterPrice, brand);
    }
}
