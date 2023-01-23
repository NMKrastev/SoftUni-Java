package A4_RawData;

public class Cargo {

    private double cargoWeight;
    private String cargoType;

    public Cargo(double cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
