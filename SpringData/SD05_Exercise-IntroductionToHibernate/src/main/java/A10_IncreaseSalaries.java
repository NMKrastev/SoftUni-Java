import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class A10_IncreaseSalaries {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String GET_EMPLOYEES_WITH_RAISED_SALARIES =
            "SELECT e FROM Employee AS e WHERE e.department.id IN (?1)";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        getEmployees(manager).forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        manager.getTransaction().commit();

        final List<Employee> employeeList = getEmployees(manager);

        employeeList
                .forEach(e -> System.out.printf("%s %s ($%.2f)\n", e.getFirstName(), e.getLastName(), e.getSalary()));

        manager.close();
        factory.close();
    }

    private static List<Employee> getEmployees(EntityManager manager) {

        return manager.createQuery(GET_EMPLOYEES_WITH_RAISED_SALARIES, Employee.class)
                .setParameter(1, Arrays.asList(1, 2, 4, 11))
                .getResultList();
    }
}
