package A2_VehiclesExtension;

import java.text.DecimalFormat;

import static A2_VehiclesExtension.FuelModifier.CAR;


public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (getLitersPerKm() + CAR.getModifier()) > getFuelQuantity()) {
            throw new IllegalArgumentException("Car needs refueling");
        } else {
            setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + CAR.getModifier())));
            System.out.printf("Car travelled %s km\n", df.format(distance));
        }
    }

    @Override
    public void refuel(double fuel) {

        if (fuel < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (getFuelQuantity() + fuel > getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
