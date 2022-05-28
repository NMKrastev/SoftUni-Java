import java.util.Scanner;

public class HairSalon05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int priceGoal = Integer.parseInt(scanner.nextLine());
        int currentMoney = 0;
        boolean isClosed = false;

        while (currentMoney < priceGoal) {

            String service = scanner.nextLine();
            if (service.equals("closed")) {
                isClosed = true;
                break;
            } else {
                String serviceType = scanner.nextLine();

                switch (service) {
                    case "haircut":
                        if (serviceType.equals("mens")) {
                            currentMoney += 15;
                        } else if (serviceType.equals("ladies")) {
                            currentMoney += 20;
                        } else if (serviceType.equals("kids")) {
                            currentMoney += 10;
                        }
                        break;
                    case "color":
                        if (serviceType.equals("touch up")) {
                            currentMoney += 20;
                        } else if (serviceType.equals("full color")) {
                            currentMoney += 30;
                        }
                        break;
                }
            }
        }
        if (isClosed) {
            System.out.printf("Target not reached! You need %dlv. more.\n" +
                    "Earned money: %dlv.\n", priceGoal - currentMoney, currentMoney);
        } else {
            System.out.printf("You have reached your target for the day!\n" +
            "Earned money: %dlv.", currentMoney);
        }
    }
}
/*Деси има фризьорски салон в София. Тя всеки ден си поставя за цел да постигне определена печалба.
Напишете програма, която изчислява дали е успяла да постигне целта за деня, като знаете следното:
Деси ще приема клиенти докато не приключи работния ден. Ако постигне желания приход обаче, тя ще
затвори салона. Когато клиент влезе ще може да си избере една от следните услуги:
•	Подстригване (haircut):
o	Мъжко (mens) - 15лв.
o	Дамско (ladies) – 20лв.
o	Детско (kids) – 10лв.
•	Боядисване (color):
o	Поддръжка (touch up) – 20лв.
o	Пълно боядисване (full color) – 30лв.
Вход:
От конзолата първоначално се чете 1 ред:
•	цел за деня – цяло число в интервала [1 … 5000]
След това се четат поредица от редове до получаване на команда "closed" или докато Деси не постигне
целта за деня – услугата, която иска клиентът – текст с възможности "haircut" и "color".
При команда "haircut" ще се очаква да се въведе видът на подстригването – "mens", "ladies" или "kids".
При команда "color" ще се очаква видът на боядисването – "touch up" или "full color".
Изход:
На конзолата се отпечатват 2 реда:
•	На първия ред:
o	Ако Деси е успяла да постигне целта за деня:
"You have reached your target for the day!"
o	Ако Деси не е успяла да постигне целта за деня:
"Target not reached! You need {колко пари не и достигат, за да стигне целта}lv. more."
•	На втория ред:
	"Earned money: {парите, които е спечелила за деня}lv."
*/