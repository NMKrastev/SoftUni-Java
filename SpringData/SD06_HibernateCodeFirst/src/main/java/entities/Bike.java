package entities;

import java.math.BigDecimal;

public class Bike extends Vehicle {

    public Bike(String type, String model, BigDecimal price, String fuelType) {
        super(type, model, price, fuelType);
    }
}
