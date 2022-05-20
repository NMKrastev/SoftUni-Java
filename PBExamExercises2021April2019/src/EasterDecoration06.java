import java.util.Scanner;

public class EasterDecoration06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int itemsCount = 0;
        double priceForPerson = 0, totalPrice = 0;
        int clients = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < clients; i++) {

            String input = scanner.nextLine();

            while (!input.equals("Finish")) {

                if (input.equals("basket")) {
                    priceForPerson += 1.50;
                    itemsCount++;
                } else if (input.equals("wreath")) {
                    priceForPerson += 3.80;
                    itemsCount++;
                } else if (input.equals("chocolate bunny")) {
                    priceForPerson += 7;
                    itemsCount++;
                }

                input = scanner.nextLine();

            }

            if (itemsCount % 2 == 0) {
                priceForPerson = priceForPerson - (priceForPerson * 0.2);
            }

            if (input.equals("Finish")) {
                System.out.printf("You purchased %d items for %.2f leva.\n", itemsCount, priceForPerson);
                totalPrice += priceForPerson;
                priceForPerson = 0;
                itemsCount = 0;

            }

        }

        System.out.printf("Average bill per client is: %.2f leva.\n", totalPrice / clients);

    }
}
/*За великденските празници, магазин започва да продава три вида великденска украса
– кошнички за яйца (basket), великденски венци (wreath) и шоколадови зайци
(chocolate bunny). Вашата задача е да напишете програма, която да изчислява каква
сметка трябва да плати всеки един клиент на магазина, като се има в предвид,
че всеки клиент закупил четен брой продукти, ще получи 20% отстъпка от крайната цена.
 След като всички клиенти приключат с покупките, трябва да се отпечата средно
 по колко пари е похарчил всеки човек.
Цените на продуктите са:
•	кошничка за яйца (basket) – 1.50 лв.
•	великденски венец (wreath) – 3.80 лв.
•	шоколадов заек (chocolate bunny) – 7 лв.
Вход
От конзолата първоначално се чете един ред:
•	Брои на клиентите в магазина – цяло число [1… 100]
•	След това за всеки един клиент на нов ред до получаване на командата "Finish" се чете:
o	Покупката която клиента е избрал – текст ("basket", "wreath" или "chocolate bunny")
Изход
•	При получаване на командата "Finish" да се отпечата един ред:
o	"You purchased {броя на покупките} items for {крайната цена} leva."
•	Накрая, след като всички клиенти приключат с покупките, да се отпечата на един ред
o	"Average bill per client is: {средно аритметично на парите които е похарчил всеки един клиент} leva."
Всички пари трябва да бъдат форматирани до втората цифра след десетичния знак.
*/