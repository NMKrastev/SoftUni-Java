import entities.*;
import hasEtities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "relations";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        /*Vehicle car = new Car("Nissan Skyline R34-GTR", "Petrol", 4);
        Vehicle bike = new Bike("Ducati Panigale 1200");
        Vehicle plane = new Plane("Airbus", "Aviation fuel", 250);
        Vehicle truck = new Truck("Mercedes Truck", "Diesel", 20000.00);

        manager.persist(car);
        manager.persist(bike);
        manager.persist(plane);
        manager.persist(truck);

//----------------------------------------------------------------------------------------------------------------------
        PlateNumber number = new PlateNumber("СА0205СА");

        HasCar car2 = new HasCar(number);
        //HasCar car3 = new HasCar(number);

        manager.persist(number);
        manager.persist(car2);
        //It will cause an exception error due to trying to add same plate number to another car
        //manager.persist(car3);*/

//----------------------------------------------------------------------------------------------------------------------
        Article article = new Article("Test1");
        User author = new User("Peter");
        Category fantasy = new Category("Fantasy");
        Category adventure = new Category("Adventure");

        author.addArticle(article);

        manager.persist(author);
        manager.persist(fantasy);
        manager.persist(adventure);
        article.setAuthor(author);
        article.setCategories(fantasy);
        article.setCategories(adventure);

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}