import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine().toLowerCase();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double totalPrice = 0;

        if (kmPerMonth <= 5000) {
            if (season.equals("summer")) {
                totalPrice = (kmPerMonth * 0.90) * 4;
            } else if (season.equals("winter")) {
                totalPrice = (kmPerMonth * 1.05) * 4;
            } else {
                totalPrice = (kmPerMonth * 0.75) * 4;
            }
        } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
            if (season.equals("summer")) {
                totalPrice = (kmPerMonth * 1.10) * 4;
            } else if (season.equals("winter")) {
                totalPrice = (kmPerMonth * 1.25) * 4;
            } else {
                totalPrice = (kmPerMonth * 0.95) * 4;
            }
        } else {
            totalPrice = (kmPerMonth * 1.45) * 4;
        }
        totalPrice = totalPrice - (totalPrice * 0.1);
        System.out.printf("%.2f", totalPrice);
    }
}
/*Напишете програма която пресмята колко пари ще изкара шофьор на ТИР за един сезон.
На входа програмата получава през кой сезон ще работи шофьора, както и колко километра на месец ще кара.
 Един сезон е 4 месеца. Според зависи сезона и броя километри на месец ще му се заплаща
 различна сума на километър:

	                    Пролет/Есен	    Лято	        Зима
км на месец <= 5000	    0.75 лв./км	    0.90 лв./км	    1.05 лв./км
5000 < км на месец <= 10000	0.95 лв./км	1.10 лв./км	    1.25 лв./км
10000 < км на месец <= 20000	1.45 лв./км – за който и да е сезон

След като са извадени 10% за данъци се отпечатват останалите пари.
Вход
Входът се чете от конзолата и се състои от два реда:
•	Първи ред – Сезон – текст "Spring", "Summer", "Autumn" или "Winter"
•	Втори ред –  Километри на месец – реално число в интервала [10.00...20000.00]
Изход
На конзолата трябва да се отпечатат едно число:
•	Заплатата на шофьора след данъците, форматирана до втория знак след десетичната запетая.
*/