import A1_GringottsDatabase.WizardDeposit;
import A2_SalesDatabase.Customer;
import A2_SalesDatabase.Product;
import A2_SalesDatabase.Sale;
import A2_SalesDatabase.StoreLocation;
import A3_UniversitySystem.Course;
import A3_UniversitySystem.Student;
import A3_UniversitySystem.Teacher;
import A4_HospitalDatabase.*;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static enums.PersistenceUnitName.*;
import static enums.Variable.*;

public class Main {

    /**
     * Tasks are completed by using switch case that depending on your choice
     * executes a specific task related to its number thus creating a DB and populating it.
     * <p>
     * Choose a number that correspond to the task from the homework paper,
     * the application will do the rest. After that you can refresh your DB client
     * to check the DB, tables, etc.
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Please enter task number from 1 to 6: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (isTaskNumberNonExistent(taskNumber)) return;

        System.out.println(executeTask(taskNumber));
    }

    private static String executeTask(int taskNumber) {

        final EntityManager manager;

        switch (taskNumber) {
            case 1 -> {
                manager = Utils.getSQLConnection(GRINGOTTS.getPersistenceUnitName());
                taskOne(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
            case 2 -> {
                manager = Utils.getSQLConnection(SALES.getPersistenceUnitName());
                taskTwo(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
            case 3 -> {
                manager = Utils.getSQLConnection(UNIVERSITY.getPersistenceUnitName());
                taskThree(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
            case 4 -> {
                manager = Utils.getSQLConnection(HOSPITAL.getPersistenceUnitName());
                taskFour(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
        }

        return "Something went wrong with execution!";
    }

    /**
     * Part one: Populating the DB<br>
     * Populates the DB with patients, diagnoses and medicaments.<br><br>
     * Part two: Create a visitation<br>
     * Creates a visitation from a patient with the given ID. You can diagnose the patient by entering the diagnosis
     * name that is in the database. Furthermore, you can make a prescription for that patient. All of this is
     * inserted into the `visitations` table in database "hospital".<br><br>
     * Workflow is the following:<br>
     * 1. The doctor can add to his database patients, diagnoses and medicaments if needed<br>
     * 2. A doctor(GP) has a visitation<br>
     * 3. The doctor keeps track of the visitation by adding which patient was on that visitation,
     * what was the patient's diagnosis, and what was the medicament that was prescribed.<br><br>
     * Note: If you don't populate the database at first you'll get an exception: No result found for query [FROM Patient WHERE id = ?1]. This is TODO.
     */
    private static void taskFour(EntityManager manager) {

        /*Part one*/
        System.out.print(DO_YOU_WANT_TO_POPULATE_DB);
        String input = scanner.nextLine().toLowerCase();

        if (input.equalsIgnoreCase("Yes")) {

            while (!input.equalsIgnoreCase("No")) {

                manager.getTransaction().begin();

                final String firstName = InfoGatherer.gatherPatientFirstName();
                final String lastName = InfoGatherer.gatherPatientLastName();
                final String address = InfoGatherer.gatherPatientAddress();
                final String email = InfoGatherer.gatherPatientEmail();
                final LocalDate date = InfoGatherer.gatherPatientDateOfBirth();
                final Boolean isInsured = InfoGatherer.isPatientInsured();
                final Patient patient = new Patient(firstName, lastName, address, email, date, PICTURE_IN_BLOB, isInsured);
                manager.persist(patient);

                final String diagnoseName = InfoGatherer.gatherDiagnosisName();
                final String diagnoseComment = InfoGatherer.gatherDiagnosisComment();
                final Diagnose diagnoseOne = new Diagnose(diagnoseName, diagnoseComment);
                manager.persist(diagnoseOne);

                final String medicamentName = InfoGatherer.gatherMedicamentName();
                final Medicament medicament = new Medicament(medicamentName);
                manager.persist(medicament);

                manager.getTransaction().commit();

                System.out.println(DO_YOU_WANT_TO_POPULATE_DB);
                input = scanner.nextLine();

            }
        }

        //TODO When the app is started check if the DB is populated, and if not ask the user to do so

        /*Part two*/
        manager.getTransaction().begin();

        //Could be with patient's name instead of ID
        System.out.print(VISITATION_FROM_PATIENT_WITH_ID);
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print(COMMENT_FOR_VISITATION);
        final String comment = scanner.nextLine();

        System.out.print(PATIENT_IS_DIAGNOSED_WITH);
        final String diagnoseName = scanner.nextLine();

        System.out.print(PATIENT_WITH_PRESCRIPTION_FOR_MEDICAMENT_NAME);
        final String medicamentName = scanner.nextLine();

        final Patient patient = manager.createQuery(FIND_PATIENT, Patient.class).setParameter(1, id).getSingleResult();

        final Diagnose diagnose = manager.createQuery(FIND_DIAGNOSE, Diagnose.class).setParameter(1, diagnoseName).getSingleResult();

        final Medicament medicament = manager.createQuery(FIND_MEDICAMENT, Medicament.class).setParameter(1, medicamentName).getSingleResult();

        final Visitation visitation = new Visitation(LocalDate.now(), comment, patient, diagnose, medicament);

        manager.persist(visitation);

        manager.getTransaction().commit();
    }

    private static void taskThree(EntityManager manager) {

        manager.getTransaction().begin();

        //Bonus code to populate the DB
        final Teacher teacherOne = new Teacher(FIRST_NAME, LAST_NAME);
        final Student studentOne = new Student(FIRST_NAME, LAST_NAME);
        final Student studentTwo = new Student(FIRST_NAME, LAST_NAME);
        final Course courseOne = new Course(COURSE_NAME, LocalDate.now());

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

        //Bonus code to populate the DB
        final Product product = new Product(PRODUCT_ONE, QUANTITY, PRICE);
        final Customer customer = new Customer(CUSTOMER_ONE, EMAIL, CARD_NUMBER);
        final StoreLocation storeLocation = new StoreLocation(LOCATION_NAME);
        final Sale saleOne = getSale(product, customer, storeLocation);

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

        final Sale saleTwo = getSale(product, customer, storeLocation);

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

        final WizardDeposit wizardDeposit = new WizardDeposit(LAST_NAME, AGE);
        manager.persist(wizardDeposit);

        manager.getTransaction().commit();
    }

    private static boolean isTaskNumberNonExistent(int taskNumber) {

        if (taskNumber < 1 || taskNumber > 6) {
            System.out.printf(String.format(TASK_DOES_NOT_EXIST, taskNumber));
            return true;
        }

        return false;
    }

    private static String executedTaskNumber(int taskNumber) {
        return String.format(TASK_WAS_EXECUTED, taskNumber);
    }
}
