package EP3_JavaAdvancedExam28June2020.A3_Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car latestYearCar = null;
        int currentYear = 0;
        for (Car car : data) {
            if (car.getYear() > currentYear) {
                currentYear = car.getYear();
                latestYearCar = car;
            }
        }
        return latestYearCar;
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
        return String.format("The cars are parked in %s:\n%s", type, data.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
