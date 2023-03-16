package _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers;

import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.common.ExceptionMessages;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.Car;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.car = null;
        numberOfWins = 0;
        canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    private void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_INVALID));
        }
        setCar(car);
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return car != null;
    }
}
