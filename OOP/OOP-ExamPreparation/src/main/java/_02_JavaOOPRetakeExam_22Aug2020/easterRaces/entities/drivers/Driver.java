package _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers;

import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
