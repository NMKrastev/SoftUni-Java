import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

    public static void main(String[] args) {

        //Use resources from old.resources package
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Creates entity and saves(persists) it to DB
        /*Student student = new Student();
        student.setName("Peter");
        session.persist(student);*/

        //Gets entity from DB
        /*Student studentFromDB = session.get(Student.class, 1);
        System.out.println(studentFromDB.getId() + " " + studentFromDB.getName());

        Student studentFromDBUpdated = session.get(Student.class, 2);
        studentFromDBUpdated.setName("John");*/

        //Gets the data from DB in a list
        /*List<Student> studentList = session.createQuery("FROM Student", Student.class).list();
        //List<Student> studentList = session.createQuery("FROM Student AS s WHERE name = 'Peter'", Student.class).list();

        for (Student student : studentList) {
            System.out.println(student.getId() + " " + student.getName());
        }*/

        //Retrieve data by Criteria
        /*CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Student> r = criteria.from(Student.class);

        criteria.select(r)
                .where(builder.like(r.get("name"), "P%"));

        List<Student> resultList = session.createQuery(criteria).getResultList();

        for (Student student : resultList) {
            System.out.println(student.getName());
        }*/

        session.beginTransaction();

        session.getTransaction().commit();

        //System.out.println(studentFromDBUpdated.getName());

        session.close();

    }
}
