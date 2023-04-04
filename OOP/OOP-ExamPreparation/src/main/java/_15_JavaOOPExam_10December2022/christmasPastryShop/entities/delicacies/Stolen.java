package _15_JavaOOPExam_10December2022.christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy {

    private static final double InitialStolenPortion = 250;

    public Stolen(String name, double price) {
        super(name, InitialStolenPortion, price);
    }
}
