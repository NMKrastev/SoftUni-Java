import java.util.Scanner;

public class ComputerFirm04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int computerNum = Integer.parseInt(scanner.nextLine());
        int rating = 0, totalRating = 0;
        double sells = 0, totalSells = 0;

        for (int i = 0; i < computerNum; i++) {

            int num = Integer.parseInt(scanner.nextLine());
            rating = num % 10;
            String currentNum = String.valueOf(num);

            if (num >= 100 && num <= 306) {
                sells = Double.parseDouble(currentNum.substring(0, 2));
            } else if (num < 100 && num >= 32) {
                sells = Double.parseDouble(currentNum.substring(0, 1));
            } else {
                continue;
            }

            if (rating == 2) {
                totalRating += rating;
            } else if (rating == 3) {
                totalSells += (sells * 0.50);
                totalRating += rating;
            } else if (rating == 4) {
                totalSells += (sells * 0.70);
                totalRating += rating;
            } else if (rating == 5) {
                totalSells += (sells * 0.85);
                totalRating += rating;
            } else if (rating == 6) {
                totalSells += sells;
                totalRating += rating;
            }
        }
        System.out.printf("%.2f\n", totalSells);
        System.out.printf("%.2f\n", 1.0 * totalRating / computerNum);
    }
}
/*Фирма за компютри е наела Вас, за да изчислите възможните продажби. Да се напише програма, която за
определен вид компютри пресмята средния рейтинг и направените продажби. Първо се въвежда едно число от
конзолата, което представлява броя на моделите компютри. След това последователно за всеки от моделите
компютри се въвежда по едно число:
•	Последната цифра (единиците) на това число представлява рейтингът, който е в интервала [2…6].
•	Останалите цифри (стотици и десетици) са възможните продажби, които ще се осъществят.
Компютърната продажба се скалира на база рейтинг:
•	Рейтинг 2 взима 0% от  възможните продажби.
•	Рейтинг 3 взима 50% от възможните продажби.
•	Рейтинг 4 взима 70% от възможните продажби.
•	Рейтинг 5 взима 85% от възможните продажби.
•	Рейтинг 6 взима 100% от възможните продажби.
Вход
От конзолата се прочита:
На първия ред:
•	n - брой компютри - цяло число в интервала [1…10]
На следващите n реда:
•	Числото, представляващо възможните продажби и рейтинга - цяло число в интервала [32…306]
Изход
На конзолата се отпечатват 2 редa:
•	Броят направени продажби
•	Средноаритметичният рейтинг за всички компютри
Продажбите и рейтингът трябва да са форматирани до втората цифра след десетичната запетая.
*/