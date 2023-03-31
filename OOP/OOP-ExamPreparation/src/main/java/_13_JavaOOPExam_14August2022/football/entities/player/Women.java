package _13_JavaOOPExam_14August2022.football.entities.player;

public class Women extends BasePlayer {

    private static final double KG = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        super.setStrength(super.getStrength() + 115);
    }
}
