import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timePerMeter = Double.parseDouble(scanner.nextLine());

        double ivanTime = distance * timePerMeter;
        double resistancePerMeter = Math.floor(distance / 15) * 12.5;
        ivanTime += resistancePerMeter;
        double timeSlower = 0;

        if (ivanTime < record) {
            timeSlower = Math.abs(record - ivanTime);
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", ivanTime);
        } else if (ivanTime >= record) {
            timeSlower = Math.abs(record - ivanTime);
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeSlower);
        }

    }
}
/*Вход
От конзолата се четат 3 реда:
1.	Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
2.	Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
3.	Времето в секунди, за което плува разстояние от 1 м. - реално число в интервала [0.00 … 1000.00]
Изход
Отпечатването на конзолата зависи от резултата:
•	Ако Иван е подобрил Световния рекорд (времето му е по-малко от рекорда) отпечатваме:
o	"Yes, he succeeded! The new world record is {времето на Иван} seconds."
•	Ако НЕ е подобрил рекорда (времето му е по-голямо или равно на рекорда) отпечатваме:
o	"No, he failed! He was {недостигащите секунди} seconds slower."
Резултатът трябва да се форматира до втория знак след десетичната запетая.
*/