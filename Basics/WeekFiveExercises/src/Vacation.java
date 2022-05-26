import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int spendCount = 0, daysPast = 0;

        while (availableMoney < moneyNeeded && spendCount < 5) {
            String command = scanner.nextLine();
            Double money = Double.parseDouble(scanner.nextLine());
            daysPast++;

            if (command.equals("save")) {
                availableMoney += money;
                spendCount = 0;
            } else if (command.equals("spend")) {
                availableMoney -= money;
                spendCount++;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
            }

        }

        if (availableMoney >= moneyNeeded) {
            System.out.printf("You saved the money for %d days.", daysPast);
        }
        if (spendCount == 5) {
            System.out.printf("You can't save the money.\n%d\n", daysPast);
        }
    }
}
/*Джеси е решила да събира пари за екскурзия и иска от вас да ѝ помогнете да разбере дали ще успее да
събере необходимата сума. Тя спестява или харчи част от парите си всеки ден. Ако иска да похарчи повече
от наличните си пари, то тя ще похарчи всичките и ще ѝ останат 0 лева.
Вход
От конзолата се четат:
•	Пари нужни за екскурзията - реално число в интервала [1.00…25000.00]
•	Налични пари - реално число в интервала [0.00...25000.00]
След това многократно се четат по два реда:
•	Вид действие - текст с възможности "spend" и "save"
•	Сумата, която ще спести/похарчи - реално число в интервала [0.01…25000.00]
Изход
Програмата трябва да приключи при следните случаи:
•	Ако 5 последователни дни Джеси само харчи, на конзолата да се изпише:
o	"You can't save the money."
o	"{Общ брой изминали дни}"
•	Ако Джеси събере парите за почивката на конзолата се изписва:
o	"You saved the money for {общ брой изминали дни} days."
*/