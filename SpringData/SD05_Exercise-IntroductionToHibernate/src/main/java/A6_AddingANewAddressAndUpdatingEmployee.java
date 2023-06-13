import entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class A6_AddingANewAddressAndUpdatingEmployee {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String SET_ADDRESS_TO_EMPLOYEE_WITH_LAST_NAME =
            "UPDATE Employee AS e SET e.address = (SELECT a.id FROM Address AS a WHERE a.text = 'Vitoshka 15') WHERE e.lastName = ?1";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");
        manager.persist(address);

        System.out.print("Please, enter last name: ");
        final String lastName = scanner.nextLine();

        manager.createQuery(SET_ADDRESS_TO_EMPLOYEE_WITH_LAST_NAME)
                .setParameter(1, lastName).executeUpdate();

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
