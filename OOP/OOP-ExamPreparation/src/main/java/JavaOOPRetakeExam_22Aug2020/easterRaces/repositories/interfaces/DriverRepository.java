package JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces;

import JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {

    private Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return drivers.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver model) {
        drivers.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return drivers.remove(model);
    }
}
