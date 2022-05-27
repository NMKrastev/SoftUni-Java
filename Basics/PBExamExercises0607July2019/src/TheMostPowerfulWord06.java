import java.util.Scanner;

public class TheMostPowerfulWord06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int maxPoints = Integer.MIN_VALUE;
        String winWord = "";

        while (!word.equals("End of words")) {

            int points = 0;
            char current;
            char firstLetter;
            int currentWord = 0;
            String letter = "";

            for (int i = 0; i < word.length(); i++) {

                current = word.charAt(i);
                firstLetter = word.charAt(0);
                points = current;
                letter = String.valueOf(firstLetter);

                currentWord += points;
            }
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") ||
                    letter.equals("u") || letter.equals("y") || letter.equals("A") || letter.equals("E") ||
                    letter.equals("I") || letter.equals("O") || letter.equals("U") || letter.equals("Y")) {

                currentWord *= word.length();
                if (currentWord > maxPoints) {
                    maxPoints = currentWord;
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