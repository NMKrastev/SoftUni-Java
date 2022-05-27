import java.util.Scanner;

public class Club04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String cocktail = scanner.nextLine();
        double totalIncome = 0;
        boolean isEnough = false;

        while (!cocktail.equals("Party!")) {

            int cocktailsNum = Integer.parseInt(scanner.nextLine());
            double price = cocktailsNum * cocktail.length();

            if (price % 2 != 0) {
                price = price - (price * 0.25);
                totalIncome += price;
            } else {
                totalIncome += price;
            }

            if (totalIncome >= budget){
                isEnough = true;
                break;
            }

            cocktail = scanner.nextLine();

        }

        if (isEnough) {
            System.out.printf("Target acquired.\nClub income - %.2f leva.", totalIncome);
        } else {
            System.out.printf("We need %.2f leva more.\n" +
                    "Club income - %.2f leva.\n", budget - totalIncome, totalIncome);
        }

    }
}
/*Времето се затопля и клубовете пускат обещаващи промоции. Напише програма, която да изчислява приходите на един клуб
за вечерта и дали е достигната желаната печалба, като знаете следните условия: цената на един коктейл е дължината на
неговото име. Ако цената на една поръчка е нечетно число, има 25% отстъпка от цената на поръчката.
Вход
От конзолата се четат:
•	На първия ред – желаната печалба на клуба - реално число в интервала [1.00... 15000.00]
Поредица от два реда до получаване на командата "Party!" или до достигане на желаната печалба:
o	Име на коктейла – текст
o	Брой на коктейлите за поръчката – цяло число в интервала [1… 50]
Изход
На конзолата първо да се отпечата един ред:
•	При получена команда "Party!":
 "We need {недостигаща сума} leva more."
•	При достигане на желаната печалба:
	"Target acquired."
След това да се отпечата:
	"Club income - {приходи от клуба} leva."
Парите да бъдат форматирани до втората цифра след десетичния знак.
*/