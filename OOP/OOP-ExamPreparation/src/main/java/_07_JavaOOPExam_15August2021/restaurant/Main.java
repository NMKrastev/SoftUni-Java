package _07_JavaOOPExam_15August2021.restaurant;

import _07_JavaOOPExam_15August2021.restaurant.entities.drinks.interfaces.Beverages;
import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _07_JavaOOPExam_15August2021.restaurant.core.ControllerImpl;
import _07_JavaOOPExam_15August2021.restaurant.core.EngineImpl;
import _07_JavaOOPExam_15August2021.restaurant.core.interfaces.Controller;
import _07_JavaOOPExam_15August2021.restaurant.entities.tables.interfaces.Table;

import _07_JavaOOPExam_15August2021.restaurant.io.ConsoleReader;
import _07_JavaOOPExam_15August2021.restaurant.io.ConsoleWriter;
import _07_JavaOOPExam_15August2021.restaurant.repositories.BeverageRepositoryImpl;
import _07_JavaOOPExam_15August2021.restaurant.repositories.HealthFoodRepositoryImpl;
import _07_JavaOOPExam_15August2021.restaurant.repositories.TableRepositoryImpl;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.BeverageRepository;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.HealthFoodRepository;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {
        // TODO: Optional - Create new instances for all repositories to test your code locally.

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
