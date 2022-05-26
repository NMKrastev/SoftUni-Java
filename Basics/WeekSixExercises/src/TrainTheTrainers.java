import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double average = 0;
        double totalGrades = 0, currentTotal = 0;
        int count = 0;
        int jury = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();

        while (!presentation.equals("Finish")) {

            for (int i = 0; i < jury; i++) {
                double currentGrades = Double.parseDouble(scanner.nextLine());
                totalGrades += currentGrades;
                currentTotal += currentGrades;
                count++;
                average = currentTotal / jury;
            }

            System.out.printf("%s - %.2f.\n", presentation, average);
            currentTotal = 0;
            presentation = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalGrades / count);
    }
}
/*Курсът "Train the trainers" е към края си и финалното оценяване наближава. Вашата задача е да помогнете
на журито което ще оценява презентациите, като напишете програма в която да изчислява средната оценка от
представянето на всяка една презентация от даден студент, а накрая средният успех от всички тях.
От конзолата на първият ред се прочита броят на хората в журито n - цяло число в интервала [1…20]
След това на отделен ред се прочита името на презентацията - текст
За всяка една презентация на нов ред се четат n - на брой оценки - реално число в интервала [2.00…6.00]
След изчисляване на средната оценка за конкретна презентация, на конзолата се печата
 "{името на презентацията} - {средна оценка}."
След получаване на команда "Finish" на конзолата се печата "Student's final assessment is
{среден успех от всички презентации}." и програмата приключва.
Всички оценки трябва да бъдат форматирани до втория знак след десетичната запетая.
*/