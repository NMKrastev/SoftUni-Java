import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JPAMain {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("school-db");

        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Creates new entity and adds to DB
        /*Student student = new Student("Alex");
        entityManager.persist(student);*/

        //Finds an entity with give id
        /*Student studentFound = entityManager.find(Student.class, 2);
        System.out.println(studentFound.getId() + " " + studentFound.getName());*/

        //Deletes entity from DB when it's found
        //entityManager.remove(studentFound);

        //Selects all entities from DB
        /*List<Student> fromStudent = entityManager.createQuery("FROM Student", Student.class).getResultList();
        fromStudent.forEach(e -> System.out.println(e.getId() + " " + e.getName()));*/



        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
