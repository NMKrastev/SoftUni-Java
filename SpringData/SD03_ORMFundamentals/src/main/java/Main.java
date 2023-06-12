import entities.Employees;
import entities.Student;
import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, NoSuchFieldException {

        Connector.createConnection();

        Connection connection = Connector.getConnection();

        //EntityManager<User> userManager = new EntityManager<>(connection);

        //Adds entity to the database

        /*User userOne = new User("UserOne", 20, LocalDate.now());
        userManager.persist(userOne);*/

        //Updates entity in the database

        /*User first = userManager.findFirst(User.class);
        first.setUsername("Test");
        userManager.persist(first);*/

        //Deletes entity from the database

        /*User userThree = userManager.findFirst(User.class, "username = 'UserToDelete'");
        userManager.delete(userThree);*/

        //Check the custom ORMException class

        /*EntityManager<Student> studentManager = new EntityManager<>(connection);
        Student student = new Student("Pesho");
        studentManager.persist(student);*/

        //Prints the entities we are working with

        /*User findFirstUser = userManager.findFirst(User.class);

        System.out.println(findFirstUser.getId() + " " + findFirstUser.getUsername());*/

        //Student findsStudentWithName = studentManager.findFirst(Student.class, "name = 'Gosho'");

        //System.out.println(findsStudentWithName.getId() + " " + findsStudentWithName.getName());

        /*userManager.find(User.class, "age > 20 AND DAY(registration_date) BETWEEN 3 AND 4")
                .forEach(u -> System.out.println(u.toString()));*/


        //Creates new table if it doesn't exist and tests it with adding entity into it
        EntityManager<Employees> employeeManager = new EntityManager<>(connection);

        employeeManager.doCreate(Employees.class);

        Employees employeeJohn = new Employees("John", "Smith", 15000);
        employeeManager.persist(employeeJohn);

        employeeJohn = employeeManager.findFirst(Employees.class);
        employeeJohn.setSalary(20000);
        employeeManager.persist(employeeJohn);

        employeeJohn = employeeManager.findFirst(Employees.class);
        employeeManager.delete(employeeJohn);



        connection.close();
    }
}
