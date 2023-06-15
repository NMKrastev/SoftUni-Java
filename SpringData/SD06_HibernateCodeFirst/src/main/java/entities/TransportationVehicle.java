package entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class TransportationVehicle extends Vehicle {

    @Column(name = "load_capacity")
    protected Double loadCapacity;

    protected TransportationVehicle() {}

    public TransportationVehicle(String type) {
        super(type);
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
