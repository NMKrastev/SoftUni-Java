import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class A3_ContainsEmployee {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String SELECT_IF_NAME_EXISTS_IN_DB =
            "SELECT COUNT(e) FROM Employee AS e WHERE CONCAT(e.firstName, ' ', e.lastName) = ?1";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        System.out.print("Please, enter a name: ");
        final String fullName = scanner.nextLine();

        final long count = manager.createQuery(SELECT_IF_NAME_EXISTS_IN_DB, Long.class)
                .setParameter(1, fullName)
                .getSingleResult();

        System.out.println(count == 0 ? "No" : "Yes");

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
