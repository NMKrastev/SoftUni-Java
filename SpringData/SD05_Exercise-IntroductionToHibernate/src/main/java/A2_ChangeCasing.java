import entities.Town;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class A2_ChangeCasing {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String UPDATE_TOWN_WITH_NAME_LENGTH_MORE_OR_EQUAL_THAN_5 =
            "UPDATE Town AS t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) <= 5";
    //private static final String GET_ALL_TOWNS = "FROM Town";


    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery(UPDATE_TOWN_WITH_NAME_LENGTH_MORE_OR_EQUAL_THAN_5).executeUpdate();

        /*final List<Town> fromTowns = manager.createQuery(GET_ALL_TOWNS, Town.class).getResultList();

        fromTowns.stream()
                .filter(e -> e.getName().length() <= 5)
                .forEach(e -> e.setName(e.getName().toUpperCase()));*/

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
