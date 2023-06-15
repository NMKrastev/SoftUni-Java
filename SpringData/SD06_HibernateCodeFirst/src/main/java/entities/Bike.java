package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name = "bikes")
public class Bike extends Vehicle {

    private static final String BIKE_TYPE = "Bike";

    public Bike() {
        super(BIKE_TYPE);
    }

    public Bike(String model) {
        this();
        this.model = model;
    }

}
