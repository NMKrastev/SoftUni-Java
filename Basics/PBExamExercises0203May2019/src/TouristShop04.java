import java.util.Scanner;

public class TouristShop04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String product = scanner.nextLine();
        double currentTotal = 0;
        int countProducts = 0, countPromotion = 0;
        boolean flag = false;

        while (!product.equals("Stop")) {
            double pricePerProduct = Double.parseDouble(scanner.nextLine());
            countPromotion++;
            if (countPromotion == 3) {
                pricePerProduct = pricePerProduct - (pricePerProduct * 0.5);
                currentTotal += pricePerProduct;
                countPromotion = 0;
            } else {
                currentTotal += pricePerProduct;
            }
            if (currentTotal > budget) {
                flag = true;
                break;
            }
            countProducts++;
            product = scanner.nextLine();
        }
        if(flag) {
            System.out.printf("You don't have enough money!\n" +
                    "You need %.2f leva!", currentTotal - budget);
        } else {
            System.out.printf("You bought %d products for %.2f leva.", countProducts, currentTotal);
        }
    }
}
/*Времето се затопля и туристи, започват да си правят разходки високо в планината, където все още сняг, като за
целта те трябва да закупят нужната туристическа екипировка.
Вашата задача е да напишете програма, която да изчислява, стойността на екипировката, както и дали определения
бюджет е достатъчен или не, като се знае, че в магазина има следната промоция: Всеки трети продукт е на половин цена.
Вход
От конзолата се чете:
•	На първи ред – бюджетът - реално число в интервала [1.00… 100000.00]
•	След това поредица от два реда (до получаване на команда "Stop" или при заявка за купуване на продукт,
чиято стойност е по-висока от наличния бюджет) :
o	Име на продукта – текст
o	Цена на продукта – реално число в интервала [1.00… 5000.00]
Изход
На конзолата да се отпечатат следните редове според случая:
•	При получаване на командата "Stop", на един ред:
o	"You bought {брой на закупените продукти} products for {цена на покупките} leva."
•	При заявка за покупка на продукт, чиято цена е по-висока от останалите пари, на два реда:
o	"You don't have enough money!"
o	"You need {недостигащи пари} leva!"
*/