import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class A4_EmployeesWithSalaryOver50000 {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String GET_ALL_EMPLOYEES_WITH_SALARY_OVER_50000 =
            "FROM Employee AS e WHERE e.salary > 50000";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        final List<Employee> employeeList = manager.createQuery(GET_ALL_EMPLOYEES_WITH_SALARY_OVER_50000, Employee.class)
                .getResultList();

        employeeList.forEach(e -> System.out.println(e.getFirstName()));

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
