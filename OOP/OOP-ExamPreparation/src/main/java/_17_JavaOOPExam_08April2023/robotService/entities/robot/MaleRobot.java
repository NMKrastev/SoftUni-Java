package _17_JavaOOPExam_08April2023.robotService.entities.robot;

public class MaleRobot extends BaseRobot {

    private static final int kilograms = 9;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, kilograms, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 3);
    }
}
