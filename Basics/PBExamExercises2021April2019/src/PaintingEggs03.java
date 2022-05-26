import java.util.Scanner;

public class PaintingEggs03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = 0;
        String size = scanner.nextLine();
        String color = scanner.nextLine();
        int batchNum = Integer.parseInt(scanner.nextLine());

        if (size.equals("Large")) {
            switch (color) {
                case "Red":
                    price = batchNum * 16;
                    break;
                case "Green":
                    price = batchNum * 12;
                    break;
                case "Yellow":
                    price = batchNum * 9;
                    break;
            }
        } else if (size.equals("Medium")) {
            switch (color) {
                case "Red":
                    price = batchNum * 13;
                    break;
                case "Green":
                    price = batchNum * 9;
                    break;
                case "Yellow":
                    price = batchNum * 7;
                    break;
            }
        } else if (size.equals("Small")) {
            switch (color) {
                case "Red":
                    price = batchNum * 9;
                    break;
                case "Green":
                    price = batchNum * 8;
                    break;
                case "Yellow":
                    price = batchNum * 5;
                    break;
            }
        }

        double totalPrice = price - price * 0.35;
        System.out.printf("%.2f leva.", totalPrice);

    }
}
/*С наближаването на Великденските празници, цех за боядисване на яйца, започва да боядисва различни размери яйца,
 които след това продава на партиди. В таблицата са показани размерите на яйцата, различните бои и
 каква е цената за продажба на една партида яйца, зависеща от размерите и цвета боя.
	            Червено (Red)	Зелено (Green)	Жълто (Yellow)
Големи (Large)	16 лв.	        12 лв.	        9 лв.
Средни (Medium)	13 лв.	        9 лв.	        7 лв.
Малки (Small)	9 лв.       	8 лв.       	5 лв.
Напишете програма, която изчислява какви ще са приходите на цеха от продажбите, като знаете размера на яйцата
 и техният цвят. С 35% от крайната цена ще бъдат покрити производствени разходи.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред – размер на яйцата – текст с възможности "Large", "Medium" или "Small"
•	Втори ред – цвят на яйцата – текст  с възможности "Red", "Green" или "Yellow"
•	Трети ред – брой партиди – цяло число в интервала [1… 350]
Изход
На конзолата трябва да се отпечата един ред:
"{крайната цена} leva."
Резултатът да се форматира до втората цифра след десетичния знак.
*/