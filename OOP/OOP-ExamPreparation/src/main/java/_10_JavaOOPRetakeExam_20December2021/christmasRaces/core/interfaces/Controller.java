package _10_JavaOOPRetakeExam_20December2021.christmasRaces.core.interfaces;

public interface Controller {
    String createDriver(String driver);

    String createCar(String type, String model, int horsePower);

    String addCarToDriver(String driverName, String carModel);

    String addDriverToRace(String raceName, String driverName);

    String startRace(String raceName);

    String createRace(String name, int laps);
}
