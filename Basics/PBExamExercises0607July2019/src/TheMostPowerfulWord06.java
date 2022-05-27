import java.util.Scanner;

public class TheMostPowerfulWord06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int maxPoints = Integer.MIN_VALUE;
        String winWord = "";

        while (!word.equals("End of words")) {

            char current;
            int pointsPerLetter = 0;
            int totalPointsPerWord = 0;
            String firstLetter = "";

            for (int i = 0; i < word.length(); i++) {

                current = word.charAt(i);
                firstLetter = String.valueOf(word.charAt(0));
                pointsPerLetter = current;

                totalPointsPerWord += pointsPerLetter;
            }
            if (firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("o") ||
                    firstLetter.equals("u") || firstLetter.equals("y") || firstLetter.equals("A") || firstLetter.equals("E") ||
                    firstLetter.equals("I") || firstLetter.equals("O") || firstLetter.equals("U") || firstLetter.equals("Y")) {

                totalPointsPerWord *= word.length();
                if (totalPointsPerWord > maxPoints) {
                    maxPoints = totalPointsPerWord;
                    winWord = word;
                }
            }

            word = scanner.nextLine();
        }

        System.out.printf("The most powerful word is %s - %d", winWord, maxPoints);

    }
}
/* За Лора думите притежават голяма сила. Тя те моли да измислиш алгоритъм, с който да откриеш коя е "най-силната" дума.
До получаване на команда "End of words" ще се четат от конзолата думи. За да се открие силата на всяка една,
трябва да се намери сборът от ASCII стойностите на символите, от които се състои думата. Ако започва с
гласна буква - 'a', 'e', 'i', 'o', 'u', 'y' (или техните еквивалентни главни букви), полученият сбор трябва да се
умножи по дължината на думата, в противен случай, да се раздели на дължината и да се
закръгли до най-близкото цяло число надолу.
Вход
До получаване на команда "End of words" се чете по един ред от конзолата:
•	дума – текст
Изход
След приключване на програмата се печата на един ред думата с "най-голяма сила":
•	"The most powerful word is {думата с най-голяма сила} - {силата на думата}"
*/