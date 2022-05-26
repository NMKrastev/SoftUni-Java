import java.util.Scanner;

public class FavoriteMovie06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int movieCount = 0;
        int totalPoints = 0;
        int maxPointsMovie = Integer.MIN_VALUE;
        String recommendedMovie = "";
        boolean isLimit = false;
        String movie = scanner.nextLine();

        while (!movie.equals("STOP")) {
            movieCount++;
            if (movieCount == 7) {
                isLimit = true;
                break;
            }
            for (int i = 0; i < movie.length(); i++) {

                char letter = movie.charAt(i);
                totalPoints += letter;
                if (Character.isUpperCase(letter)) {
                    totalPoints -= movie.length();
                } else if (Character.isLowerCase(letter)) {
                    totalPoints -= movie.length() * 2;
                }
            }

            if (totalPoints > maxPointsMovie) {
                maxPointsMovie = totalPoints;
                recommendedMovie = movie;
            }
            totalPoints = 0;
            movie = scanner.nextLine();
        }

        if (isLimit) {
            System.out.printf("The limit is reached.\nThe best movie for you is %s with %d ASCII sum.",
                    recommendedMovie, maxPointsMovie);
        } else {
            System.out.printf("The best movie for you is %s with %d ASCII sum.", recommendedMovie, maxPointsMovie);
        }
    }
}
/*Петък вечер е и се чудите кой филм да си пуснете да гледате. Решавате да напишете програма, която да избере това
вместо вас. До команда "STOP" получавате заглавия на любими ваши филми. Най-добрият филм за вас ще бъде този,
който има най-много точки. Точките се изчисляват като сбор от ASCII стойностите на символите в заглавието на филма.
(няма да има случай, в който имаме два филма с равен брой точки)
При изчислението на точките трябва да се има предвид следното:
•	За всяка малка буква в заглавието, от сумата трябва да се извади два пъти дължината на заглавието на филма.
•	За всяка главна буква в заглавието, от сумата трябва да се извади дължината на заглавието на филма.
Може да имате максимум 7 заглавия на филми.
Вход
От конзолата се четат редове до команда "STOP" или до достигането на лимита от 7 филма:
•	Заглавие на филм  – текст;
Изход
На конзолата да се отпечата:
•	Ако сте достигнали лимита от 7 филма трябва да отпечатате:
"The limit is reached."
Да се отпечата най-добрият филм за вас:
"The best movie for you is {заглавие на филм} with {сума на символите} ASCII sum."
*/