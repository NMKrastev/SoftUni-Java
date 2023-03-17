package _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food {

    private static final double InitialVeganBiscuitsPortion = 205;

    public VeganBiscuits(String name, double price) {
        super(name, InitialVeganBiscuitsPortion, price);
    }
}
