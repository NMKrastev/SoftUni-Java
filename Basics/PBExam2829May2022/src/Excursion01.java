import java.util.Scanner;

public class Excursion01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int ticketsForMuseum = Integer.parseInt(scanner.nextLine());

        double totalNightPrice = nights * 20;
        double totalCardsPrice = transportCards * 1.60;
        double totalTicketsPrice = ticketsForMuseum * 6;
        double totalPrice = (totalNightPrice + totalCardsPrice + totalTicketsPrice) * people;
        totalPrice += (totalPrice * 0.25);

        System.out.printf("%.2f", totalPrice);

    }
}
/*Група приятели отиват на екскурзия. Първоначално прочитаме от конзолата броя на хората в групата.
След това на отделни редове получаваме броя на нощувките, картите за транспорт и билети за музеи,
които ще бъдат закупени от един човек. Трябва да се има предвид следния ценоразпис:
•	Нощувка - 20 лв.
•	Карта за транспорт - 1.60 лв.
•	Билет за музей - 6 лв.
Към крайната сума се начислява допълнително 25% за непредвидени разходи. Да се напише програма,
която изчислява общата сумата, която групата трябва да плати.
Вход:
От конзолата се четат 4 реда:
1.	Броят на хората в групата – цяло число в интервала [0 … 50]
2.	Броят на нощувките – цяло число в интервала [0 … 2000]
3.	Броят на картите за транспорт – цяло число в интервала [0… 2000]
4.	Броят на билетите за музеи – цяло число в интервала [0 … 2000]
Изход:
Да се отпечата на конзолата едно число:
•	парите, които групата трябва да плати, форматирани до втората цифра след десетичния знак
*/