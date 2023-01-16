import java.util.*;
import java.util.stream.Stream;

public class A5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGradesMap = new TreeMap<>();
        String input;
        for (int i = 0; i < num; i++) {
            input = scanner.nextLine();
            String student = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);
            studentsGradesMap.putIfAbsent(student, new ArrayList<>());
            studentsGradesMap.get(student).add(grade);
        }

        studentsGradesMap.forEach((student, grades) -> {
            double averageSum = 0;
            for (double number : grades) {
                averageSum += number;
            }
            averageSum /= grades.size();
            System.out.printf("%s -> ", student);
            grades.forEach(n -> System.out.printf("%.2f ", n));
            System.out.printf("(avg: %.2f)\n", averageSum);
        });
    }
}
/*Write a program, which reads the name of a student and their grades and adds them to the student record,
then prints grades along with their average grade – ordered the output by the students' names.
Input
On the first line N – the number of students, then on the next, N lines student name with grade.
*/
