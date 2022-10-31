import java.util.*;

public class A5_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equals("end")) {

            String course = line.split("\\s+:\\s+")[0];
            String student = line.split("\\s+:\\s+")[1];

            if (isCourseExist(course, coursesMap)) {
                coursesMap.get(course).add(student);
            } else {
                coursesMap.put(course, new ArrayList<>());
                coursesMap.get(course).add(student);
            }
        }

        printResult(coursesMap);

    }

    private static void printResult(Map<String, List<String>> coursesMap) {

        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {

            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
            for (String student : entry.getValue()) {
            System.out.printf("-- %s\n", student);
            }
        }
    }

    private static boolean isCourseExist(String course, Map<String, List<String>> coursesMap) {

        return coursesMap.containsKey(course);
    }
}
/*Write a program which keeps the information about courses. Each course has a name and registered students.
You will receive the course name and student name until you receive the command "end". Check if such a course
already exists and if not - add the course. Register the user into the course. When you do receive the command "end",
print the courses with their names and total registered users. For each contest, print the registered users.
Input
•	Until you receive "end", the input come in the format: "{courseName} : {studentName}".
•	The product data is always delimited by " : ".
Output
•	Print information about each course, following the format:
"{courseName}: {registeredStudents}"
•	Print information about each student, following the format:
"-- {studentName}"
*/