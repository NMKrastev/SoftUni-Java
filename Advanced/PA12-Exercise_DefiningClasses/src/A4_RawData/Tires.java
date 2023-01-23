package A4_RawData;

public class Tires {

    private double tirePressure;
    private int tireAge;

    public Tires(double tyrePressure, int tyreAge) {
        this.tirePressure = tyrePressure;
        this.tireAge = tyreAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public int getTireAge() {
        return tireAge;
    }

    public void setTireAge(int tireAge) {
        this.tireAge = tireAge;
    }
}
