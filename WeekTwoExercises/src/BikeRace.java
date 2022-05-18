import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int juniorCount = Integer.parseInt(scanner.nextLine());
        int seniorCount = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine().toLowerCase();
        //double taxJunior = 0;
        //double taxSenior = 0;
        double totalTax = 0;

        switch (trackType) {
            case "trail":
                totalTax = juniorCount * 5.50 + seniorCount * 7;
                break;
            case "cross-country":
                totalTax = juniorCount * 8 + seniorCount * 9.50;
                break;
            case "downhill":
                totalTax = juniorCount * 12.25 + seniorCount * 13.75;
                break;
            case "road":
                totalTax = juniorCount * 20 + seniorCount * 21.50;
                break;
        }

        if (trackType.equals("cross-country") && juniorCount + seniorCount >= 50) {
            totalTax = totalTax - (totalTax * 0.25);
            totalTax = totalTax - (totalTax * 0.05);
        } else {
            totalTax = totalTax - (totalTax * 0.05);
        }

        System.out.printf("%.2f", totalTax);

    }
}
/*Ако в "cross-country" състезанието се съберат 50 или повече участника(общо младши и старши),
таксата  намалява с 25%. Организаторите отделят 5% процента от събраната сума за разходи.
Група	trail	cross-country	downhill	road
juniors	5.50	    8	          12.25 	20
seniors	  7	        9.50	      13.75	    21.50

Вход
От конзолата се четат 2 числа и един стринг, всяко на отделен ред:
•	Първият ред – броят младши велосипедисти. Цяло число в интервала [1…100]
•	Вторият ред – броят старши велосипедисти. Цяло число в интервала [1… 100]
•	Третият ред – вид трасе – "trail", "cross-country", "downhill" или "road"
Изход
Да се отпечата на конзолата едно число:
"{дарената сума}" - форматирана с точност до 2 знака след десетичната запетая.
*/