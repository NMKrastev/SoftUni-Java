import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine().toLowerCase();
        int nightsCount = Integer.parseInt(scanner.nextLine());
        double nightsPriceStudio = 0;
        double nightsPriceApart = 0;
        //double discountPriceStudio = 0;
        //double discountPriceApart = 0;

        switch (month) {

            case "may":
            case "october":
                nightsPriceStudio = nightsCount * 50;
                nightsPriceApart = nightsCount * 65;
                if (nightsCount > 7 && nightsCount <= 14) {
                    nightsPriceStudio = nightsPriceStudio - (nightsPriceStudio * 0.05);
                } else if (nightsCount > 14) {
                    nightsPriceStudio = nightsPriceStudio - (nightsPriceStudio * 0.30);
                    nightsPriceApart = nightsPriceApart - (nightsPriceApart * 0.10);
                }
                break;
            case "june":
            case "september":
                nightsPriceStudio = nightsCount * 75.20;
                nightsPriceApart = nightsCount * 68.70;
                if (nightsCount > 14) {
                    nightsPriceStudio = nightsPriceStudio - (nightsPriceStudio * 0.20);
                    nightsPriceApart = nightsPriceApart - (nightsPriceApart * 0.10);
                }
                break;
            case "july":
            case "august":
                nightsPriceStudio = nightsCount * 76;
                nightsPriceApart = nightsCount * 77;
                if (nightsCount > 14) {
                    nightsPriceApart = nightsPriceApart - (nightsPriceApart * 0.10);
                }
                break;
        }
        System.out.printf("Apartment: %.2f lv.\nStudio: %.2f lv.", nightsPriceApart, nightsPriceStudio);
    }
}
/*Хотел предлага 2 вида стаи: студио и апартамент. Напишете програма, която изчислява цената за целия
престой за студио и апартамент. Цените зависят от месеца на престоя:
                Май и октомври	Юни и септември	                Юли и август
Студио –        50 лв./нощувка	Студио – 75.20 лв./нощувка	    Студио – 76 лв./нощувка
Апартамент –    65 лв./нощувка	Апартамент – 68.70 лв./нощувка	Апартамент – 77 лв./нощувка
Предлагат се и следните отстъпки:
•	За студио, при повече от 7 нощувки през май и октомври : 5% намаление.
•	За студио, при повече от 14 нощувки през май и октомври : 30% намаление.
•	За студио, при повече от 14 нощувки през юни и септември: 20% намаление.
•	За апартамент, при повече от 14 нощувки, без значение от месеца : 10% намаление.
Вход
Входът се чете от конзолата и съдържа точно 2 реда, въведени от потребителя:
•	На първия ред е месецът – May, June, July, August, September или October
•	На втория ред е броят на нощувките – цяло число в интервала [0 ... 200]
Изход
Да се отпечатат на конзолата 2 реда:
•	На първия ред: “Apartment: {цена за целият престой} lv.”
•	На втория ред: “Studio: {цена за целият престой} lv.“
Цената за целия престой форматирана с точност до два знака след десетичната запетая.
*/