import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class A5_EmployeesFromDepartment {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String SELECT_ALL_EMPLOYEES_FROM_RESEARCH_AND_DEVELOPMENT =
            "FROM Employee AS e JOIN e.department AS d WHERE d.name = 'Research and Development' ORDER BY e.salary, e.id";

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager manager = factory.createEntityManager();

        List<Employee> employeesList =
                manager.createQuery(SELECT_ALL_EMPLOYEES_FROM_RESEARCH_AND_DEVELOPMENT, Employee.class).getResultList();

        employeesList
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f\n",
                        e.getFirstName(), e.getLastName(), e.getDepartment(), e.getSalary()));

        manager.close();
        factory.close();
    }
}
