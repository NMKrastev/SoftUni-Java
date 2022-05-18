import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermenCount = Integer.parseInt(scanner.nextLine());
        double boatPrice = 0;

        if (season.equals("Spring")) {
            boatPrice = 3000;
        } else if (season.equals("Summer") || season.equals("Autumn")) {
            boatPrice = 4200;
        } else if (season.equals("Winter")) {
            boatPrice = 2600;
        }

        if (fishermenCount <= 6) {
            boatPrice = boatPrice * 0.90;
        } else if (fishermenCount > 6 && fishermenCount <= 11) {
            boatPrice = boatPrice * 0.85;
        } else {
            boatPrice = boatPrice * 0.75;
        }

        if (season.equals("Spring") || season.equals("Summer") || season.equals("Winter")) {
            if (fishermenCount % 2 == 0) {
                boatPrice = boatPrice * 0.95;
            }
        }

        if (boatPrice <= budget) {
            System.out.printf("Yes! You have %.2f leva left.", budget - boatPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", boatPrice - budget);
        }

    }
}
/*        switch (season) {
            case "spring":
                boatPrice = 3000;
                if (fishermenCount <= 6) {
                    boatPrice = boatPrice * 0.90;
                } else if (fishermenCount > 6 && fishermenCount <= 11) {
                    boatPrice = boatPrice * 0.85;
                } else {
                    boatPrice = boatPrice * 0.75;
                }
                if (fishermenCount % 2 == 0) {
                    boatPrice = boatPrice * 0.95;
                }
            case "summer":
            case "autumn":
                boatPrice = 4200;
                if (fishermenCount <= 6) {
                    boatPrice = boatPrice * 0.90;
                } else if (fishermenCount > 6 && fishermenCount <= 11) {
                    boatPrice = boatPrice * 0.85;
                } else {
                    boatPrice = boatPrice * 0.75;
                }
                if (fishermenCount % 2 == 0 && season.equals("summer")) {
                    boatPrice = boatPrice * 0.95;
                }
                break;
            case "winter":
                boatPrice = 2600;
                if (fishermenCount <= 6) {
                    boatPrice = boatPrice * 0.90;
                } else if (fishermenCount > 6 && fishermenCount <= 11) {
                    boatPrice = boatPrice * 0.85;
                } else {
                    boatPrice = boatPrice * 0.75;
                }
                if (fishermenCount % 2 == 0) {
                    boatPrice = boatPrice * 0.95;
                }
                break;
        }*/
/*Цената зависи от сезона:
•	Цената за наем на кораба през пролетта е  3000 лв.
•	Цената за наем на кораба през лятото и есента е  4200 лв.
•	Цената за наем на кораба през зимата е  2600 лв.
В зависимост от броя си групата ползва отстъпка:
•	Ако групата е до 6 човека включително  –  отстъпка от 10%.
•	Ако групата е от 7 до 11 човека включително  –  отстъпка от 15%.
•	Ако групата е от 12 нагоре  –  отстъпка от 25%.
Рибарите ползват допълнително 5% отстъпка ако са четен брой освен ако не е есен
- тогава нямат допълнителна отстъпка.
Напишете програма, която да пресмята дали рибарите ще съберат достатъчно пари.
Вход
От конзолата се четат точно три реда.
•	Бюджет на групата – цяло число в интервала [1…8000]
•	Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"
•	Брой рибари – цяло число в интервала [4…18]
Изход
Да се отпечата на конзолата един ред:
•	Ако бюджетът е достатъчен:
"Yes! You have {останалите пари} leva left."
•	Ако бюджетът НЕ Е достатъчен:
"Not enough money! You need {сумата, която не достига} leva."
Сумите трябва да са форматирани с точност до два знака след десетичната запетая.
*/