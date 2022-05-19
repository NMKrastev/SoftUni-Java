import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double between3To399 = 0, between4To499 = 0, totalGrades = 0, fail = 0, top = 0,
        failPercent = 0, topPercent = 0;

        for (int i = 0; i < students; i++) {

            double grades = Double.parseDouble(scanner.nextLine());

            if (grades >= 2 && grades < 3) {
                fail++;
                totalGrades += grades;
            } else if (grades >= 3 && grades < 4) {
                between3To399++;
                totalGrades += grades;
            } else if (grades >= 4 && grades < 5) {
                between4To499++;
                totalGrades += grades;
            } else if (grades >= 5 && grades <= 6) {
                top++;
                totalGrades += grades;
            }
        }

        between3To399 = (between3To399 / students) * 100;
        between4To499 = (between4To499 / students) * 100;
        failPercent = (fail / students) * 100;
        topPercent = (top / students) * 100;
        totalGrades = totalGrades / students;

        System.out.printf("Top students: %.2f%%\n" +
                "Between 4.00 and 4.99: %.2f%%\n" +
                "Between 3.00 and 3.99: %.2f%%\n" +
                "Fail: %.2f%%\n" +
                "Average: %.2f\n", topPercent, between4To499, between3To399, failPercent, totalGrades);

    }
}
/*Напишете програма, която да пресмята статистика на оценки от изпит. В началото програмата получава броят на студентите
явили се на изпита и за всеки студент неговата оценка.
 На края програмата трябва да изпечата процента на студенти с оценка между 2.00 и 2.99, между 3.00 и 3.99, между 4.00 и 4.99, 5.00 или повече.
 Също така и средният успех на изпита.
Вход
От конзолата се четат поредица от числа, всяко на отделен ред:
•	На първия ред – броя на студентите явили се на изпит – цяло число в интервала [1...1000]
•	За всеки един студент на отделен ред – оценката от изпита – реално число в интервала [2.00...6.00]
Изход
Да се отпечатат на конзолата 5 реда, които съдържат следната информация:
Ред 1 -	"Top students: {процент студенти с успех 5.00 или повече}%"
Ред 2 -	"Between 4.00 and 4.99: {между 4.00 и 4.99 включително}%"
Ред 3 -	"Between 3.00 and 3.99: {между 3.00 и 3.99 включително}%"
Ред 4 -	"Fail: {по-малко от 3.00}%"
Ред 5 -	"Average: {среден успех}"
Всички числа трябва да са форматирани до вторият знак след десетичната запетая.
*/