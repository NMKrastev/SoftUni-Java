package JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces;

import JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {

    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return cars.stream()
                .filter(e -> e.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars);
    }

    @Override
    public void add(Car model) {
        cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return cars.remove(model);
    }
}
