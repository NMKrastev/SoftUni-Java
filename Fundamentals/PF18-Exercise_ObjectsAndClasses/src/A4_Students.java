import java.util.*;
import java.util.stream.Collectors;

public class A4_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A4_Student> studentsList = new ArrayList<>();
        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {

            String line = scanner.nextLine();
            String firstName = line.split("\\s+")[0];
            String lastName = line.split("\\s+")[1];
            double grade = Double.parseDouble(line.split("\\s+")[2]);

            A4_Student student = new A4_Student(firstName, lastName, grade);
            studentsList.add(student);

        }

        studentsList = studentsList.stream().sorted(Comparator.comparing(A4_Student::getGrade, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (A4_Student student : studentsList) {
            System.out.println(student);
        }
    }
}
/*Write a program that receives n count of students and orders them by grade (in descending).
Each student should have a first name (string), last name (string), and grade (a floating-point number).
Input
•	First-line will be a number n.
•	Next n lines you will get a student info in the format "{first name} {second name} {grade}".
Output
•	Print each student in the following format "{first name} {second name}: {grade}".
*/