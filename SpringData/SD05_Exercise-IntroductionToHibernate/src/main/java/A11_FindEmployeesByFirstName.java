import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class A11_FindEmployeesByFirstName {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String GET_EMPLOYEES_WITH_PATTERN_INPUT =
            "FROM Employee AS e WHERE e.firstName LIKE CONCAT(?1, '%')";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        System.out.print("Enter an input: ");
        String input = scanner.nextLine();

        List<Employee> employeeList =
                manager.createQuery(GET_EMPLOYEES_WITH_PATTERN_INPUT, Employee.class)
                        .setParameter(1, input)
                        .getResultList();

        employeeList
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)\n",
                        e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));

        manager.close();
        factory.close();
    }
}
