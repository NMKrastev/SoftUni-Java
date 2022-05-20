import java.util.Scanner;

public class FitnessCard03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double price = 0;

        if (sex.equals("m")) {
            switch (sport) {
                case "Gym":
                    price = 42;
                    break;
                case "Boxing":
                    price = 41;
                    break;
                case "Yoga":
                    price = 45;
                    break;
                case "Zumba":
                    price = 34;
                    break;
                case "Dances":
                    price = 51;
                    break;
                case "Pilates":
                    price = 39;
                    break;
            }
        } else if (sex.equals("f")) {
            switch (sport) {
                case "Gym":
                    price = 35;
                    break;
                case "Boxing":
                case "Pilates":
                    price = 37;
                    break;
                case "Yoga":
                    price = 42;
                    break;
                case "Zumba":
                    price = 31;
                    break;
                case "Dances":
                    price = 53;
                    break;
            }
        }

        if (age <= 19) {
            price = price - (price * 0.2);
        }

        if (price < budget) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", price - budget);
        }
    }
}
/*Да се напише програма, която проверява дали първоначално налична сума е достатъчна, за да се заплати карта
за месечен достъп във фитнес.
Цената на картата зависи от пола на клиента и спорта, който практикува:
Пол	        Gym	    Boxing	Yoga	Zumba	Dances	Pilates
мъж	        $42 	$41 	$45	    $34	    $51	    $39
жена	    $35 	$37	    $42	    $31	    $53	    $37

Всички цени на карти за ученици (възраст под 19 години вкл.) са с 20% намаление.
Вход
От конзолата се прочитат 4 реда:
•	Сумата, с която разполагаме - реално число в интервала [10.00…1000.00]
•	Пол - символ ('m' за мъж и 'f' за жена)
•	Възраст - цяло число в интервала [5…105]
•	Спорт - текст (една от възможностите в таблицата)
Изход
На конзолата се отпечатва 1 ред:
•	Ако сумата е достатъчна:
"You purchased a 1 month pass for {sport}."
където {sport} е въведения тип спорт
•	Ако сумата не е достатъчна трябва да се пресметне колко още пари са необходими, за да се закупи карта:
"You don't have enough money! You need ${money} more."
където {money} e оставащата сума нужна, за да се закупи картата, форматирана до втория знак след десетичната запетая.
*/