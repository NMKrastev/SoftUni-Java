import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class A8_GetEmployeeWithProject {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String GET_EMPLOYEE_BY_ID =
            "SELECT e FROM Employee AS e WHERE e.id = ?1";
    private static final String GET_PROJECTS_BY_EMPLOYEE_ID =
            "SELECT p.name FROM Project AS p JOIN p.employees AS e WHERE e.id = ?1 ORDER BY p.name";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        System.out.print("Please, enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Employee employeeInfo;

        try {
            employeeInfo = manager.createQuery(GET_EMPLOYEE_BY_ID, Employee.class).setParameter(1, id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("There's no employee with ID: " + id);
            return;
        }

        final List<String> projectsForEmployee = manager.createQuery(GET_PROJECTS_BY_EMPLOYEE_ID, String.class).setParameter(1, id).getResultList();

        System.out.printf("%s %s - %s\n", employeeInfo.getFirstName(), employeeInfo.getLastName(), employeeInfo.getJobTitle());

        for (String project : projectsForEmployee) {
            System.out.printf("      %s\n", project);
        }

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
