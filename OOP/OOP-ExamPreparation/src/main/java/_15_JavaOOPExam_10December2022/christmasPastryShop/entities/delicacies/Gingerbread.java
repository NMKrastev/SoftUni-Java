package _15_JavaOOPExam_10December2022.christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy {

    private static final double InitialGingerbreadPortion = 200;

    public Gingerbread(String name, double price) {
        super(name, InitialGingerbreadPortion, price);
    }
}
