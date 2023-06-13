import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class A7_AddressesWithEmployeeCount {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String SELECT_COUNT_OF_EMPLOYEES_ON_AN_ADDRESS =
            "SELECT a.text, COUNT(*) AS peopleCount FROM Address AS a JOIN a.employees AS e GROUP BY a.text ORDER BY peopleCount DESC";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        final List<Object[]> addressList = manager.createQuery(SELECT_COUNT_OF_EMPLOYEES_ON_AN_ADDRESS, Object[].class).setMaxResults(10).getResultList();

        Map<String, Long> employeesCountOnAddress = new LinkedHashMap<>();

        for (Object[] entity : addressList) {
            employeesCountOnAddress.put((String) entity[0], (Long) entity[1]);
        }

        employeesCountOnAddress
                .forEach((key, value) -> System.out.printf("%s - %d employees\n", key, value));

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
