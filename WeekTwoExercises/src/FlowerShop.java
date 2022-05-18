import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int magnoliasCount = Integer.parseInt(scanner.nextLine());
        int hyacinthsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int cactiCount = Integer.parseInt(scanner.nextLine());
        double presentPrice = Double.parseDouble(scanner.nextLine());
        double flowersPrice = (magnoliasCount * 3.25) + (hyacinthsCount * 4.00)
                + (rosesCount * 3.50) + (cactiCount * 8.00);
        double priceWithTax =  flowersPrice - (flowersPrice * 0.05);

        if (priceWithTax >= presentPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(priceWithTax - presentPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(presentPrice - priceWithTax));
        }

    }
}
/*Мария иска да купи подарък на сина си. Тя работи в магазин за цветя. В магазина идва поръчка за цветя.
Напишете програма, която пресмята сумата от поръчката и дали печалбата е достатъчна за подаръка.
Цветята имат следните цени:
•	Магнолии – 3.25 лева
•	Зюмбюли – 4 лева
•	Рози – 3.50 лева
•	Кактуси – 8 лева
От общата сума, Мария трябва да плати 5% данъци.
Вход
Входът се чете от конзолата и се състои от 5 реда:
•	Брой магнолии – цяло число в интервала [0 … 50]
•	Брой зюмбюли – цяло число в интервала [0 … 50]
•	Брой рози – цяло число в интервала [0 … 50]
•	Брой кактуси – цяло число в интервала [0 … 50]
•	Цена на подаръка – реално число в интервала [0.00 … 500.00]
Изход
На конзолата трябва да се отпечата един ред.
•	Ако парите СА стигнали: "She is left with {останали} leva." –
сумата трябва да е закръглена към по-малко цяло число (пр. 1.90 -> 1).
•	Ако парите НЕ достигат: "She will have to borrow {останали} leva." –
сумата трябва да е закръглена към по-голямо цяло число (пр. 1.10 -> 2).
*/