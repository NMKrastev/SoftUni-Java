package _03_JavaOOPExam_12December2020.bakery;

import _03_JavaOOPExam_12December2020.bakery.repositories.DrinkRepositoryImpl;
import _03_JavaOOPExam_12December2020.bakery.repositories.FoodRepositoryImpl;
import _03_JavaOOPExam_12December2020.bakery.repositories.TableRepositoryImpl;
import _03_JavaOOPExam_12December2020.bakery.core.ControllerImpl;
import _03_JavaOOPExam_12December2020.bakery.core.EngineImpl;
import _03_JavaOOPExam_12December2020.bakery.core.interfaces.Controller;
import _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import _03_JavaOOPExam_12December2020.bakery.entities.drinks.interfaces.Drink;
import _03_JavaOOPExam_12December2020.bakery.entities.tables.interfaces.Table;

import _03_JavaOOPExam_12December2020.bakery.io.ConsoleReader;
import _03_JavaOOPExam_12December2020.bakery.io.ConsoleWriter;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.DrinkRepository;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.FoodRepository;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.TableRepository;

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
