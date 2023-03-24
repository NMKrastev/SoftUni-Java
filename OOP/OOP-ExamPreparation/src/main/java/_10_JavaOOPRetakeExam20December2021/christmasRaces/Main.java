package _10_JavaOOPRetakeExam20December2021.christmasRaces;

import _10_JavaOOPRetakeExam20December2021.christmasRaces.core.interfaces.Controller;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.entities.cars.Car;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.io.ConsoleReader;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.io.ConsoleWriter;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.core.ControllerImpl;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.core.EngineImpl;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.entities.drivers.Driver;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.entities.races.Race;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.repositories.CarRepository;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.repositories.DriverRepository;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.repositories.RaceRepository;
import _10_JavaOOPRetakeExam20December2021.christmasRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> driverRepository = new DriverRepository();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
