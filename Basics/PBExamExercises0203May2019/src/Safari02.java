import java.util.Scanner;

public class Safari02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double fuelNeeded = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();
        double totalPrice = 0;

        switch (day) {
            case "Saturday":
                totalPrice = ((fuelNeeded * 2.10) + 100);
                totalPrice = totalPrice - (totalPrice * 0.1);
                break;
            case "Sunday":
                totalPrice = ((fuelNeeded * 2.10) + 100);
                totalPrice = totalPrice - (totalPrice * 0.2);
                break;
        }

        if (budget >= totalPrice) {
            System.out.printf("Safari time! Money left: %.2f lv.", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", totalPrice - budget);
        }
    }
}
/*Симона и Светлин ще ходят на почивка в Африка и искат да отидат на сафари. Понеже за делничните дни вече имат
планове, решават, че ще отидат събота или неделя. Напишете програма, която изчислява колко ще им струва
ходенето на сафари и дали бюджетът им ще им стигне да отидат, като имате предвид следното:
•	Цената на един литър гориво е 2.10 лв.
•	Цената за екскурзовод е 100лв.
•	В зависимост от деня има отстъпки от общата цена - за събота 10%, а за неделя 20%
Вход
От конзолата се четат 3 реда:
•	Бюджет – реално число в интервала [0.00… 10000.00]
•	Колко литра гориво ще са им нужни – реално число в интервала [1.00… 50.00]
•	Ден от седмицата – текст с възможности "Saturday" и "Sunday"
Изход
Да се отпечата на конзолата един ред:
•	Ако бюджетът е достатъчен:
"Safari time! Money left: {колко пари са им останали} lv. "
•	Ако бюджетът не е достатъчен:
"Not enough money! Money needed: {колко пари не им достигат} lv."
Сумите трябва да са форматирани до втория знак след десетичната запетая.
*/