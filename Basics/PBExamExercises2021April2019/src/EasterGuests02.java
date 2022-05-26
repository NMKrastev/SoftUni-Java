import java.util.Scanner;

public class EasterGuests02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double easterBread = (double) guests / 3;
        int eggs = guests * 2;
        double priceBread = Math.ceil(easterBread) * 4;
        double priceEggs = eggs * 0.45;
        double totalPrice = priceBread + priceEggs;

        if (budget >= totalPrice) {
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs.\n" +
                    "He has %.2f lv. left.", Math.ceil(easterBread), eggs, budget - totalPrice);
        } else {
            System.out.printf("Lyubo doesn't have enough money.\n" +
                    "He needs %.2f lv. more.", totalPrice - budget);
        }

    }
}
/*Любо очаква гости за Великден. Той разполага с определен бюджет, който е предвидил, за да купи козунаци и
боядисани яйца. Известно е, че един козунак стига за трима човека, като всеки гост ще получи и по 2 яйца.
Вашата задача е да намерите колко козунака и яйца трябва да купи Любо, както и каква ще е сумата,
която той трябва да плати и дали бюджета му е достатъчен. При изчисляването на броя козунаци,
които Любо трябва да закупи, техният брой трябва да се закръгли към по-голямото цяло число.
Ако парите не му стигат, трябва да се изведе съобщение, колко не му достигат.
Известно е, че:
•	Един козунак струва 4лв.
•	Едно яйце струва 0.45лв.
Вход
От конзолата се четат 2 реда:
•	На първия ред са броят на гостите – цяло число в интервала [0 ... 200000]
•	На втория ред е бюджетът с който разполага Любо  – цяло число в интервала [0 ... 200000]
Изход
На конзолата да се отпечатат два реда:
•	Ако бюджетът е достатъчен:
o	"Lyubo bought {брои закупени козунаци} Easter bread and {брои закупени яйца} eggs."
o	"He has {останали пари} lv. left."
•	Ако  бюджетът НЕ Е достатъчен:
o	"Lyubo doesn't have enough money."
o	"He needs {недостигащи пари} lv. more."
Парите да бъдат форматирани до втората цифра след десетичния знак.
*/