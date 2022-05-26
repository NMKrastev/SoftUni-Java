import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        double carPrice;

        if (budget <= 100) {
            if (season.equals("summer")) {
                carPrice = budget * 0.35;
                System.out.printf("Economy class\nCabrio - %.2f", carPrice);
            } else {
                carPrice = budget * 0.65;
                System.out.printf("Economy class\nJeep - %.2f", carPrice);
            }
        } else if (budget > 100 && budget <= 500) {
            if (season.equals("summer")) {
                carPrice = budget * 0.45;
                System.out.printf("Compact class\nCabrio - %.2f", carPrice);
            } else {
                carPrice = budget * 0.80;
                System.out.printf("Compact class\nJeep - %.2f", carPrice);
            }
        } else {
            carPrice = budget * 0.90;
            System.out.printf("Luxury class\nJeep - %.2f", carPrice);
        }
    }
}
/*Напишете програма, която спрямо даден бюджет и сезон да пресмята цената, типа и класа на кола под наем.
Сезоните са лято и зима – "Summer" и "Winter". Типа коли са кабрио и джип – "Cabrio" и "Jeep".
•	При бюджет по-малък или равен от 100лв.:
o	Класът ще е - "Economy class"
o	Според сезона колата и цената ще са:
	Лято – Кабрио – 35% от бюджета
	Зима – Джип – 65% от бюджета
•	При бюджет по-голям от 100лв. и по-малък или равен от 500лв.:
o	Класът ще е - "Compact class"
o	Според сезона колата и цената ще са:
	Лято – Кабрио – 45% от бюджета
	Зима – Джип – 80% от бюджета
•	При бюджет по-голям от 500лв.:
o	Класът ще е – "Luxury class"
o	За всеки сезон колата ще е джип и цената ще е:
	90% от бюджета
Вход
Входът се чете от конзолата и се състои от два реда:
•	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
•	Втори ред –  Сезон – текст "Summer" или "Winter"
Изход
На конзолата трябва да се отпечатат два реда.
•	Първи ред – "{Вид на класа}"
o	"Economy class", "Compact class" или "Luxury class"
•	Втори ред – "{Вид на колата} - {цена на колата}"
o	Видът на колата – "Cabrio" или "Jeep"
o	Цената трябва да е форматирана до втория знак след запетаята
*/