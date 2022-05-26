import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double water = 20, internet = 15, averageSum = 0,
                others = 0, totalElectricity = 0;
        int months = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < months; i++) {

            double electricity = Double.parseDouble(scanner.nextLine());

            others = others + (water + internet + electricity + ((water + internet + electricity) * 0.2));
            totalElectricity += electricity;

        }
        water *= months;
        internet *= months;
        averageSum = (totalElectricity + water + internet + others) / months;

        System.out.printf("Electricity: %.2f lv\n" +
                "Water: %.2f lv\n" +
                "Internet: %.2f lv\n" +
                "Other: %.2f lv\n" +
                "Average: %.2f lv\n", totalElectricity, water, internet, others, averageSum);
    }
}
/*Напишете програма която да пресмята средният разход за месец на семейство за даден период време. За всеки месец разходите са следните:
•	За ток – всеки месец е различен, ще се чете от конзолата
•	за вода – 20 лв.
•	за интернет – 15 лв.
•	за други – събират се тока, водата и интернета за месеца и към сумата се прибавят 20%.
За всеки разход трябва да се пресметне колко общо е платено за всички месеци.
Вход
Входът се чете от конзолата:
•	Първи ред – месеците за които се търси средният разход – цяло число в интервала [1...100]
•	За всеки месец – сметката за ток – реално число в интервала [1.00...1000.00]
Изход
Да се отпечата на конзолата 5 реда:
•	1ви ред: "Electricity: {ток за всички месеци} lv"
•	2ри ред: "Water: {вода за всички месеци} lv"
•	3ти ред: "Internet: {интернет за всички месеци} lv"
•	4ти ред: "Other: {други за всички месеци} lv"
•	5ти ред: "Average: {средно всички разходи за месец} lv"
Всички числа трябва да са форматирана до вторият знак след запетаята.
*/