package _02_JavaOOPRetakeExam_22Aug2020.easterRaces;

import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.core.ControllerImpl;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.io.ConsoleWriter;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.DriverRepository;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.RaceRepository;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.core.EngineImpl;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.core.interfaces.Controller;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.Car;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers.Driver;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.racers.Race;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.io.ConsoleReader;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.CarRepository;
import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository<Car> motorcycleRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> riderRepository = new DriverRepository();

        Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
