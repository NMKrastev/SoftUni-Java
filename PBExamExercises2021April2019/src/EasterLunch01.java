import java.util.Scanner;

public class EasterLunch01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double easterBread = 3.20;
        double eggDozen = 4.35;
        double cookiesForKg = 5.40;
        double paintPerEgg = 0.15;
        double totalSum = 0, totalPaint = 0, totalCookies = 0, totalEasterBread = 0, totalEggs = 0;

        int easterBreadNum = Integer.parseInt(scanner.nextLine());
        int eggsNum = Integer.parseInt(scanner.nextLine());
        int cookiesKgs = Integer.parseInt(scanner.nextLine());

        totalEasterBread = easterBreadNum * easterBread;
        totalEggs = eggsNum * eggDozen;
        totalCookies = cookiesKgs * cookiesForKg;
        totalPaint = (eggsNum * 12) * 0.15;


        System.out.printf("%.2f",totalEasterBread + totalEggs + totalCookies + totalPaint);

    }
}
/*Бабата на Деси всяка година приготвя обяд за семейството си за Великден. Напишете програма, която изчислява
какви разходи ще има по приготвянето на обяда, като знаете колко броя козунаци, кори с яйца и
килограма курабии е купила.  Цените на продуктите са следните:
•	Козунак  – 3.20 лв.
•	Яйца –  4.35 лв. за кора с 12 яйца
•	Курабии – 5.40 лв. за килограм
•	Боя за яйца - 0.15 лв. за яйце
Вход
От конзолата се четат 3 реда:
•	Брой козунаци - цяло число в интервала [0 … 99]
•	Брой кори с яйца - цяло число в интервала [0 … 99]
•	Килограми курабии - цяло число в интервала [0 … 99]
Изход
Да се отпечата на конзолата колко ще са разходите по приготвянето на обяда.
Сумата да бъде форматирана до втория знак след десетичната запетая.
*/