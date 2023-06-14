import entities.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class A9_FindLatest10Projects {

    private static final String PERSISTENCE_UNIT_NAME = "soft_uni";
    private static final String GET_LAST_10_STARTED_PROJECTS =
            "SELECT p FROM Project p ORDER BY p.startDate DESC";

    public static void main(String[] args) {

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        final List<Project> projectList =
                manager.createQuery(GET_LAST_10_STARTED_PROJECTS, Project.class).setMaxResults(10).getResultList();

        final List<Project> sortedByProjectName = projectList
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .toList();

        //Project Start Date:00:00:00.0 does not have whitespace as shown in the task
        sortedByProjectName
                .forEach(e -> System.out.printf("Project name: %s\n" +
                                "        Project Description: %s\n" +
                                "        Project Start Date:%s\n" +
                                "        Project End Date: %s\n",
                        e.getName(), e.getDescription(),
                        e.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")),
                        e.getEndDate() == null ? "null" : e.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"))));

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
