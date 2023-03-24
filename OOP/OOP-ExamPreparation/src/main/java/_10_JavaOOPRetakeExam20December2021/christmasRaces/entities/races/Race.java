package _10_JavaOOPRetakeExam20December2021.christmasRaces.entities.races;

import _10_JavaOOPRetakeExam20December2021.christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
