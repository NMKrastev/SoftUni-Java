import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class A12_EmployeesMaximumSalaries {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String GET_DEPARTMENTS_WITH_MAX_SALARY_NOT_IN_RANGE =
            "SELECT d.name, MAX(e.salary) FROM Department AS d JOIN d.employees AS e GROUP BY d.id HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        final List<Object[]> departmentList =
                manager.createQuery(GET_DEPARTMENTS_WITH_MAX_SALARY_NOT_IN_RANGE, Object[].class).getResultList();

        for (Object[] departments : departmentList) {
            System.out.printf("%s  %.2f\n", departments[0], (BigDecimal) departments[1]);
        }

        /*departmentList
                .forEach(e -> System.out.printf("%s  %.2f\n", e[0], (BigDecimal) e[1]));*/

        manager.close();
        factory.close();
    }
}
