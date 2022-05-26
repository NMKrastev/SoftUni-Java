import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String ticketCategory = scanner.nextLine().toLowerCase();
        int peopleCount = Integer.parseInt(scanner.nextLine());
        double totalTicketsPrice = 0;
        double transportBudget = 0;

        if (peopleCount >= 1 && peopleCount <= 4) {
            transportBudget = budget * 0.75;
        } else if (peopleCount >= 5 && peopleCount <= 9) {
            transportBudget = budget * 0.60;
        } else if (peopleCount >= 10 && peopleCount <= 24) {
            transportBudget = budget * 0.50;
        } else if (peopleCount >= 25 && peopleCount <= 49) {
            transportBudget = budget * 0.40;
        } else if (peopleCount >= 50) {
            transportBudget = budget * 0.25;
        }

        double moneyLeft = budget - transportBudget;

        switch (ticketCategory) {
            case "vip":
                totalTicketsPrice = peopleCount * 499.99;
                break;
            case "normal":
                totalTicketsPrice = peopleCount * 249.99;
                break;
        }

        if (totalTicketsPrice > moneyLeft) {
            System.out.printf("Not enough money! You need %.2f leva.", totalTicketsPrice - moneyLeft);
        } else {
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft - totalTicketsPrice);
        }
    }
}
/*Когато пуснали билетите за Евро 2016, група запалянковци решили да си закупят.
Билетите имат две категории с различни цени:
•	IP – 499.99 лева.
•	Normal – 249.99 лева.
Запалянковците имат определен бюджет, а броят на хората в групата определя какъв процент
 от бюджета трябва да се задели за транспоОт 1 до 4 – 75% от бюджета.
•	От 5 до 9 – 60% от бюджета.
•	От 10 до 24 – 50% от бюджета.
•	От 25 до 49 – 40% от бюджета.
•	50 или повече – 25% от бюджета.
Напишете програма, която да пресмята дали с останалите пари от бюджета могат да си купят
билети за избраната категория. И колко пари ще им останат или ще са им нужни.
Вход
Входът се чете от конзолата и съдържа точно 3 реда:
•	На първия ред е бюджетът – реално число в интервала [1 000.00 ... 1 000 000.00]
•	На втория ред е категорията – "VIP" или "Normal"
•	На третия ред е броят на хората в групата – цяло число в интервала [1 ... 200]
Изход
Да се отпечата на конзолата един ред:
•	Ако бюджетът е достатъчен:
o	"Yes! You have {останалите пари на групата} leva left."
•	Ако бюджетът НЕ Е достатъчен:
o	"Not enough money! You need {сумата, която не достига} leva."
Сумите трябва да са форматирани с точност до два знака след десетичната запетая.
*/