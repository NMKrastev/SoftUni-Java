import java.util.Scanner;

public class TennisRanklist05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double percentWins = 0;
        int winCount = 0, totalPoints = 0, averagePoints = 0;

        int tournaments = Integer.parseInt(scanner.nextLine());
        int points = Integer.parseInt(scanner.nextLine());
        totalPoints += points;

        for (int i = 0; i < tournaments; i++) {

            String input = scanner.nextLine();
            switch (input) {
                case "W":
                    totalPoints += 2000;
                    winCount++;
                    averagePoints += 2000;
                    break;
                case "F":
                    totalPoints += 1200;
                    averagePoints += 1200;
                    break;
                case "SF":
                    totalPoints += 720;
                    averagePoints += 720;
                    break;
            }
        }
        percentWins = ((double)winCount / tournaments) * 100;

        System.out.printf("Final points: %d\n" +
                "Average points: %d\n" +
                "%.2f%%\n", totalPoints, averagePoints / tournaments, percentWins);

    }
}
/*Григор Димитров е тенисист, чиято следваща цел е изкачването в световната ранглиста по тенис за мъже.
През годината Гришо участва в определен брой турнири, като за всеки турнир получава точки, които
зависят от позицията, на която е завършил в турнира. Има три варианта за завършване на турнир:
	W - ако е победител получава 2000 точки
	F - ако е финалист получава 1200 точки
	SF - ако е полуфиналист получава 720 точки
Напишете програма, която изчислява колко ще са точките на Григор след изиграване на всички турнири,
като знаете с колко точки стартира сезона. Също изчислете колко точки средно печели от всички
изиграни турнири и колко процента от турнирите е спечелил.
Вход
От конзолата първо се четат два реда:
•	Брой турнири, в които е участвал – цяло число в интервала [1…20]
•	Начален брой точки в ранглистата - цяло число в интервала [1...4000]
За всеки турнир се прочита отделен ред:
•	Достигнат етап от турнира – текст – "W", "F" или "SF"
Изход
Отпечатват се три реда в следния формат:
•	"Final points: {брой точки след изиграните турнири}"
•	"Average points: {средно колко точки печели за турнир}"
•	"{процент спечелени турнири}%"
Средните точки да бъдат закръглени към най-близкото цяло число надолу, а процентът да се форматира до втората цифра след десетичния знак.
*/