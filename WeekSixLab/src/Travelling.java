import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();


        while (!destination.equals("End")) {

            double budget = Double.parseDouble(scanner.nextLine());
            double totalMoney = 0;

            while (totalMoney < budget) {
                Double money = Double.parseDouble(scanner.nextLine());
                totalMoney += money;
            }

            System.out.printf("Going to %s!\n", destination);
            destination = scanner.nextLine();

        }

    }
}
/*Ани обича да пътува и иска тази година да посети няколко различни дестинации. Като си избере дестинация,
ще прецени колко пари ще й трябват, за да отиде до там и ще започне да спестява. Когато е спестила
достатъчно, ще може да пътува.
От конзолата всеки път ще се четат първо дестинацията и минималния бюджет, който ще е нужен за пътуването,
реално число.
След това ще се четат няколко суми, реални числа, които Ани спестява като работи и когато успее да събере
достатъчно за пътуването, ще заминава, като на конзолата трябва да се изпише:
 "Going to {дестинацията}!"
Когато е посетила всички дестинации, които иска, вместо дестинация ще въведе "End" и програмата ще приключи.
*/