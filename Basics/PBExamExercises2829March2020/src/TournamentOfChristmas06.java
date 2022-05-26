import java.util.Scanner;

public class TournamentOfChristmas06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int daysCount = 0, winCount = 0, loseCount = 0,
                totalWin = 0, totalLose = 0;
        double moneyWon = 0, totalMoneyWon = 0;
        String input , winOrLose;
        int days = Integer.parseInt(scanner.nextLine());

        while (daysCount < days) {
            input = scanner.nextLine();
            if (input.equals("Finish")) {
                if (winCount > loseCount) {
                    totalMoneyWon += moneyWon + (moneyWon * 0.1);
                } else {
                    totalMoneyWon += moneyWon;
                }
                daysCount++;
                if (daysCount == days && totalWin > totalLose) {
                    totalMoneyWon += (totalMoneyWon * 0.2);
                    daysCount++;
                }
                moneyWon = 0;
                winCount = 0;
                loseCount = 0;
                continue;
            } else {
                winOrLose = scanner.nextLine();
            }
            if (winOrLose.equals("win")) {
                moneyWon += 20;
                winCount++;
                totalWin++;
            } else {
                loseCount++;
                totalLose++;
            }
        }
        if (totalWin > totalLose) {
            System.out.printf("You won the tournament! Total raised money: %.2f\n", totalMoneyWon);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f\n", totalMoneyWon);
        }
    }
}
/*Напишете програма, която проследява представянето на вашия отбор на благотворителен коледен турнир.
Всеки ден получавате имена на игри до команда "Finish". Със спечелването на всяка една игра печелите по 20лв.
за благотворителност. Трябва да изчислите колко пари сте спечелили на края на деня.
Ако имате повече спечелени игри, отколкото загубени – вие сте победители този ден и увеличавате
парите от него с 10%. При приключване на турнира ако през повечето дни сте били победители
печелите турнира и увеличавате всичките спечелени пари с 20%.
Никога няма да имате равен брой спечелени и загубени игри.
Вход
Първоначално от конзолата се прочита броя дни на турнира – цяло число в интервала [1… 20]
До получаване на командата "Finish" се чете:
•	Спорт  – текст
За всеки спорт се прочита:
o	Резултат  – текст с възможности: "win" или "lose"
Изход
Накрая се отпечатва един ред:
•	Ако сте спечелили турнира:
     	"You won the tournament! Total raised money: {спечелените пари}"
•	Ако сте загубили на турнира:
"You lost the tournament! Total raised money: {спечелените пари}"
Парите да бъдат форматирани до втората цифра след десетичния знак.
*/