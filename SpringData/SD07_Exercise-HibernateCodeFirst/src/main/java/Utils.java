import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

enum Utils {

    ;

    static EntityManager getSQLConnection(String persistenceUnitName) {

        return Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();

    }
}
