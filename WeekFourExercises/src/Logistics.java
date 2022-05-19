import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int transports = Integer.parseInt(scanner.nextLine());
        double averagePrice = 0, busWeight = 0, truckWeight = 0, trainWeigh = 0,
                totalWeight = 0, priceBus = 0, priceTruck = 0, priceTrain = 0,
                percentBus = 0, percentTruck = 0, percentTrain = 0;;

        for (int i = 0; i < transports; i++) {

            int weight = Integer.parseInt(scanner.nextLine());

            if (weight <= 3) {
                priceBus += weight * 200;
                busWeight += weight;
            } else if (weight > 3 && weight <= 11) {
                priceTruck += weight * 175;
                truckWeight += weight;
            } else {
                priceTrain += weight * 120;
                trainWeigh += weight;
            }

            totalWeight += weight;

        }
            averagePrice = (priceBus + priceTruck + priceTrain) / totalWeight;
            percentBus = (busWeight / totalWeight) * 100;
            percentTruck = (truckWeight / totalWeight) * 100;
            percentTrain = (trainWeigh / totalWeight) * 100;

            System.out.printf("%.2f\n%.2f%%\n%.2f%%\n%.2f%%\n", averagePrice, percentBus, percentTruck, percentTrain);

    }
}
/*Отговаряте за логистиката на различни товари. В зависимост от теглото на товара е нужно различно превозно средство. Цената на тон,
за която се превозва товара е различна за всяко превозно средство:
•	До 3 тона – микробус (200 лева на тон)
•	От 4 до 11 тона – камион (175 лева на тон)
•	12 и повече тона – влак (120 лева на тон)
Вашата задача е да изчислите средната цена на тон превозен товар, както и процента на тоновете  превозвани с всяко превозно средство,
спрямо общото тегло(в тонове) на всички товари.
Вход
От конзолата се четат поредица от числа, всяко на отделен ред:
•	На първия ред – броя на товарите за превоз – цяло число в интервала [1...1000]
•	За всеки един товар на отделен ред – тонажа на товара – цяло число в интервала [1...1000]
Изход
Да се отпечатат на конзолата 4 реда, както следва:
•	Първи ред – средната цена на тон превозен товар (закръглена до втория знак след дес. запетая);
•	Втори ред – процентът тона превозвани с микробус (процент между 0.00% и 100.00%);
•	Трети ред – процентът  тона превозвани с камион (процент между 0.00% и 100.00%);
•	Четвърти ред – процентът тона превозвани с влак (процент между 0.00% и 100.00%).
*/