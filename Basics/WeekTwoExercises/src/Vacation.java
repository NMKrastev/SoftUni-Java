import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        double locationPrice = 0;

        if (budget <= 1000) {
            if (season.equals("summer")) {
                locationPrice = budget * 0.65;
                System.out.printf("Alaska - Camp - %.2f", locationPrice);
            } else {
                locationPrice = budget * 0.45;
                System.out.printf("Morocco - Camp - %.2f", locationPrice);
            }
        } else if (budget > 1000 && budget <= 3000) {
            if (season.equals("summer")) {
                locationPrice = budget * 0.80;
                System.out.printf("Alaska - Hut - %.2f", locationPrice);
            } else {
                locationPrice = budget * 0.60;
                System.out.printf("Morocco - Hut - %.2f", locationPrice);
            }
        } else {
            locationPrice = budget * 0.90;
            if (season.equals("summer")) {
                System.out.printf("Alaska - Hotel - %.2f", locationPrice);
            } else {
                System.out.printf("Morocco - Hotel - %.2f", locationPrice);
            }
        }
    }
}
/*Напишете програма, която спрямо даден бюджет и сезон да пресмята цената, локацията и мястото на настаняване за ваканция. Сезоните са лято и зима – "Summer" и "Winter". Локациите са – "Alaska" и "Morocco". Възможните места за настаняване – "Hotel", "Hut" или "Camp".
•	При бюджет по-малък или равен от 1000лв.:
o	Настаняване в "Camp"
o	Според сезона локацията ще е една от следните и ще струва определен процент от бюджета:
	Лято – Аляска – 65% от бюджета
	Зима – Мароко – 45% от бюджета
•	При бюджет по-голям от 1000лв. и по-малък или равен от 3000лв.:
o	Настаняване в "Hut"
o	Според сезона локацията ще е една от следните и ще струва определен процент от бюджета:
	Лято – Аляска – 80% от бюджета
	Зима – Мароко – 60% от бюджета
•	При бюджет по-голям от 3000лв.:
o	Настаняване в "Hotel"
o	Според сезона локацията ще е една от следните и ще струва 90% от бюджета:
	Лято – Аляска
	Зима – Мароко
Вход
Входът се чете от конзолата и се състои от два реда:
•	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
•	Втори ред –  Сезон – текст "Summer" или "Winter"
Изход
На конзолата трябва да се отпечатат един ред.
"{локацията} – {мястото за настаняване} – {цената}"
Цената трябва да е форматирана до вторият знак след десетичната запетая.
*/