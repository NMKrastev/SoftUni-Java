import java.util.Scanner;

public class BestPlayer05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxGoals = Integer.MIN_VALUE;
        String bestPlayer = "";
        boolean hatTrick = false;
        String name = scanner.nextLine();
        int goals;

        while (!name.equals("END")) {

                goals = Integer.parseInt(scanner.nextLine());

            if (maxGoals < goals) {
                maxGoals = goals;
                bestPlayer = name;

                if (goals > 2) {
                    hatTrick = true;
                }
                if (goals > 9) {
                    break;
                }
            }

            name = scanner.nextLine();

        }

        if (hatTrick) {
            System.out.printf("%s is the best player!\nHe has scored %d goals and made a hat-trick !!!",
                    bestPlayer, maxGoals);
        } else {
            System.out.printf("%s is the best player!\nHe has scored %d goals.", bestPlayer, maxGoals);
        }
    }
}
/*Пепи иска да напишете програма, чрез която да разбере кой е най-добрият играч от световното първенство.
Информацията, която получавате ще бъде играч и колко гола е отбелязал.
От вас се иска да отпечатате кой е играчът с най-много голове и дали е направил хет-трик.
Хет-трик е, когато футболистът е вкарал 3 или повече гола.
Ако футболистът е вкарал 10 или повече гола, програмата трябва да спре.
Вход:
От конзолата се четат по два реда до въвеждане на команда "END":
•	Име на играч – текст
•	Брой вкарани голове  – цяло положително число в интервала [1 … 10000]
Изход:
На конзолата да се отпечатат 2 реда :
•	На първия ред:
            "{име на играч} is the best player!"
•	На втория ред :
o	 Ако най-добрият футболист е направил хеттрик:
                   "He has scored {брой голове} goals and made a hat-trick !!!"
o	Ако най-добрият футболист не е направил хеттрик:
                   "He has scored {брой голове} goals."
*/