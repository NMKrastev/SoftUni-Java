import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int chrysanthemumsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int tulipsCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        String holiday = scanner.nextLine().toLowerCase();
        double totalPrice = 0;
        //        double chrysanthemumsPrice = 0;
//        double rosesPrice = 0;
//        double tulipsPrice = 0;

        if (holiday.equals("y")) {

            switch (season) {
                case "spring":
                case "summer":
                    totalPrice = ((chrysanthemumsCount * 2.00) + (rosesCount * 4.10) +
                            (tulipsCount * 2.50));
                    totalPrice = totalPrice + (totalPrice * 0.15);
                    break;
                case "autumn":
                case "winter":
                    totalPrice = ((chrysanthemumsCount * 3.75) + (rosesCount * 4.5) +
                            (tulipsCount * 4.15));
                    totalPrice = totalPrice + (totalPrice * 0.15);
                    break;
            }
        } else {
            switch (season) {
                case "spring":
                case "summer":
                    totalPrice = ((chrysanthemumsCount * 2.00) + (rosesCount * 4.10) +
                            (tulipsCount * 2.50));
                    break;
                case "autumn":
                case "winter":
                    totalPrice = ((chrysanthemumsCount * 3.75) + (rosesCount * 4.50) +
                            (tulipsCount * 4.15));
                    break;
            }
        }

        if (tulipsCount > 7 && season.equals("spring")) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
        if (rosesCount >= 10 && season.equals("winter")) {
            totalPrice = totalPrice - (totalPrice * 0.1);
        }
        if (chrysanthemumsCount + rosesCount + tulipsCount > 20) {
            totalPrice = totalPrice - (totalPrice * 0.20);
        }
            System.out.printf("%.2f", totalPrice + 2);
    }
}
/*Магазин за цветя предлага 3 вида цветя: хризантеми, рози и лалета. Цените зависят от сезона.
Сезон	        Хризантеми	        Рози	        Лалета
Пролет / Лято	2.00 лв./бр.	4.10 лв./бр.	2.50 лв./бр.
Есен / Зима	    3.75 лв./бр.	4.50 лв./бр.	4.15 лв./бр.
В празнични дни цените на всички цветя се увеличават с 15%. Предлагат се следните отстъпки:
•	За закупени повече от 7 лалета през пролетта – 5% от цената на целият букет.
•	За закупени 10 или повече рози през зимата – 10% от цената на целият букет.
•	За закупени повече от 20 цветя общо през всички сезони – 20% от цената на целият букет.
Отстъпките се правят по така написания ред и могат да се наслагват! Всички отстъпки важат след
оскъпяването за празничен ден!
Цената за аранжиране на букета винаги е 2лв. Напишете програма, която изчислява цената за един букет.
Вход
Входът се чете от конзолата и съдържа точно 5 реда:
•	На първия ред е броят на закупените хризантеми – цяло число в интервала [0 ... 200]
•	На втория ред е броят на закупените рози – цяло число в интервала [0 ... 200]
•	На третия ред е броят на закупените лалета – цяло число в интервала [0 ... 200]
•	На четвъртия ред е посочен сезона – [Spring, Summer, Аutumn, Winter]
•	На петия ред е посочено дали денят е празник – [Y – да / N - не]
Изход
Да се отпечата на конзолата 1 число – цената на цветята, форматирана до вторият знак след десетичната запетая.
*/