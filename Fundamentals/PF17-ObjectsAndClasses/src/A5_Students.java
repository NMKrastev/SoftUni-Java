import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A5_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A5_Student> studentInfo = new ArrayList<>();
        String command = "";

        while (!(command = scanner.nextLine()).equals("end")) {

            String firstName = command.split(" ")[0];
            String lastName = command.split(" ")[1];
            int age = Integer.parseInt(command.split(" ")[2]);
            String hometown = command.split(" ")[3];

            A5_Student student = new A5_Student(firstName, lastName, age, hometown);

            studentInfo.add(student);
        }

        String town = scanner.nextLine();

        for (A5_Student student : studentInfo) {
            if (student.getHometown().equals(town)) {

                System.out.println(student.getFirstName() + " " + student.getLastName() + " is " + student.getAge() + " years old");

            }
        }
    }
}
/*Define a class Student, which holds the following information about students: first name, last name, age, and hometown.
Read the list of students until you receive the "end" command. After that, you will receive a city name. Print only
students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".*/