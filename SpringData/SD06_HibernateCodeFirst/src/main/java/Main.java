import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "vehicle";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();


        manager.close();
        factory.close();
    }
}