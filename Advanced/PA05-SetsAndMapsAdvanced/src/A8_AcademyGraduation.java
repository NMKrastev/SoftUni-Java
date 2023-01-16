import java.text.DecimalFormat;
import java.util.*;

public class A8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsInfoMap = new TreeMap<>();
        String input;
        while (num-- > 0) {
            String student = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToDouble(Double::parseDouble).toArray();
            studentsInfoMap.putIfAbsent(student, new ArrayList<>());
            for (double grade : grades) {
            studentsInfoMap.get(student).add(grade);
            }
        }

        DecimalFormat df = new DecimalFormat("0.################");
        studentsInfoMap.forEach((student, avrGrade) -> {
            double averageSum = 0;
            for (int i = 0; i < avrGrade.size(); i++) {
                averageSum += avrGrade.get(i);
            }
            averageSum /= avrGrade.size();
            System.out.printf("%s is graduated with %s\n", student, df.format(averageSum));
        });
    }
}
/*Write a program that:
•	Reads from console number of students for a track.
•	Reads on pair of rows:
o	The first line is the name of the student.
o	The second line is his score for a different number of courses.
•	Print on console "{name} is graduated with {average scores)".
*/
