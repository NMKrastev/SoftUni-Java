import java.util.Scanner;

public class CoffeeMachine03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int drinksNum = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        switch (drink) {
            case "Espresso":
                switch (sugar) {
                    case "Without":
                        totalPrice = drinksNum * 0.90;
                        totalPrice = totalPrice - (totalPrice * 0.35);
                        if (drinksNum >= 5) {
                            totalPrice = totalPrice - (totalPrice * 0.25);
                        }
                        break;
                    case "Normal":
                        totalPrice = drinksNum * 1.00;
                        if (drinksNum >= 5) {
                            totalPrice = totalPrice - (totalPrice * 0.25);
                        }
                        break;
                    case "Extra":
                        totalPrice = drinksNum * 1.20;
                        if (drinksNum >= 5) {
                            totalPrice = totalPrice - (totalPrice * 0.25);
                        }
                        break;
                }
                break;
            case "Cappuccino":
                switch (sugar) {
                    case "Without":
                        totalPrice = drinksNum * 1.00;
                        totalPrice = totalPrice - (totalPrice * 0.35);
                        break;
                    case "Normal":
                        totalPrice = drinksNum * 1.20;
                        break;
                    case "Extra":
                        totalPrice = drinksNum * 1.60;
                        break;
                }
                break;
            case "Tea":
                switch (sugar) {
                    case "Without":
                        totalPrice = drinksNum * 0.50;
                        totalPrice = totalPrice - (totalPrice * 0.35);
                        break;
                    case "Normal":
                        totalPrice = drinksNum * 0.60;
                        break;
                    case "Extra":
                        totalPrice = drinksNum * 0.70;
                        break;
                }
                break;
        }
        if (totalPrice > 15) {
            totalPrice = totalPrice - (totalPrice * 0.2);
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", drinksNum, drink, totalPrice);
    }
}
/*Напишете софтуер, който да пресмята сметката на клиент, закупил определен брой от дадена напитка от кафемашина.
	        Без захар	    Нормално	    Допълнително захар
Еспресо	    0.90 лв./бр.	1 лв. /бр.  	1.20 лв. /бр.
Капучино	1.00 лв. /бр.	1.20 лв. /бр.	1.60 лв. /бр.
Чай     	0.50 лв. /бр.	0.60 лв. /бр.	0.70 лв. /бр.
Трябва да имате предвид следните отстъпки:
•	При избрана напитка без захар има 35% отстъпка.
•	При избрана напитка "Espresso" и закупени поне 5 броя, има 25% отстъпка.
•	При сума надвишава 15 лева, 20% отстъпка от крайната цена,
Отстъпките се прилагат в реда на тяхното описване.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред - напитка - текст с възможности"Espresso", "Cappuccino" или "Tea"
•	Втори ред - захар - текст  с възможности "Without", "Normal" или "Extra"
•	Трети ред - брой напитки - цяло число в интервала [1… 50]
Изход
На конзолата трябва да се отпечата един ред:
"You bought {брой напитки} cups of {напитка} for {крайна цена} lv."
Цената да бъде форматирана до втората цифра след десетичния знак.
*/