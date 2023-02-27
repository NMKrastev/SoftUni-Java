package A1_Vehicles;

import java.text.DecimalFormat;

import static A1_Vehicles.FuelModifier.CAR;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (getLitersPerKm() + CAR.getModifier()) > getFuelQuantity()) {
            System.out.println("Car needs refueling");
        } else {
            setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + CAR.getModifier())));
            System.out.printf("Car travelled %s km\n", df.format(distance));
        }
    }

    @Override
    public void refuel(double fuel) {
        setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
