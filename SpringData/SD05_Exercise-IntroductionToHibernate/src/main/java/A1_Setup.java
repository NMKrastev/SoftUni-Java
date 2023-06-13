import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class A1_Setup {
    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        final EntityManager manager = factory.createEntityManager();

        factory.close();
    }
}