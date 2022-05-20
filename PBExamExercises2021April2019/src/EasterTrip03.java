import java.util.Scanner;

public class EasterTrip03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = 0;
        String destination = scanner.nextLine();
        String period = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        if (destination.equals("France")) {
            switch (period) {
                case "21-23":
                    price = 30;
                    break;
                case "24-27":
                    price = 35;
                    break;
                case "28-31":
                    price = 40;
                    break;
            }
        } else if (destination.equals("Italy")) {
            switch (period) {
                case "21-23":
                    price = 28;
                    break;
                case "24-27":
                    price = 32;
                    break;
                case "28-31":
                    price = 39;
                    break;
            }
        } else if (destination.equals("Germany")) {
            switch (period) {
                case "21-23":
                    price = 32;
                    break;
                case "24-27":
                    price = 37;
                    break;
                case "28-31":
                    price = 43;
                    break;
            }
        }

        System.out.printf("Easter trip to %s : %.2f leva.", destination, nights * price);

    }
}
/*По време на Великденските празници, Деси иска да отиде на почивка. В таблицата са показани кои са дестинациите
 и каква е цената за нощувка спрямо датите, през които си е резервирала екскурзията.
Дестинация	    21-23 март	    24-27 март	    28-31 март
Франция	        30 лв.	        35 лв.	        40 лв.
Италия	        28 лв.	        32 лв.      	39 лв.
Германия	    32 лв.	        37 лв.      	43 лв.
Напишете програма, която изчислява колко ще струва екскурзията на Деси, като знаете дестинацията,
на която иска да отиде, кога си е резервирала екскурзията и за колко нощувки ще е в дадената страна.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред - дестинация - текст с възможности"France", "Italy" или "Germany"
•	Втори ред - дати, през които си е резервирала екскурзията - текст  с възможности "21-23",
"24-27" или "28-31"
•	Трети ред - брой нощувки - цяло число в интервала [1… 100]
Изход
На конзолата трябва да се отпечата един ред:
"Easter trip to {дестинация} : {разходи за екскурзията} leva."
Разходите за екскурзията да бъдат форматирани до втората цифра след десетичния знак
*/