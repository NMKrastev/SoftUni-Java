import java.util.Scanner;

public class GodzillavsKong02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double pricePerExtra = Double.parseDouble(scanner.nextLine());
        double decor = budget * 0.1;

        if (extras > 150) {
            pricePerExtra = pricePerExtra - (pricePerExtra * 0.1);
        }

        double totalPrice = (extras * pricePerExtra) + decor;

        if (totalPrice <= budget) {
            System.out.printf("Action!\n" +
                    "Wingard starts filming with %.2f leva left.", budget - totalPrice);
        } else {
            System.out.printf("Not enough money!\n" +
                    "Wingard needs %.2f leva more.", totalPrice - budget);
        }
    }
}
/*Снимките за дългоочаквания филм "Годзила срещу Конг" започват. Сценаристът Адам Уингард ви моли да
напишете програма, която да изчисли, дали предвидените средства са достатъчни за снимането на филма.
За снимките  ще бъдат нужни определен брой статисти, облекло за всеки един статист и декор.
Известно е, че:
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