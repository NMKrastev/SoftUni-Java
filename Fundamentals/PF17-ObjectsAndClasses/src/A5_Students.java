import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A5_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A5_Student> studentsInfo = new ArrayList<>();
        String command = "";

        while (!(command = scanner.nextLine()).equals("end")) {

            String firstName = command.split(" ")[0];
            String lastName = command.split(" ")[1];
            int age = Integer.parseInt(command.split(" ")[2]);
            String hometown = command.split(" ")[3];

            if (isStudentExisting(studentsInfo, firstName, lastName)) {
                A5_Student student = getStudents(studentsInfo, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);
            } else {
                A5_Student student = new A5_Student(firstName, lastName, age, hometown);
                studentsInfo.add(student);
            }

        }

        String town = scanner.nextLine();

        for (A5_Student student : studentsInfo) {
            if (student.getHometown().equals(town)) {

                System.out.println(student.getFirstName() + " " + student.getLastName() + " is " + student.getAge() + " years old");

            }
        }
    }

    private static A5_Student getStudents(List<A5_Student> studentsInfo, String firstName, String lastName) {

        A5_Student existingStudent = null;

        for (A5_Student student : studentsInfo) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExisting(List<A5_Student> studentsInfo, String firstName, String lastName) {

        for (A5_Student student : studentsInfo) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}
/*Define a class Student, which holds the following information about students: first name, last name, age, and hometown.
Read the list of students until you receive the "end" command. After that, you will receive a city name. Print only
students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".*/

/*For A5_2_Student class:
 * Use the class from the previous problem. If you receive a student who already exists
 * (first name and last name should be unique), overwrite the information.*/