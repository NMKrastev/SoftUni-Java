import java.util.Scanner;

public class Skeleton02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mins = 60 * Integer.parseInt(scanner.nextLine());
        int controlSecs = Integer.parseInt(scanner.nextLine());
        double trackLength = Double.parseDouble(scanner.nextLine());
        int secsTo100M = Integer.parseInt(scanner.nextLine());

        int timeToBeat = mins + controlSecs;
        double bonusTime = trackLength / 120;
        double bonusTimeTotal = bonusTime * 2.5;
        double MarinTime = (trackLength / 100) * secsTo100M - bonusTimeTotal;

        if (MarinTime <= timeToBeat) {
            System.out.printf("Marin Bangiev won an Olympic quota!\n" +
                    "His time is %.3f.", MarinTime);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", MarinTime - timeToBeat);
        }
    }
}
/*Българският състезател по скелетон Марин Бангиев се бори за олимпийска квота. Вие имате честта да
напишете програмата, която ще изчисли дали той печели квота.
Вашата програма получава контролата в минути, която трябва да бъде достигната или подобрена, за да може
Марин да вземе квота. Също така програмата ще получи разстоянието на улея в метри, и времето в секунди,
за което той изминава 100 метра.
Трябва да се има предвид, че поради наклона на улея, на всеки 120 метра неговото време намаля с 2.5 секунди.
Вход
От конзолата се четат 4 реда:
Ред 1.	Минути на контролата – цяло число в интервала [0…59]
Ред 2.	Секунди на контролата – цяло число в интервала [0…59]
Ред 3.	Дължината на улея в метри – реално число в интервала [0.00…50000]
Ред 4.	Секунди за изминаване на 100 метра – цяло число в интервала [0…1000]
Изход
На конзолата трябва да се отпечата на един или два реда:
•	Ако времето на Марин е по-малко или равно на контролата:
o	"Marin Bangiev won an Olympic quota!"
o	"His time is {времето на Марин в секунди}."
•	Ако времето на Марин е повече от това на контролата:
o	 "No, Marin failed! He was {недостигащи секунди} second slower."
Резултатът трябва да е форматиран до третия знак след десетичния знак.
*/