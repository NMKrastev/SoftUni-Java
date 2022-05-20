import java.util.Scanner;

public class EasterBake05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalSugar = 0, totalFlour = 0;
        int maxSugar = Integer.MIN_VALUE, maxFlour = Integer.MIN_VALUE;
        int easterBreads = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < easterBreads; i++) {

            int sugar = Integer.parseInt(scanner.nextLine());
            int flour = Integer.parseInt(scanner.nextLine());

            if (maxSugar < sugar) {
                maxSugar = sugar;
            }
            if (maxFlour < flour) {
                maxFlour = flour;
            }

            totalSugar += sugar;
            totalFlour += flour;

        }

        totalSugar = Math.ceil(totalSugar / 950);
        totalFlour = Math.ceil(totalFlour / 750);

        System.out.printf("Sugar: %.0f\nFlour: %.0f\n" +
                "Max used flour is %d grams, max used sugar is %d grams.",
                totalSugar, totalFlour, maxFlour, maxSugar);

    }
}
/*Предстои Великден и Деси е решила да изпече домашни козунаци за колегите си.
Главните продукти, които ще трябват на Деси са: брашно и захар. Един пакет захар е 950 грама,
а един пакет брашно е 750 грама. Напишете програма, която изчислява колко пакета захар и брашно
трябва да купи Деси, за да й стигнат за направата на козунаците, като знаете за всеки един
козунак по колко грама захар и брашно са изразходени. Също намерете кое е най-голямото
количество захар и брашно, които са използвани.
Вход
От конзолата се чете 1 ред:
•	 Броят на козунаците – цяло число в интервала [1 ... 100]
За всеки козунак се чете:
o	Количество изразходвана захар (грамове) – цяло число в интервала [1 … 10000]
o	Количество изразходвано брашно (грамове) – цяло число в интервала [1 … 10000]
Изход
Да се отпечатат на конзолата 3 реда:
•	"Sugar: {брой нужни пакети захар}"
•	"Flour: {брой нужни пакет брашно}"
•	"Max used flour is {максимално количество грамове брашно, използвани за правенето на козунак} grams, max used sugar is {максимално количество грамове захар, използвани за правенето на козунак} grams."
Пакетите захар и брашно да бъдат закръглени към най-близкото цяло число нагоре.
*/