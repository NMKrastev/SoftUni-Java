package EP6_JavaAdvancedExam20February2021.A3_CarDealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model));
    }

    public Car getLatestCar() {
        return data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        return String.format("The cars are in a car dealership %s:\n%s", name, data.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
