import java.util.Scanner;

public class FruitMarket1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerKgStrawberry = Double.parseDouble(scanner.nextLine());
        double bananaKg = Double.parseDouble(scanner.nextLine());
        double orangeKg = Double.parseDouble(scanner.nextLine());
        double raspberryKg = Double.parseDouble(scanner.nextLine());
        double strawberryKg = Double.parseDouble(scanner.nextLine());

        double strawberryTotal = strawberryKg * pricePerKgStrawberry;
        double priceRaspberry = pricePerKgStrawberry - (pricePerKgStrawberry * 0.5);
        double raspberryTotal = raspberryKg * priceRaspberry;
        double orangeTotal = orangeKg * (priceRaspberry - (priceRaspberry * 0.4));
        double bananaTotal = bananaKg * (priceRaspberry - (priceRaspberry * 0.8));

        System.out.printf("%.2f", strawberryTotal + raspberryTotal + orangeTotal + bananaTotal);

    }
}
/*Мария решава да мине на диета и отива до близкия пазар, за да купи ягоди, банани, портокали и малини. На конзолата
се въвежда цената на ягодите в лв./кг. и количеството на бананите, портокалите, малините и ягодите, които трябва да
закупи. Да се напише програма, която пресмята колко пари са ѝ необходими за да плати сметката, като знаете, че:
•	цената на малините е на половина по-ниска от тази на ягодите;
•	цената на портокалите е с 40% по-ниска от цената на малините;
•	цената на бананите е с 80% по-ниска от цената на малините.
Вход
От конзолата се четат 5 реда:
1.	Цена на ягодите в лева – реално число в интервала [0.00 … 10000.00]
2.	Количество на бананите в килограми – реално число в интервала [0.00 … 1 0000.00]
3.	Количество на портокалите в килограми – реално число в интервала [0.00 … 10000.00]
4.	Количество на малините в килограми – реално число в интервала [0.00 … 10000.00]
5.	Количество на ягодите в килограми – реално число в интервала [0.00 … 10000.00]
Изход
Да се отпечата на конзолата едно число:
•	парите, които са необходими на Мария.
Резултатът да се форматира до вторта цифра след десетичната запетая.
*/