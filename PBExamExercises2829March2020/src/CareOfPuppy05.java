import java.util.Scanner;

public class CareOfPuppy05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalFoodEaten = 0;
        int food = 1000 * Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Adopted")) {

            double foodPerDay = Double.parseDouble(input);
            totalFoodEaten += foodPerDay;

            input = scanner.nextLine();

        }

        if (totalFoodEaten > food) {
            System.out.printf("Food is not enough. You need %.0f grams more.", totalFoodEaten - food);
        } else {
            System.out.printf("Food is enough! Leftovers: %.0f grams.", food - totalFoodEaten);
        }
    }
}
/*Ани намира кученце, за което ще се грижи, докато се намери някой да го осинови.
То изяжда дневно определено количество храна. Да се напише програма, която проверява дали количеството храна,
което е закупено за кученцето, ще е достатъчно докато кученцето бъде осиновено.
Вход
От конзолата се прочитат:
•	Закупеното количество храна за кученцето в килограми – цяло число в интервала [1 …100]
•	На всеки следващ ред до получаване на команда Adopted ще получавате колко грама изяжда кученцето на всяко хранене - цяло число в интервала [10 …1000]
Изход
На конзолата се отпечатва 1 ред:
•	Ако количеството храна е достатъчно да се отпечата:
 	"Food is enough! Leftovers: {останала храна} grams."
•	Ако количеството храна не е достатъчно да се отпечата:
 	"Food is not enough. You need {нужно количество храна} grams more."
*/