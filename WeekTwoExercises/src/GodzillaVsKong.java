import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double outfitPrice = Double.parseDouble(scanner.nextLine());
        double decor = budget * 0.1;
        double discount = 0;
        double totalPrice = 0;

        if (extras > 150) {
            discount = outfitPrice * 0.1;
            totalPrice = (extras * outfitPrice) - (discount * extras) + decor;
        } else {
            totalPrice = extras * outfitPrice + decor;
        }

        if (budget >= totalPrice) {
            totalPrice = budget - totalPrice;
            System.out.printf("Action!\nWingard starts filming with %.2f leva left.", totalPrice);
        } else {
            totalPrice = totalPrice - budget;
            System.out.printf("Not enough money!\nWingard needs %.2f leva more.", totalPrice);
        }

    }
}
/*Известно е, че:
•	Декорът за филма е на стойност 10% от бюджета.
•	При повече от 150 статиста,  има отстъпка за облеклото на стойност 10%.
Вход
От конзолата се четат 3 реда:
Ред 1.	Бюджет за филма – реално число в интервала [1.00 … 1000000.00]
Ред 2.	Брой на статистите – цяло число в интервала [1 … 500]
Ред 3.	Цена за облекло на един статист – реално число в интервала [1.00 … 1000.00]
Изход
На конзолата трябва да се отпечатат два реда:
•	Ако  парите за декора и дрехите са повече от бюджета:
o	"Not enough money!"
o	"Wingard needs {парите недостигащи за филма} leva more."
•	Ако парите за декора и дрехите са по малко или равни на бюджета:
o	"Action!"
o	"Wingard starts filming with {останалите пари} leva left."
Резултатът трябва да е форматиран до втория знак след десетичната запетая.
*/