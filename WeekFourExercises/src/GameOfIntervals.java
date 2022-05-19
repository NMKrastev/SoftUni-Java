import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());
        double percent0To9 = 0, percent10To19 = 0, percent20To29 = 0, percent30To39 = 0,
                percent40To49 = 0, invalidNumber = 0, result = 0;

        for (int i = 0; i < moves; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            if (number >= 0 && number < 10) {
                percent0To9++;
                result += (number * 0.2);
            } else if (number >= 10 && number < 20) {
                percent10To19++;
                result += (number * 0.3);
            } else if (number >= 20 && number < 30) {
                percent20To29++;
                result += (number * 0.4);
            } else if (number >= 30 && number < 40) {
                percent30To39++;
                result += 50;
            } else if (number >= 40 && number <= 50) {
                percent40To49++;
                result += 100;
            } else {
                invalidNumber++;
                result -= result / 2;
            }
        }

        percent0To9 = (percent0To9 / moves) * 100;
        percent10To19 = (percent10To19 / moves) * 100;
        percent20To29 = (percent20To29 / moves) * 100;
        percent30To39 = (percent30To39 / moves) * 100;
        percent40To49 = (percent40To49 / moves) * 100;
        invalidNumber = (invalidNumber / moves) * 100;

        System.out.printf("%.2f\n" +
                "From 0 to 9: %.2f%%\n" +
                "From 10 to 19: %.2f%%\n" +
                "From 20 to 29: %.2f%%\n" +
                "From 30 to 39: %.2f%%\n" +
                "From 40 to 50: %.2f%%\n" +
                "Invalid numbers: %.2f%%\n", result, percent0To9, percent10To19, percent20To29, percent30To39, percent40To49, invalidNumber);

    }
}
/*Напишете програма, която да пресмята резултата от игра. Първо получавате число, което показва колко хода ще продължи играта.
После за всеки ход на играта ще получавате по едно ново число. Според интервала в който попада числото се прибавят точки.
Ако числото е отрицателно или по-голямо 50, тогава то е невалидно. В началото на играта резултата е 0 и на всеки ход се прибавят точки по следният начин:

•	От 0 до 9  20 % от числото
•	От 10 до 19  30 % от числото
•	От 20 до 29  40 % от числото
•	От 30 до 39  50 точки
•	От 40 до 50  100 точки
•	Невалидно число  резултата се дели на 2

Освен резултата програмата трябва да изкарва статистика за проценти числа в дадените интервали.
Вход
Входът се чете от конзолата:
•	Първи ред - колко хода ще има по време на играта – цяло число в интервала [1...100]
•	За всеки ход – числата, които се проверяват в кой интервал са – цели числа в интервала [-100...100]
Изход
Да се отпечата на конзолата 7 реда:
•	1ви ред: "{Краен резултат}"
•	2ри ред: "From 0 to 9: {процент в интервала}%"
•	3ти ред: "From 10 to 19: {процент в интервала}%"
•	4ти ред: "From 20 to 29: {процент в интервала}%"
•	5ти ред: "From 30 to 39: {процент в интервала}%"
•	6ти ред: "From 40 to 50: {процент в интервала}%"
•	7ми ред: "Invalid numbers: {процент в интервала}%"
Всички числа трябва да са форматирана до вторият знак след запетаята.
*/