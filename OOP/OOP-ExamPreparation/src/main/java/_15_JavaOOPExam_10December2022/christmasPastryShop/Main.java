package _15_JavaOOPExam_10December2022.christmasPastryShop;

import _15_JavaOOPExam_10December2022.christmasPastryShop.core.ControllerImpl;
import _15_JavaOOPExam_10December2022.christmasPastryShop.core.EngineImpl;
import _15_JavaOOPExam_10December2022.christmasPastryShop.core.interfaces.Controller;
import _15_JavaOOPExam_10December2022.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import _15_JavaOOPExam_10December2022.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _15_JavaOOPExam_10December2022.christmasPastryShop.entities.booths.interfaces.Booth;
import _15_JavaOOPExam_10December2022.christmasPastryShop.io.ConsoleReader;
import _15_JavaOOPExam_10December2022.christmasPastryShop.io.ConsoleWriter;
import _15_JavaOOPExam_10December2022.christmasPastryShop.repositories.BoothRepositoryImpl;
import _15_JavaOOPExam_10December2022.christmasPastryShop.repositories.CocktailRepositoryImpl;
import _15_JavaOOPExam_10December2022.christmasPastryShop.repositories.DelicacyRepositoryImpl;
import _15_JavaOOPExam_10December2022.christmasPastryShop.repositories.interfaces.BoothRepository;
import _15_JavaOOPExam_10December2022.christmasPastryShop.repositories.interfaces.CocktailRepository;
import _15_JavaOOPExam_10December2022.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class Main {
    public static void main(String[] args) {

        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
