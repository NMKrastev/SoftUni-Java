import java.util.Scanner;

public class MovieStars04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double actorPay;
        double totalMoney = budget;
        boolean noMoney = false;

        while (!input.equals("ACTION")) {

            if (input.length() <= 15) {
                actorPay = Double.parseDouble(scanner.nextLine());
                totalMoney -= actorPay;
            } else {
                totalMoney -= totalMoney * 0.2;
            }
            if (totalMoney <= 0) {
                noMoney = true;
                break;
            }

            input = scanner.nextLine();
        }
        if (noMoney) {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(totalMoney));
        } else {
            System.out.printf("We are left with %.2f leva.", totalMoney);
        }
    }
}
/*Счетоводителят на киноцентър "Тинтява 15" ви наема да напишете програма, която пресмята хонорарите за актьорите.
Всяка продукция има бюджет за актьори. До команда "ACTION" ще получавате име на актьор и възнаграждението му.
Ако името на актьора е по-дълго от 15 символа възнаграждението му ще е 20 % от останалия бюджет до момента.
Ако бюджета в даден момент свърши, програмата трябва да прекъсне.
Вход
От конзолата първо се чете един ред:
•	Бюджет за актьори - реално число в интервала [1000.0... 2 100 000.0]
След това се четат многократно по един или два реда до команда "ACTION" или до изчерпване на бюджета:
•	Име на актьор - текст
Ако името на актьора съдържа по-малко или равно на 15 брой символи:
o	Възнаграждение - реално число в интервала [250.0… 1 000 000.0]
Изход
На конзолата да се отпечата един ред:
•	Ако бюджета е достатъчен :
             "We are left with {останал бюджет} leva."
•	Ако бюджета не е достатъчен:
	"We need {необходим бюджет} leva for our actors."
Резултата да се форматира до втората цифра след десетичния знак!
*/