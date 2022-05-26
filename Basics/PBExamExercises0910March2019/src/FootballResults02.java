import java.util.Scanner;

public class FootballResults02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int winCount = 0, drawCount = 0, loseCount = 0;
        int scoreOne = 0, scoreTwo = 0;

        for (int i = 0; i < 3; i++) {
            String match = scanner.nextLine();
            scoreOne = match.charAt(0);
            scoreTwo = match.charAt(2);

            if (scoreOne > scoreTwo) {
                winCount++;
            } else if (scoreTwo > scoreOne) {
                loseCount++;
            } else {
                drawCount++;
            }

        }

        System.out.printf("Team won %d games.\n" +
                "Team lost %d games.\n" +
                "Drawn games: %d\n", winCount, loseCount, drawCount);
    }
}
/*Футболен отбор участва в благотворителен турнир. На този турнир отборът играе три мача като домакин.
Да се напише програма, която изчислява колко победи, равенства и загуби има отборът по време на турнира,
спрямо резултатите от мачовете.
*Забележка: Отборът винаги е домакин, следователно първата цифра от резултата съответства на головете
вкарани от него.
Вход
От конзолата се четат 3 реда:
1.	Резултат от първия мач – текст
2.	Резултат от втория мач – текст
3.	Резултат от третия мач – текст
Резултатите ще са в следния формат: "2:0", "0:1", "1:1" и т.н.
/броят голове винаги ще бъде едноцифрено число/
Изход
На конзолата да се отпечатат три реда:
•	"Team won {брой спечелени мачове} games."
•	"Team lost {брой загубени мачове} games."
•	" Drawn games: {брой равни мачове}"
*/