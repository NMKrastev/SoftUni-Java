package JavaOOPRetakeExam_22Aug2020.easterRaces;

import JavaOOPRetakeExam_22Aug2020.easterRaces.core.ControllerImpl;
import JavaOOPRetakeExam_22Aug2020.easterRaces.io.ConsoleWriter;
import JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.DriverRepository;
import JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.RaceRepository;
import JavaOOPRetakeExam_22Aug2020.easterRaces.core.EngineImpl;
import JavaOOPRetakeExam_22Aug2020.easterRaces.core.interfaces.Controller;
import JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars.Car;
import JavaOOPRetakeExam_22Aug2020.easterRaces.entities.drivers.Driver;
import JavaOOPRetakeExam_22Aug2020.easterRaces.entities.racers.Race;
import JavaOOPRetakeExam_22Aug2020.easterRaces.io.ConsoleReader;
import JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.CarRepository;
import JavaOOPRetakeExam_22Aug2020.easterRaces.repositories.interfaces.Repository;

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
