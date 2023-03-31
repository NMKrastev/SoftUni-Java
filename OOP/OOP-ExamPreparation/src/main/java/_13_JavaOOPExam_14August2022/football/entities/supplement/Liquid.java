package _13_JavaOOPExam_14August2022.football.entities.supplement;

public class Liquid extends BaseSupplement {

    private static final int ENERGY = 90;
    private static final double PRICE = 25;

    public Liquid() {
        super(ENERGY, PRICE);
    }
}
