package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name = "trucks")
public class Truck extends TransportationVehicle {

    private static final String TRUCK_TYPE = "Truck";

    public Truck() {
        super(TRUCK_TYPE);
    }

    public Truck(String model, String fuelType, Double loadCapacity) {
        this();
        this.model = model;
        this.fuelType = fuelType;
        this.loadCapacity = loadCapacity;
    }

}
