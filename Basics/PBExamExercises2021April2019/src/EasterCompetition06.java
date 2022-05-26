import javax.swing.*;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class EasterCompetition06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxScore = Integer.MIN_VALUE;
        int score = 0, points = 0;
        String winner = "", name = "";
        String input = "";
        int easterBread = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < easterBread; i++) {

            input = scanner.nextLine();
            name = input;
            input = scanner.nextLine();

            while (!input.equals("Stop")) {

                points = Integer.parseInt(input);
                score += points;
                input = scanner.nextLine();

                }

            if (maxScore < score) {
                maxScore = score;
                winner = name;
                System.out.printf("%s has %d points.\n%s is the new number 1!\n",
                        name, score, name);
                score = 0;
            } else {
                System.out.printf("%s has %d points.\n", name, score);
                score = 0;
            }
        }
        System.out.printf("%s won competition with %d points!\n", winner, maxScore);
    }
}
/*С наближаването на Великден, пекарна организира конкурс за направата на най-хубав козунак.
Напишете програма, която да намира сладкаря с най-висок резултат. В началото на конкурса се
въвежда броя на козунаците, които ще бъдат дегустирани от посетителите на пекарната,
като за всеки козунак различен брой посетители, ще дадат оценка от 1 до 10.
Вход
Първоначално от конзолата се прочита броя на козунаците – цяло число в интервала [1… 100]
След това за всеки козунак се прочита:
•	Името на пекаря, който е направил козунака – текст
•	До получаване на командата "Stop" се прочита
o	оценка за козунак от един човек  – цяло число в интервала [1... 10]
Изход
След получаване на командата "Stop" се печата един ред:
•	"{името на пекаря} has {общият брой получени точки} points."
Ако след командата "Stop", пекарят е с най-много точки до момента, да се отпечата допълнителен ред:
•	"{името на пекаря} is the new number 1!"
След дегустация на всички козунаци, да се отпечата един ред:
•	"{името на пекаря с най-много точки} won competition with {точките на пекаря} points!"
*/