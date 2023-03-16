package _02_JavaOOPRetakeExam_22Aug2020.easterRaces.core;

import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.core.interfaces.Controller;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.Car;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.MuscleCar;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.SportsCar;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers.Driver;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers.DriverImpl;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.racers.Race;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.racers.RaceImpl;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static _02_JavaOOPRetakeExam_22Aug2020.easterRaces.common.ExceptionMessages.*;
import static _02_JavaOOPRetakeExam_22Aug2020.easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Car> cars;
    private Repository<Driver> drivers;
    private Repository<Race> races;

    public ControllerImpl(Repository<Driver> drivers, Repository<Car> cars, Repository<Race> races) {
        this.cars = cars;
        this.drivers = drivers;
        this.races = races;
    }

    @Override
    public String createDriver(String driver) {

        Driver isPresent = drivers.getAll().stream()
                .filter(e -> e.getName().equals(driver))
                .findFirst()
                .orElse(null);

        if (isPresent != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        drivers.add(new DriverImpl(driver));

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        Car car = cars.getAll().stream()
                .filter(e -> e.getModel().equals(model))
                .findFirst()
                .orElse(null);

        if (car != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }

        cars.add(car);

        return String.format(CAR_CREATED, type, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = drivers.getAll().stream()
                .filter(e -> e.getName().equals(driverName))
                .findFirst()
                .orElse(null);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car car = cars.getAll().stream()
                .filter(e -> e.getModel().equals(carModel))
                .findFirst()
                .orElse(null);

        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = races.getAll().stream()
                .filter(e -> e.getName().equals(raceName))
                .findFirst()
                .orElse(null);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Driver driver = drivers.getAll().stream()
                .filter(e -> e.getName().equals(driverName))
                .findFirst()
                .orElse(null);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {

        Race race = races.getAll().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (race != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        races.add(new RaceImpl(name, laps));

        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {

        Race race = races.getAll().stream()
                .filter(e -> e.getName().equals(raceName))
                .findFirst()
                .orElse(null);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> driverList = race.getDrivers().stream().collect(Collectors.toList());
        Map<Driver, Double> driverCarMap = new LinkedHashMap<>();

        for (Driver driver : driverList) {
            driverCarMap.put(driver, driver.getCar().calculateRacePoints(race.getLaps()));
        }

        Map<Driver, Double> sorted = driverCarMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Driver firstPlace = null;
        Driver secondPlace = null;
        Driver thirdPlace = null;
        int index = 1;

        for (Map.Entry<Driver, Double> driverDoubleEntry : sorted.entrySet()) {
            if (index == 1) {
                firstPlace = driverDoubleEntry.getKey();
            }
            if (index == 2) {
                secondPlace = driverDoubleEntry.getKey();
            }
            if (index == 3) {
                thirdPlace = driverDoubleEntry.getKey();
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DRIVER_FIRST_POSITION, firstPlace.getName(), race.getName())).append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, secondPlace.getName(), race.getName())).append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, thirdPlace.getName(), race.getName())).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
