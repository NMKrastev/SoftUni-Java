import entities.Address;
import entities.Employee;
import entities.Town;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class A13_RemoveTowns {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String SELECT_TOWN_WITH_NAME =
            "SELECT t FROM Town AS t WHERE t.name = ?1";
    private static final String SELECT_FROM_ADDRESSES_BY_TOWN_ID =
            "SELECT a FROM Address AS a WHERE a.town.id = ?1";
    private static final String SELECT_EMPLOYEES_WITH_ADDRESS_FROM_TOWN_ID =
            "SELECT e FROM Employee AS e WHERE e.address.town.id = ?1";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        System.out.print("Enter town name: ");
        String townName = scanner.nextLine();

        Town town;

        try {
            town = manager.createQuery(SELECT_TOWN_WITH_NAME, Town.class)
                    .setParameter(1, townName)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.printf("Town with name %s does not exist", townName);
            return;
        }

        List<Address> addressList =
                manager.createQuery(SELECT_FROM_ADDRESSES_BY_TOWN_ID, Address.class)
                        .setParameter(1, town.getId())
                        .getResultList();

        removeEmployeeAddress(manager, town);

        manager.getTransaction().begin();

        addressList.forEach(manager::remove);
        manager.remove(town);

        manager.getTransaction().commit();

        if (addressList.size() != 0) {

            if (addressList.size() < 2) {
                System.out.printf("%d address in %s deleted\n", addressList.size(), townName);
            } else {
                System.out.printf("%d addresses in %s deleted\n", addressList.size(), townName);
            }

        } else {
            System.out.printf("There is no town with name %s\n", townName);
        }

        manager.close();
        factory.close();
    }

    private static void removeEmployeeAddress(EntityManager manager, Town town) {

        manager.getTransaction().begin();

        List<Employee> employeeList = manager.createQuery(SELECT_EMPLOYEES_WITH_ADDRESS_FROM_TOWN_ID, Employee.class)
                .setParameter(1, town.getId())
                .getResultList();

        for (Employee employee : employeeList) {
            employee.setAddress(null);
            manager.persist(employee);
        }

        manager.getTransaction().commit();
    }
}
