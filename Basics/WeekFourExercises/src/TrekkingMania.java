import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());
        int musalaPeople = 0, montblancPeople = 0,
                kilimanjaroPeople = 0, k2People = 0, everestPeople = 0;
        double totalPeople = 0.00, musalaPercent = 0.00, montblancPercent = 0.00,
                kilimanjaroPercent = 0.00, k2Percent = 0.00, everestPercent = 0.00;

        for (int i = 0; i < groups; i++) {
            int peoplePerGroup = Integer.parseInt(scanner.nextLine());
            totalPeople += peoplePerGroup;

            if (peoplePerGroup <= 5) {
                musalaPeople += peoplePerGroup;
            } else if (peoplePerGroup > 5 && peoplePerGroup <= 12) {
                montblancPeople += peoplePerGroup;
            } else if (peoplePerGroup > 12 && peoplePerGroup <= 25) {
                kilimanjaroPeople += peoplePerGroup;
            } else if (peoplePerGroup > 25 && peoplePerGroup <= 40) {
                k2People += peoplePerGroup;
            } else {
                everestPeople += peoplePerGroup;
            }

        }

        musalaPercent = (musalaPeople / totalPeople) * 100;
        montblancPercent = (montblancPeople / totalPeople) * 100;
        kilimanjaroPercent = (kilimanjaroPeople / totalPeople) * 100;
        k2Percent = (k2People / totalPeople) * 100;
        everestPercent = (everestPeople / totalPeople) * 100;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n",
                musalaPercent, montblancPercent, kilimanjaroPercent, k2Percent, everestPercent);

    }
}
/*Катерачи от цяла България се събират на групи и набелязват следващите върхове за изкачване. Според размера на групата,
катерачите ще изкачват различни върхове.
•	Група до 5 човека – изкачват Мусала
•	Група от 6 до 12 човека – изкачват Монблан
•	Група от 13 до 25 човека – изкачват Килиманджаро
•	Група от 26 до 40 човека –  изкачват К2
•	Група от 41 или повече човека – изкачват Еверест
Да се напише програма, която изчислява процента на катерачите изкачващи всеки връх.
Вход
От конзолата се четат поредица от числа, всяко на отделен ред:
•	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
•	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]
Изход
Да се отпечатат на конзолата 5 реда, всеки от които съдържа процент между 0.00% и 100.00% с точност до втората цифра след десетичната запетая.
•	Първи ред - процентът изкачващи Мусала
•	Втори ред – процентът изкачващи Монблан
•	Трети ред – процентът изкачващи Килиманджаро
•	Четвърти ред – процентът изкачващи К2
•	Пети ред – процентът изкачващи Еверест
*/