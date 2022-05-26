package MoreExercises;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double wight = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        double rowPerWight = Math.floor(wight * 100 / 120);
        double rowPerHeight = Math.floor((height * 100 - 100) / 70);
        double seats = (rowPerWight * rowPerHeight) - 3;

        System.out.printf("%.0f", Math.floor(seats));

        /*От конзолата се четат 2 числа, по едно на ред: w (дължина в метри) и h (широчина в метри).
Ограничения: 3 ≤ h ≤ w ≤ 100.
Изход
Да се отпечата на конзолата едно цяло число: броят места в учебната зала.
Залата е широка 890 cm. От тях 100 cm отиват за коридора в средата.
В останалите 790 cm могат да се разположат по 11 бюра на ред (11 * 70 cm = 770 cm + 20 cm остатък).
Залата е дълга 1500 cm. В тях могат да бъдат разположени 12 реда (12 * 120 cm = 1440 + 60 cm остатък).
Брой места = 12 * 11 - 3 =  132 - 3 = 129 (имаме 12 реда по 11 места = 132 минус 3 места за катедра и входна врата).
*/
    }
}
