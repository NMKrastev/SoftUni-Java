import java.util.Scanner;

public class Balls04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ballCount = Integer.parseInt(scanner.nextLine());
        String input;
        int redCount = 0, orangeCount = 0, yellowCount = 0,
                whiteCount = 0, divideCount = 0, othersCount = 0,
        totalPoints = 0;

        for (int i = 0; i < ballCount; i++) {
            input = scanner.nextLine();

            if (input.equals("red")) {
                redCount++;
                totalPoints += 5;
            } else if (input.equals("orange")) {
                orangeCount++;
                totalPoints += 10;
            } else if (input.equals("yellow")) {
                yellowCount++;
                totalPoints += 15;
            } else if (input.equals("white")) {
                whiteCount++;
                totalPoints += 20;
            } else if (input.equals("black")) {
                divideCount++;
                totalPoints = (int) Math.floor(totalPoints / 2);
            } else {
                othersCount++;
            }
        }

        System.out.printf("Total points: %d\nRed balls: %d\nOrange balls: %d\nYellow balls: %d\n" +
                "White balls: %d\nOther colors picked: %d\nDivides from black balls: %d",
                totalPoints, redCount, orangeCount, yellowCount, whiteCount, othersCount, divideCount);

    }
}
/*В кутия имаме неопределен брой топки с различни цветове, които ни носят различен брой точки.
Задачата ни е да извадим Х бр. топки, които ще бъдат въведени от конзолата, като се има в предвид,
че всеки различен цвят влияе на точките ни по следния начин:
•	Ако топката е “red” точките ни се повишават с 5.
•	Ако топката е “orange” точките ни се повишават с 10.
•	Ако топката е “yellow” точките ни се повишават с 15.
•	Ако топката е “white” точките ни се повишават с 20.
•	Ако топката е “black” точките ни се делят на 2, като закръгляме към по-малкото цяло число.
Ако топката е с какъвто и да е цвят, различен от по-горните, точките не се манипулират и програмата продължава да работи.
Вход:
1.	От конзолата се чете 1 цяло число N, което е броят на топките в диапазон (0-1000).
2.	След това се четат N на брой цветове.
Изход:
Отпечатват се следните редове:
"Total points: {всичките събрани точки}"
"Red balls: {броят червени топки}"
"Orange balls: {броят оранжеви топки}"
"Yellow balls: {броят жълти топки}"
"White balls: {броят бели топки}"
"Other colors picked: {броят на избраните топки извън зададените цветове}"
"Divides from black balls: {броят на пътите, в които точките са били разделяни на 2}"
*/