import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class A1_Setup {
    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        final EntityManager manager = factory.createEntityManager();

        manager.close();
        factory.close();
    }
}