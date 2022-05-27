import java.util.Scanner;

public class CinemaVoucher04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucher = Integer.parseInt(scanner.nextLine());
        String buy = scanner.nextLine();
        double totalPrice = 0;
        int ticketCount = 0, otherCount = 0;

        while (!buy.equals("End")) {

            char asciiOne = buy.charAt(0);
            char asciiTwo = buy.charAt(1);

            if (buy.length() > 8) {
                    totalPrice += asciiOne + asciiTwo;
                    ticketCount++;
                if (totalPrice > voucher) {
                    ticketCount--;
                    break;
                }
            } else {
                totalPrice += asciiOne;
                otherCount++;
                if (totalPrice > voucher) {
                    otherCount--;
                    break;
                }
            }
            buy = scanner.nextLine();
        }
        System.out.printf("%d\n%d", ticketCount, otherCount);
    }
}
/*Любо е голям почитател на киното и редовно ходи на прожекции и участва в томболи, от които често печели ваучери за кино.
Вашата задача е да напишете програма, която да изчислява колко покупки от киното може да си купи Любо със спечеленият
ваучер. Ако името на покупката съдържа повече от 8 символа, то тя е билет за филм, а нейната цена представлява сумата
на ASCII символите от първите ѝ два символа. Ако името на покупката съдържа 8 или по-малко символа, нейната цена е
равна на стойността на първия ASCII символ в името. Любо въвежда името на покупките, които желае, докато не въведе
"End" или не въведе покупка, чиято стойност е по-голяма от останалата сума на ваучера.
Вход
Първоначално се чете един ред:
•	Стойността на ваучера – цяло число в интервала [1…100000]
След това до получаване на команда "End" или до изчерпването на ваучера, се чете по един ред:
o	Покупката, която Любо е избрал – текст
Изход
Програмата приключва при въвеждане на команда "End" или при покупка чиято стойност е по-голяма от останалите пари от
ваучера. На конзолата трябва да се напечатат три реда:
•	"{брои закупени билети}"
•	"{брой закупени други покупки}"
*/