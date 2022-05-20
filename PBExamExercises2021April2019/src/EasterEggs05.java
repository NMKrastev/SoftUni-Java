import java.util.Scanner;

public class EasterEggs05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int redCount = 0, orangeCount = 0, blueCount = 0, greenCount = 0;
        int maxEggs = Integer.MIN_VALUE;
        String winColor = "";
        String input = scanner.nextLine();
        int eggsNumber = Integer.parseInt(input);

        for (int i = 0; i < eggsNumber; i++) {

            input = scanner.nextLine();

            switch (input) {
                case "red":
                    redCount++;
                    if (maxEggs < redCount) {
                        maxEggs = redCount;
                        winColor = input;
                    }
                    break;
                case "orange":
                    orangeCount++;
                    if (maxEggs < orangeCount) {
                        maxEggs = orangeCount;
                        winColor = input;
                    }
                    break;
                case "blue":
                    blueCount++;
                    if (maxEggs < blueCount) {
                        maxEggs = blueCount;
                        winColor = input;
                    }
                    break;
                case "green":
                    greenCount++;
                    if (maxEggs < greenCount) {
                        maxEggs = greenCount;
                        winColor = input;
                    }
                    break;
            }
        }

        System.out.printf("Red eggs: %d\n" +
                        "Orange eggs: %d\n" +
                        "Blue eggs: %d\n" +
                        "Green eggs: %d\n" +
                        "Max eggs: %d -> %s", redCount, orangeCount, blueCount, greenCount,
                maxEggs, winColor);

    }
}
/*Предстои Великден и едно от най-вълнуващите неща е боядисването на яйца.
Наличните цветове за боядисване са:
•	червено (red)
•	оранжев (orange)
•	син (blue)
•	зелен (green)
Напишете програма, която изчислява какъв е броят на яйцата от всеки цвят и от кой цвят яйцата
са най - много, като знаете общия им брой и цвета на всяко яйце.
Вход
От конзолата се чете 1 ред:
•	 Броят на боядисаните яйца – цяло число в интервала [1 ... 100]
За всяко яйце се чете:
o	Цветът на яйцето – текст с възможности: "red", "orange", "blue", "green"
Изход
Да се отпечатат на конзолата 5 реда:
•	"Red eggs: {брой на червените яйца}"
•	"Orange eggs: {брой на оранжевите яйца}"
•	"Blue eggs: {брой на сините яйца}"
•	"Green eggs: {брой на зелените яйца}"
•	"Max eggs: {максимален брой на яйцата от цвят} -> {цвят}"
*/