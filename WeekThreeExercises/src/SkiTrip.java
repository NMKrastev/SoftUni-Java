import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nights = Integer.parseInt(scanner.nextLine()) - 1;
        String typeOfPlace = scanner.nextLine().toLowerCase();
        String review = scanner.nextLine().toLowerCase();
        double totalPrice = 0;
        //double roomForOne = nights * 18.00;

        switch (typeOfPlace) {
            case "room for one person":
                totalPrice = nights * 18.00;
                if (review.equals("positive")) {
                    totalPrice = totalPrice + (totalPrice * 0.25);
                } else if (review.equals("negative")) {
                    totalPrice = totalPrice - (totalPrice * 0.10);
                }
                break;
            case "apartment":
                totalPrice = nights * 25.00;
                if (nights < 10) {
                    totalPrice = totalPrice - (totalPrice * 0.30);
                } else if (nights >= 10 && nights <= 15) {
                    totalPrice = totalPrice - (totalPrice * 0.35);
                } else {
                    totalPrice = totalPrice - (totalPrice * 0.50);
                }
                if (review.equals("positive")) {
                    totalPrice = totalPrice + (totalPrice * 0.25);
                } else if (review.equals("negative")) {
                    totalPrice = totalPrice - (totalPrice * 0.10);
                }
                break;
            case "president apartment":
                totalPrice = nights * 35.00;
                if (nights < 10) {
                    totalPrice = totalPrice - (totalPrice * 0.10);
                } else if (nights >= 10 && nights <= 15) {
                    totalPrice = totalPrice - (totalPrice * 0.15);
                } else {
                    totalPrice = totalPrice - (totalPrice * 0.20);
                }
                if (review.equals("positive")) {
                    totalPrice = totalPrice + (totalPrice * 0.25);
                } else if (review.equals("negative")) {
                    totalPrice = totalPrice - (totalPrice * 0.10);
                }
                break;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
/*Атанас решава да прекара отпуската си в Банско и да кара ски. Преди да отиде обаче, трябва да резервира
хотел и да изчисли колко ще му струва престоя. Налични са следните видове помещения, със следните цени а престой:
	"room for one person" – 18.00 лв за нощувка
	"apartment" – 25.00 лв за нощувка
	"president apartment" – 35.00 лв за нощувка
Според броят на дните, в които ще остане в хотела (пример: 11 дни = 10 нощувки) и видът на помещението,
което ще избере, той може да ползва различно намаление.
Намаленията са както следва:
вид помещение	    по-малко от 10 дни	    между 10 и 15 дни	    повече от 15 дни
room for one    	не ползва намаление	    не ползва намаление	    не ползва намаление
apartment	        30% от крайната цена	35% от крайната цена	50% от крайната цена
president apartment	10% от крайната цена	15% от крайната цена	20% от крайната цена
След престоя, оценката на Атанас за услугите на хотела може да е позитивна (positive) или негативна (negative)
Ако оценката му е позитивна, към цената с вече приспаднатото намаление Атанас добавя 25% от нея.
Ако оценката му е негативна приспада от цената 10%.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред - дни за престой - цяло число в интервала [0...365]
•	Втори ред - вид помещение - "room for one person", "apartment" или "president apartment"
•	Трети ред - оценка - "positive"  или "negative"
Изход
На конзолата трябва да се отпечата един ред:
•	Цената за престоят му в хотела, форматирана до втория знак след десетичната запетая.
*/