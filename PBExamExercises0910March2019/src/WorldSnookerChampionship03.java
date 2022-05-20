import java.util.Scanner;

public class WorldSnookerChampionship03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalMoney = 0;
        String stage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        String photo = scanner.nextLine();

        switch (stage) {
            case "Quarter final":
                switch (ticketType) {
                    case "Standard":
                        totalMoney = tickets * 55.50;
                        break;
                    case "Premium":
                        totalMoney = tickets * 105.20;
                        break;
                    case "VIP":
                        totalMoney = tickets * 118.90;
                        break;
                }
                break;
            case "Semi final":
                switch (ticketType) {
                    case "Standard":
                        totalMoney = tickets * 75.88;
                        break;
                    case "Premium":
                        totalMoney = tickets * 125.22;
                        break;
                    case "VIP":
                        totalMoney = tickets * 300.40;
                        break;
                }
                break;
            case "Final":
                switch (ticketType) {
                    case "Standard":
                        totalMoney = tickets * 110.10;
                        break;
                    case "Premium":
                        totalMoney = tickets * 160.66;
                        break;
                    case "VIP":
                        totalMoney = tickets * 400;
                        break;
                }
                break;
        }

        if (totalMoney > 2500 && totalMoney <= 4000) {
            totalMoney = totalMoney - (totalMoney * 0.1);
            if (photo.equals("Y")) {
                totalMoney += tickets * 40;
            }
        } else if (totalMoney > 4000) {
            totalMoney = totalMoney - (totalMoney * 0.25);

        } else if (totalMoney <= 2500) {
            if (photo.equals("Y")) {
                totalMoney += tickets * 40;
            }
        }

        System.out.printf("%.2f", totalMoney);

    }
}
/*С наближаването на световното първенство по снукър в театъра Крусибъл в Шефилд, Англия, феновете нямат
търпение да се сдобият с ценните билети. Заради големия наплив от хора, организаторите ви молят да
напишете програма за продаване на билети, като се има предвид следния ценоразпис:
	            Четвъртфинал	    Полуфинал	    Финал
Стандартен	    55.50 £/бр.	        75.88 £/бр. 	110.10 £/бр.
Премиум	        105.20 £/бр.	    125.22 £/бр.	160.66 £/бр.
ВИП	            118.90 £/бр.	    300.40 £/бр.	400 £/бр.
При закупуване на билет, зрителят може да избере опция, снимка с трофея, на цена 40 лири.
При достигане на определена сума има отстъпки:
•	Над 4000 лири има 25% отстъпка и безплатни снимки с трофея (ако  опцията за снимки е избрана,
таксата от 40 лири за билет не се включва)
•	Над 2500 лири има 10% отстъпка
При избрана опция за снимки с трофея, цената се начислява след изчисляването на отстъпките.
Вход
От конзолата се четат 3 реда:
1.	Етап на първенството – текст - “Quarter final”, “Semi final” или “Final”
2.	Вид на билета – текст - “Standard”, “Premium” или “VIP”
3.	Брой билети – цяло число в интервала [1 … 30]
4.	Снимка с трофея – символ – 'Y' (да) или 'N' (не)
Изход
На конзолата се отпечатва 1 ред:
•	"Цената, която трябва да се заплати, форматирана до втората цифра след десетичния знак"
*/