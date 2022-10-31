import java.util.*;

public class A6_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> academyMap = new LinkedHashMap<>();
        int numOfRows = Integer.parseInt(scanner.nextLine());

        academyMap = addStudents(scanner, academyMap, numOfRows);

        academyMap = removeGradesBellow4AndAHalf(academyMap);

        printResult(academyMap);

    }

    private static void printResult(Map<String, List<Double>> academyMap) {

        for (Map.Entry<String, List<Double>> entry : academyMap.entrySet()) {
            System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue().get(0));
        }
    }

    private static Map<String, List<Double>> removeGradesBellow4AndAHalf(Map<String, List<Double>> academyMap) {

        Map<String, List<Double>> resultMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : academyMap.entrySet()) {
            double sum = 0;
            for (double grade : entry.getValue()) {
                sum += grade;
            }
            if (sum / entry.getValue().size() >= 4.50) {
                resultMap.put(entry.getKey(), new ArrayList<>());
                resultMap.get(entry.getKey()).add(sum / entry.getValue().size());
            }
        }
        return resultMap;
    }

    private static Map<String, List<Double>> addStudents(Scanner scanner, Map<String, List<Double>> academyMap, int numOfRows) {

        for (int i = 0; i < numOfRows; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (isStudentExist(student, academyMap)) {
                academyMap.get(student).add(grade);
            } else {
                academyMap.put(student, new ArrayList<>());
                academyMap.get(student).add(grade);
            }
        }
        return academyMap;
    }

    private static boolean isStudentExist(String student, Map<String, List<Double>> academyMap) {

        return academyMap.containsKey(student);
    }
}
/*Write a program that keeps the information about students and their grades.
On the first line, you will receive number n. After that, you will receive n pair of rows.
First, you will receive the student's name, after that, you will receive his grade.
Check if the student already exists and if not - add him. Keep track of all grades for each student.
When you finish reading data, keep students with an average grade higher or equal to 4.50.
Print the students and their average grade in the format:
"{name} –> {averageGrade}"
Format the average grade to the 2nd decimal place.*/