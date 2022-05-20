import java.util.Scanner;

public class EasterParty02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalPrice = 0, cake = 0;
        int guests = Integer.parseInt(scanner.nextLine());
        double pricePerPerson = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        cake = budget * 0.1;

        if (guests >= 10 && guests <= 15) {
            totalPrice = (guests * (pricePerPerson - (pricePerPerson * 0.15))) + cake;
        } else if (guests > 15 && guests <= 20) {
            totalPrice = (guests * (pricePerPerson - (pricePerPerson * 0.20))) + cake;
        } else if (guests > 20) {
            totalPrice = (guests * (pricePerPerson - (pricePerPerson * 0.25))) + cake;
        } else {
            totalPrice = guests * pricePerPerson + cake;
        }

        if (budget >= totalPrice) {
            System.out.printf("It is party time! %.2f leva left.", budget - totalPrice);
        } else {
            System.out.printf("No party! %.2f leva needed.", totalPrice - budget);
        }

    }
}
/*Деси има рожден ден на Великден и иска да организира парти за своите приятели. Тя знае какъв е броят гости,
 които иска да покани и колко е кувертът за всеки гост. От броя гости зависи и каква отстъпка ще получи за
 куверта за един човек.
Ако покани:
•	Между 10 (вкл.) и 15 (вкл.) човека -> 15 % отстъпка от куверта за един човек
•	Между 15 и 20 (вкл.) човека -> 20 % отстъпка от куверта за един човек
•	Над 20 човека -> 25 % отстъпка от куверта за един човек
Деси трябва да предвиди и закупуването на торта за партито. Цената на тортата е 10% от бюджета на Деси.
Напишете програма, която изчислява дали бюджетът на Деси ще и е достатъчен за партито.
Вход
От конзолата се четат 3 реда:
1.	Брой гости – цяло число в интервала [1...99]
2.	Цена на куверт за един човек – реално число в интервала [0.00 … 99.00]
3.	Бюджетът на Деси  – реално число в интервала [0.00 … 9999.00]
Изход
На конзолата да се отпечата един ред:
•	Ако бюджетът  е достатъчен:
o	"It is party time! {останали пари} leva left."
•	Ако бюджетът не е достатъчен:
o	"No party! {недостигащи пари} leva needed."
Резултатът да бъде форматиран до втория знак след десетичната запетая.
*/