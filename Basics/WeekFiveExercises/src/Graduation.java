import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int countGrade = 1, count = 1, countExclude = 0;
        double sumGrades = 0;

        while (countGrade <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4.00) {
                countExclude++;
            }
            if (countExclude == 2) {
                System.out.printf("%s has been excluded at %d grade", name, countGrade - 1);
                break;
            }

            if (countGrade <= 12) {
                sumGrades += grade;
                countGrade++;
            }
            if (countGrade == 13) {
                sumGrades = sumGrades / 12;
                System.out.printf("%s graduated. Average grade: %.2f", name, sumGrades);
            }
        }

    }
}
/*Напишете програма, която изчислява средната оценка на ученик от цялото му обучение.
На първия ред ще получите името на ученика, а на всеки следващ ред неговите годишни оценки.
Ученикът преминава в следващия клас, ако годишната му оценка е по-голяма или равна на 4.00.
Ако ученикът бъде скъсан повече от един път, то той бива изключен и програмата приключва,
като се отпечатва името на ученика и в кой клас бива изключен.
 При успешно завършване на 12-ти клас да се отпечата :
"{име на ученика} graduated. Average grade: {средната оценка от цялото обучение}"
В случай, че ученикът е изключен от училище, да се отпечата:
"{име на ученика} has been excluded at {класа, в който е бил изключен} grade"
Стойността трябва да бъде форматирана до втория знак след десетичната запетая.
*/