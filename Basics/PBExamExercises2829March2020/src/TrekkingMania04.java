import java.util.Scanner;

public class TrekkingMania04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        int musala = 0, monblan = 0, kilimanjaro = 0,
                k2 = 0, everest = 0;
        double musalaPercent = 0, monblanPercent = 0, kilimanjaroPercent = 0,
                k2Percent = 0, everestPercent = 0,totalPeople = 0;

        for(int i = 0; i < groups; i++) {

            int peopleInGroup = Integer.parseInt(scanner.nextLine());
            totalPeople += peopleInGroup;

            if (peopleInGroup <= 5){
                musala += peopleInGroup;
            } else if (peopleInGroup > 5 && peopleInGroup <= 12) {
                monblan += peopleInGroup;
            } else if (peopleInGroup > 12 && peopleInGroup <= 25) {
                kilimanjaro += peopleInGroup;
            } else if (peopleInGroup > 25 && peopleInGroup <= 40) {
                k2 += peopleInGroup;
            } else {
                everest += peopleInGroup;
            }
        }

        musalaPercent = (musala / totalPeople) * 100;
        monblanPercent = (monblan / totalPeople) * 100;
        kilimanjaroPercent = (kilimanjaro / totalPeople) * 100;
        k2Percent = (k2 / totalPeople) * 100;
        everestPercent = (everest / totalPeople) * 100;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n",
                musalaPercent, monblanPercent, kilimanjaroPercent, k2Percent, everestPercent);

    }
}
/*Катерачи от цяла България се събират на групи и набелязват следващите върхове за изкачване.
Според размера на групата, катерачите ще изкачват различни върхове.
•	Група до 5 човека– Мусала
•	Група от 6 до 12 – Монблан
•	Група от 13 до 25 – Килиманджаро
•	Група от 26 до 40 – К2
•	Група от 41 или повече – Еверест
Да се напише програма, която изчислява процента на катерачите изкачващи всеки връх.
Вход
От конзолата се четат поредица от числа, всяко на отделен ред:
•	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
•	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]
Изход
Да се отпечатат на конзолата 5 реда, всеки от които съдържа процент между 0.00% и 100.00% с точност до
втората цифра след десетичната запетая.
•	Първи ред - процентът изкачващи Мусала
•	Втори ред – процентът изкачващи Монблан
•	Трети ред – процентът изкачващи Килиманджаро
•	Четвърти ред – процентът изкачващи К2
•	Пети ред – процентът изкачващи Еверест
*/