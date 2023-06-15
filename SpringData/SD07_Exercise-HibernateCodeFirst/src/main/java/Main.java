import A1_GringottsDatabase.WizardDeposit;
import A2_SalesDatabase.Customer;
import A2_SalesDatabase.Product;
import A2_SalesDatabase.Sale;
import A2_SalesDatabase.StoreLocation;
import A3_UniversitySystem.Course;
import A3_UniversitySystem.Student;
import A3_UniversitySystem.Teacher;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static enums.PersistenceUnitName.*;
import static enums.Variable.*;

public class Main {

    /**
     * Homework is completed using switch case that depending on your choice
     * executes the specific task related to its number.
     * <p>
     * Choose a number that correspond to the task from the homework paper,
     * the application will do the rest. After that you can refresh your DB client
     * to check the DB, tables, etc.
     */

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter task number from 1 to 6: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (isNumberNonExistent(taskNumber)) return;

        System.out.println(executeTask(taskNumber));
    }

    private static String executeTask(int taskNumber) {

        //In order for this switch to word the EntityManager can't be final
        EntityManager manager;

        switch (taskNumber) {
            case 1 -> {
                manager = Utils.getSQLConnection(GRINGOTTS.getPersistenceUnitName());
                taskOne(manager);
                manager.close();
                return "Task 1 was executed!";
            }
            case 2 -> {
                manager = Utils.getSQLConnection(SALES.getPersistenceUnitName());
                taskTwo(manager);
                manager.close();
                return "Task 2 was executed!";
            }
            case 3 -> {
                manager = Utils.getSQLConnection(UNIVERSITY.getPersistenceUnitName());
                taskThree(manager);
                manager.close();
                return "Task 3 was executed!";
            }
        }

        return "Something went wrong with execution!";
    }

    private static void taskThree(EntityManager manager) {

        manager.getTransaction().begin();

        Teacher teacherOne = new Teacher(FIRST_NAME, LAST_NAME);
        Student studentOne = new Student(FIRST_NAME, LAST_NAME);
        Student studentTwo = new Student(FIRST_NAME, LAST_NAME);
        Course courseOne = new Course(COURSE_NAME, LocalDate.now());

        teacherOne.getCourses().add(courseOne);
        courseOne.setTeacher(teacherOne);

        studentOne.getCourses().add(courseOne);
        courseOne.getStudents().add(studentOne);
        courseOne.getStudents().add(studentTwo);

        manager.persist(teacherOne);
        manager.persist(courseOne);
        manager.persist(studentOne);
        manager.persist(studentTwo);

        manager.getTransaction().commit();
    }

    private static void taskTwo(EntityManager manager) {

        manager.getTransaction().begin();

        Product product = new Product(PRODUCT_ONE, QUANTITY, PRICE);
        Customer customer = new Customer(CUSTOMER_ONE, EMAIL, CARD_NUMBER);
        StoreLocation storeLocation = new StoreLocation(LOCATION_NAME);
        Sale saleOne = getSale(product, customer, storeLocation);

        product.getSales().add(saleOne);
        saleOne.setProduct(product);

        customer.getSales().add(saleOne);
        saleOne.setCustomer(customer);

        storeLocation.getSales().add(saleOne);
        saleOne.setStoreLocation(storeLocation);

        manager.persist(product);
        manager.persist(customer);
        manager.persist(storeLocation);
        manager.persist(saleOne);

        Sale saleTwo = getSale(product, customer, storeLocation);

        product.getSales().add(saleTwo);
        saleTwo.setProduct(product);

        customer.getSales().add(saleTwo);
        saleTwo.setCustomer(customer);

        storeLocation.getSales().add(saleTwo);
        saleTwo.setStoreLocation(storeLocation);

        manager.persist(saleTwo);

        manager.getTransaction().commit();
    }

    private static Sale getSale(Product product, Customer customer, StoreLocation storeLocation) {
        return new Sale(product, customer, storeLocation, Date.from(Instant.now()));
    }

    private static void taskOne(EntityManager manager) {

        manager.getTransaction().begin();

        WizardDeposit wizardDeposit = new WizardDeposit(LAST_NAME, AGE);
        manager.persist(wizardDeposit);

        manager.getTransaction().commit();
    }

    private static boolean isNumberNonExistent(int taskNumber) {

        if (taskNumber < 1 || taskNumber > 6) {
            System.out.printf("Task with number %d does not exist!\n", taskNumber);
            return true;
        }

        return false;
    }
}
