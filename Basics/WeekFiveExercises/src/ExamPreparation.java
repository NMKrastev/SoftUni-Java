import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int failedThreshold = Integer.parseInt(scanner.nextLine());
        int failedTimes = 0, solvedProblemsCount = 0;
        double gradeSum = 0;
        String lastProblem = "";
        boolean isFailed = true;

        while (failedTimes < failedThreshold) {
            String problemName = scanner.nextLine();
            if (problemName.equals("Enough")) {
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                failedTimes++;
            }

            gradeSum += grade;
            solvedProblemsCount++;
            lastProblem = problemName;

        }

        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", failedThreshold);
        } else {
            System.out.printf("Average score: %.2f\n", gradeSum / solvedProblemsCount);
            System.out.printf("Number of problems: %d\n", solvedProblemsCount);
            System.out.printf("Last problem: %s\n", lastProblem);
        }

    }
}
