package A1_Vehicles;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double litersPerKm;

    public VehicleImpl(double fuelQuantity, double litersPerKm) {
        setFuelQuantity(fuelQuantity);
        setLitersPerKm(litersPerKm);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getLitersPerKm() {
        return litersPerKm;
    }

    protected void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }
}
