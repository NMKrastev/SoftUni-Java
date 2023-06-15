package A1_GringottsDatabase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "gringotts";
    private static final String LAST_NAME = "Johnson";
    private static final int AGE = 30;

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        WizardDeposit wizardDeposit = new WizardDeposit(LAST_NAME, AGE);
        manager.persist(wizardDeposit);

        manager.getTransaction().commit();
        manager.close();
    }
}