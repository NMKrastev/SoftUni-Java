package _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static final double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        this.energy -= 7;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }
}
