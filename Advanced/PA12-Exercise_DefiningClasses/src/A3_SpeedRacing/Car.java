package A3_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostForKm() {
        return fuelCostForKm;
    }

    public void setFuelCostForKm(double fuelCostForKm) {
        this.fuelCostForKm = fuelCostForKm;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void drive(int distance) {
        if (hasEnoughFuel(distance)) {
            this.fuelAmount -= calculateRequiredFuel(distance);
            this.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    private double calculateRequiredFuel(int distance) {
        return this.fuelCostForKm * distance;
    }

    private boolean hasEnoughFuel(int distance) {
        return fuelAmount >= calculateRequiredFuel(distance);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}
