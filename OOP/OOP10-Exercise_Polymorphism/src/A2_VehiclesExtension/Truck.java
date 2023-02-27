package A2_VehiclesExtension;

import java.text.DecimalFormat;

import static A2_VehiclesExtension.FuelModifier.TRUCK;
import static A2_VehiclesExtension.FuelModifier.TRUCK_FUEL;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (getLitersPerKm() + TRUCK.getModifier()) > getFuelQuantity()) {
            throw new IllegalArgumentException("Truck needs refueling");
        } else {
            setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + TRUCK.getModifier())));
            System.out.printf("Truck travelled %s km\n", df.format(distance));
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

        setFuelQuantity(getFuelQuantity() + (fuel * TRUCK_FUEL.getModifier()));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
