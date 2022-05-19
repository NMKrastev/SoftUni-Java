import java.util.Scanner;

public class AgencyProfit01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int ticketsAdults = Integer.parseInt(scanner.nextLine());
        int ticketsKids = Integer.parseInt(scanner.nextLine());
        double priceAdults = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());
        double priceKids = priceAdults - (priceAdults * 0.7);
        double totalPrice = ((ticketsAdults * priceAdults) + (ticketsKids * priceKids)) + ((ticketsAdults + ticketsKids) * commission);
        double agencyProfit = totalPrice * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", name, agencyProfit);

    }
}
/*Напишете програма, която изчислява печалбата на агенция за продажба на самолетни билети. Агенцията продава самолетни
билети на различни авиокомпании. Ще получите информация за броя продадени билети за възрастни
и броя продадени детски билети. Нетната цена на билета за възрастен се определя от авиокомпанията,
а детският билет е със 70% по-евтин. Агенцията добавя към нетната цена на всеки билет такса обслужване.
Крайната печалба на Агенцията е 20% от общата цена на всички билети.
Вход:
От конзолата се четат 5 реда:
1.	Име на авиокомпанията - текст
2.	Брой билети за	 възрастни – цяло число в диапазона [1…400]
3.	Брой детски билети – цяло число в диапазона [25…120]
4.	Нетна цена на билет за възрастен – реално число в диапазона [100.0…1600.0]
5.	Цената на такса обслужване - реално число в диапазона [10.0…50.0]
Изход:
Да се отпечата на конзолата крайната печалбата от продажбите, в следния формат:
•	"The profit of your agency from {име на авиокомпанията} tickets is {печалба за агенцията} lv."
Цената на печалбата да бъде форматирана до втората цифра след десетичния знак.
*/