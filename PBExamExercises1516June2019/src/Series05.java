import java.util.Scanner;

public class Series05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int showNum = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        while (showNum > 0) {
            String showName = scanner.nextLine();
            double pricePerShow = Double.parseDouble(scanner.nextLine());

            if ("Thrones".equals(showName)) {
                totalPrice += (pricePerShow - (pricePerShow * 0.5));
            } else if ("Lucifer".equals(showName)) {
                totalPrice += (pricePerShow - (pricePerShow * 0.4));
            } else if ("Protector".equals(showName)) {
                totalPrice += (pricePerShow - (pricePerShow * 0.3));
            } else if ("TotalDrama".equals(showName)) {
                totalPrice += (pricePerShow - (pricePerShow * 0.2));
            } else if ("Area".equals(showName)) {
                totalPrice += (pricePerShow - (pricePerShow * 0.1));
            } else {
                totalPrice += pricePerShow;
            }
            showNum--;
        }
        if (budget >= totalPrice) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - totalPrice);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", totalPrice - budget);
        }
    }
}
/*От телевизионна компания ви наемат да създадете програма, която да изчислява дали за клиентите ще е възможно да си
закупят желаните сериали. Разполагате с бюджет и брой сериали, които потребителят ще желае да закупи. Всеки сериал
съответно има заглавие и цена.
Някои от сериалите имат намаление:
•	Thrones – 50%
•	Lucifer – 40%
•	Protector – 30%
•	TotalDrama – 20%
•	Area – 10%
Вход
От конзолата се четат:
•	Бюджет  - реално  число в интервала [10.0… 100.0]
•	Брой сериали - n - цяло положително число в интервала [1… 10]
За всеки сериал се четат по два реда:
o	Име на сериал - текст
o	Цена за сериал -  реално  число в интервала [1.0… 15.0]
Изход
На конзолата да се изпише един ред:
•	Ако бюджета ви е по-голям или равен на цената на сериалите:
	"You bought all the series and left with {останали пари} lv."
•	Ако бюджета ви е по-малък от цената на сериалите:
	"You need {нужни пари} lv. more to buy the series!"
Резултатът да бъде закръглен до втората цифра след десетичния знак.
*/