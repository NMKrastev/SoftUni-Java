package _05_JavaOOPExam_10April2021.aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {

    private static final int CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}
