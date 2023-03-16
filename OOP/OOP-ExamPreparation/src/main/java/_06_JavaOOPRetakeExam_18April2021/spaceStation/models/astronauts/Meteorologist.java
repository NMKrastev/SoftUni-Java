package _06_JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {

    private static final double OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, OXYGEN);
    }
}
