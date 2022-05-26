import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sectorA = 0, sectorB = 0, sectorV = 0, sectorG = 0;
        double percentA = 0, percentB = 0, percentV = 0, percentG = 0, average = 0.00;

        int capacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());

        for (int i = 0;  i < fans; i++) {

            String sector = scanner.nextLine().toLowerCase();

            switch (sector) {
                case "a":
                    sectorA++;
                    break;
                case "b":
                    sectorB++;
                    break;
                case "v":
                    sectorV++;
                    break;
                case "g":
                    sectorG++;
                    break;
            }
        }

        percentA = (sectorA / fans) * 100;
        percentB = (sectorB / fans) * 100;
        percentV = (sectorV / fans) * 100;
        percentG = (sectorG / fans) * 100;
        average = (fans * 1.0 / capacity) * 100;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n",
                percentA, percentB, percentV, percentG, average);
    }
}
/*Екипът на СофтУни си организира футболен турнир. Първоначално прочитаме от конзолата капацитета на стадиона и броят на всички фенове.
След това за всеки фен се чете секторът, в който се намира. Феновете на първия отбор са в сектор А и Б, а на втория – В и Г.
Да се напише програма, която изчислява процентите на феновете във всеки сектор, спрямо общия брой фенове на стадиона,
както и общият процент на феновете за двата отбора, спрямо капацитета на стадиона. Общият брой на феновете НЕ надвишава капацитета на стадиона.
Вход
От конзолата се четат поредица от числа, всяко на отделен ред:
1.	Капацитетът на стадиона – цяло число в интервала [1 … 10000];
2.	Броят на всички фенове – цяло число в интервала [1 … 10000].
За всеки един фен, на отделен ред се прочита:
1.	Секторът, на който се намира – текст – "A", "B", "V" и "G".
Изход
Да се отпечатат на конзолата 5 реда, всеки от които съдържа процент между 0.00% и 100.00%, форматирани до втората цифра след десетичната запетая:
1.	Процентът на феновете в сектор А
2.	Процентът на феновете в сектор Б
3.	Процентът на феновете в сектор В
4.	Процентът на феновете в сектор Г
5.	Процентът на всички фенове, спрямо капацитета на стадиона.
*/