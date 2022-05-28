import java.util.Scanner;

public class CourierExpress03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weight = Double.parseDouble(scanner.nextLine());
        String serviceType = scanner.nextLine();
        int distance = Integer.parseInt(scanner.nextLine());
        double additionalTax = 0, totalPrice = 0;

        switch (serviceType) {
            case "standard":
                if (weight < 1) {
                    totalPrice = distance * 0.03;
                } else if (weight >= 1 && weight < 10) {
                    totalPrice = distance * 0.05;
                } else if (weight >= 10 && weight < 40) {
                    totalPrice = distance * 0.10;
                } else if (weight >= 40 && weight < 90) {
                    totalPrice = distance * 0.15;
                } else if (weight >= 90 && weight < 150) {
                    totalPrice = distance * 0.20;
                }
                break;
            case "express":

                if (weight < 1) {
                    totalPrice = distance * 0.03;
                    additionalTax = distance * (weight * (0.03 * 0.8));
                    totalPrice += additionalTax;
                } else if (weight >= 1 && weight < 10) {
                    totalPrice = distance * 0.05;
                    additionalTax = distance * (weight * (0.05 * 0.4));
                    totalPrice += additionalTax;
                } else if (weight >= 10 && weight < 40) {
                    totalPrice = distance * 0.10;
                    additionalTax = distance * (weight * (0.10 * 0.05));
                    totalPrice += additionalTax;
                } else if (weight >= 40 && weight < 90) {
                    totalPrice = distance * 0.15;
                    additionalTax = distance * (weight * (0.15 * 0.02));
                    totalPrice += additionalTax;
                } else if (weight >= 90 && weight < 150) {
                    totalPrice = distance * 0.20;
                    additionalTax = distance * (weight * (0.20 * 0.01));
                    totalPrice += additionalTax;
                }
                break;
        }
        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.",
                weight, totalPrice);
    }
}
/*Куриерска фирма доставя пратки в цялата страна.
За услуга тип "standard", срокът за доставка е 3 работни дни и фирмата калкулира цените при следните условия:
•	За пратки по - леки от 1 кг – 3 стотинки на километър.
•	От 1 кг до 10 кг – 5 стотинки на километър.
•	От 10 кг вкл. до 40 кг – 10 стотинки на километър.
•	От 40 кг вкл. до 90  кг – 15 стотинки на километър.
•	От 90 кг вкл. до 150 кг – 20 стотинки на километър.
За услуга тип "express", фирмата извършва услугата в рамките на 24 часа, като начислява надценка за всеки
километър както следва:
•	За пратки по - леки от 1 кг – на килограм по 80 % от съответната цена на километър
•	От 1 кг до 10  кг – на килограм по 40 % от съответната цена на километър
•	От 10 кг вкл. до 40 кг – на килограм по 5 % от съответната цена на километър
•	От 40 кг вкл. до 90  кг – на килограм по 2 % от съответната цена на километър
•	От 90 кг вкл. до 150 кг – на килограм по 1 % от съответната цена на километър
Напишете програма, която да пресмята при зададено разстояние в км. , тегло на пратката и вида услуга,
каква ще бъде стойността за доставка на дадена пратка.
Вход
Входът се чете от конзолата и съдържа 3 реда:
1.	Тегло на пратката в килограми – реално число в интервала [0.01 ... 150.00]
2.	Тип услуга –  текст със следните възможности: "standard" или "express"
3.	Разстояние в километри – цяло число в интервала [1 ... 1000]
Изход
Да се отпечата на конзолата един ред:
"The delivery of your shipment with weight of {тегло} kg. would cost {цена} lv."

•	Теглото да бъде закръглено до третия знак след десетичната запетая
•	Цената да бъде закръглена до втория знак след десетичната запетая
*/