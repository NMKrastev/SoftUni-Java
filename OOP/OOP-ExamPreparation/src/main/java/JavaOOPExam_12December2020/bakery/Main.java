package JavaOOPExam_12December2020.bakery;

import JavaOOPExam_12December2020.bakery.repositories.DrinkRepositoryImpl;
import JavaOOPExam_12December2020.bakery.repositories.FoodRepositoryImpl;
import JavaOOPExam_12December2020.bakery.repositories.TableRepositoryImpl;
import JavaOOPExam_12December2020.bakery.core.ControllerImpl;
import JavaOOPExam_12December2020.bakery.core.EngineImpl;
import JavaOOPExam_12December2020.bakery.core.interfaces.Controller;
import JavaOOPExam_12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import JavaOOPExam_12December2020.bakery.entities.drinks.interfaces.Drink;
import JavaOOPExam_12December2020.bakery.entities.tables.interfaces.Table;

import JavaOOPExam_12December2020.bakery.io.ConsoleReader;
import JavaOOPExam_12December2020.bakery.io.ConsoleWriter;
import JavaOOPExam_12December2020.bakery.repositories.interfaces.DrinkRepository;
import JavaOOPExam_12December2020.bakery.repositories.interfaces.FoodRepository;
import JavaOOPExam_12December2020.bakery.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
