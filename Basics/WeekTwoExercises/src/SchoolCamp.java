import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine().toLowerCase();
        String groupType = scanner.nextLine().toLowerCase();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        String sport = "";

        if (groupType.equals("boys")) {
            switch (season) {
                case "winter":
                    price = studentsCount * 9.60 * nights;
                    sport = "Judo";
                    break;
                case "spring":
                    price = studentsCount * 7.20 *nights;
                    sport = "Tennis";
                    break;
                case "summer":
                    price = studentsCount * 15 * nights;
                    sport = "Football";
                    break;
            }
        } else if (groupType.equals("girls")) {
            switch (season) {
                case "winter":
                    price = studentsCount * 9.60 * nights;
                    sport = "Gymnastics";
                    break;
                case "spring":
                    price = studentsCount * 7.20 * nights;
                    sport = "Athletics";
                    break;
                case "summer":
                    price = studentsCount * 15 * nights;
                    sport = "Volleyball";
                    break;
            }
        }else {
            switch (season) {
                case "winter":
                    price = studentsCount * 10 * nights;
                    sport = "Ski";
                    break;
                case "spring":
                    price = studentsCount * 9.50 * nights;
                    sport = "Cycling";
                    break;
                case "summer":
                    price = studentsCount * 20 * nights;
                    sport = "Swimming";
                    break;
            }
        }

        if (studentsCount >= 50) {
            price = price - (price * 0.5);
        } else if (studentsCount >= 20 && studentsCount < 50) {
            price = price - (price * 0.15);
        } else if (studentsCount >= 10 && studentsCount < 20) {
            price = price - (price * 0.05);
        }

        System.out.printf("%s %.2f lv.", sport, price);
    }
}
/*Частно училище организира лагери за учениците по време на ваканциите.
В зависимост от вида на ваканцията (пролетна, лятна или зимна) и вида на групата (момчета/момичета или смесена)
 цената на нощувката в хотела е различна, както и спортът, който ще практикуват учениците.
	            Зимна ваканция	Пролетна ваканция	Лятна ваканция
момчета/момичета	9.60	        7.20	            15
смесена група	    10	            9.50	            20
Училището получава отстъпка от крайната цена, в зависимост от броя на настанените в хотела ученици:
•	Ако броят на учениците е 50 или повече, училището получава 50% отстъпка
•	Ако броят на учениците е 20 или повече и в същото време по-малък от 50, училището получава 15% отстъпка
•	Ако броят на учениците е 10 или повече и в същото време по-малък от 20, училището получава 5% отстъпка
Да се напише програма, която пресмята цената, която ще заплати училището за нощувките и принтира спорта,
който ще се практикува от учениците.
Вход
От конзолата се четат 4 реда:
1.	Сезонът – текст - “Winter”, “Spring” или “Summer”;
2.	Видът на групата – текст - “boys”, “girls” или “mixed”;
3.	Брой на учениците – цяло число в интервала [1 … 10000];
4.	Брой на нощувките – цяло число в интервала [1 … 100].
Изход
На конзолата се отпечатва 1 ред:
•	Спортът, който са практикували учениците и цената за нощувките, която е заплатило училището,
форматирана до втория знак след десетичната запетая, в следния формат:
"{спортът} {цената} lv.“
*/