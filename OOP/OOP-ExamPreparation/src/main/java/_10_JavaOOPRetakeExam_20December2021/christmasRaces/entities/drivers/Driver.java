package _10_JavaOOPRetakeExam_20December2021.christmasRaces.entities.drivers;

import _10_JavaOOPRetakeExam_20December2021.christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
