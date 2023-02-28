package A1_Vehicles;

import java.text.DecimalFormat;

import static A1_Vehicles.FuelModifier.TRUCK_AC_ADDITIONAL_CONSUMPTION;
import static A1_Vehicles.FuelModifier.TRUCK_TANK_FUEL_DEDUCTION;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (getLitersPerKm() + TRUCK_AC_ADDITIONAL_CONSUMPTION.getFuelModifier()) > getFuelQuantity()) {
            System.out.println("Truck needs refueling");
        } else {
            setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + TRUCK_AC_ADDITIONAL_CONSUMPTION.getFuelModifier())));
            System.out.printf("Truck travelled %s km\n", df.format(distance));
        }

    }

    @Override
    public void refuel(double fuel) {
        setFuelQuantity(getFuelQuantity() + (fuel * TRUCK_TANK_FUEL_DEDUCTION.getFuelModifier()));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
