import java.util.Scanner;

public class FamilyTrip2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine()) / 100;

        if (nights > 7) {
            pricePerNight = pricePerNight - (pricePerNight * 0.05);
        }
        double totalPrice = (nights * pricePerNight) + (budget * percent);
        if (totalPrice <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - totalPrice);
        } else {
            System.out.printf("%.2f leva needed.", totalPrice - budget);
        }

    }
}
/*Семейство Иванови планират семейната си почивка. Вашата задача е да напишете програма, която да изчислява
дали предвидения от тях бюджет ще им стигне, като знаете колко нощувки са планирали, каква е цената за нощувка
и колко процента от бюджета са предвидили за допълнителни разходи. Трябва да се има предвид, че ако броят на
нощувките е по-голям от 7, цената за нощувка се намаля с 5%.
Вход
От конзолата се четат 4 реда:
•	Бюджетът, с който разполагат – реално число в интервала [1.00 … 10000.00]
•	Брой нощувки – цяло число в интервала [0 … 1000]
•	Цена за нощувка – реално число в интервала [1.00 … 500.00]
•	Процент за допълнителни разходи – цяло число в интервала [0 … 100]
Изход
Отпечатването на конзолата зависи от резултата:
•	Ако сумата е достатъчна:
o	"Ivanovi will be left with {останали пари след почивката} leva after vacation."
•	Ако НЕ е достигната сумата:
o	"{парите нужни до достигане на целта} leva needed."
Сума трябва да се форматира до втората цифра след десетичния знак.
*/