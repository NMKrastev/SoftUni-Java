import java.util.Scanner;

public class AluminumJoinery03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orders = Integer.parseInt(scanner.nextLine());
        String typeOfUnit = scanner.nextLine();
        String delivery = scanner.nextLine();
        double price, totalPrice = 0;

        if (orders < 10) {
            System.out.println("Invalid order");
        } else {
            switch (typeOfUnit) {
                case "90X130" :
                    price = orders * 110;
                    if (orders > 60) {
                        totalPrice = price - (price * 0.08);
                    } else if (orders > 30) {
                        totalPrice = price - (price * 0.05);
                    } else {
                        totalPrice = price;
                    }
                break;
                case "100X150" :
                    price = orders * 140;
                    if (orders > 80) {
                        totalPrice = price - (price * 0.1);
                    } else if (orders > 40) {
                        totalPrice = price - (price * 0.06);
                    } else {
                        totalPrice = price;
                    }
                 break;
                case "130X180" :
                    price = orders * 190;
                    if (orders > 50) {
                        totalPrice = price - (price * 0.12);
                    } else if (orders > 20) {
                        totalPrice = price - (price * 0.07);
                    } else {
                        totalPrice = price;
                    }
                break;
                case "200X300" :
                    price = orders * 250;
                    if (orders > 50) {
                        totalPrice = price - (price * 0.14);
                    } else if (orders > 25) {
                        totalPrice = price - (price * 0.09);
                    } else {
                        totalPrice = price;
                    }
                break;
            }

            if (delivery.equals("With delivery")) {
                totalPrice += 60;
            }
            if (orders > 99) {
                totalPrice = totalPrice - (totalPrice * 0.04);
            }
            System.out.printf("%.2f BGN", totalPrice);
        }
    }
}
/*Фирма-производител на алуминиева дограма приема поръчки за изработката и монтаж със следния ценоразпис за един брой.
 Фирмата приема само поръчки на едро (над 10 бр.). В зависимост от поръчания брой дограми, фирмата прави
 различна отстъпка на своите клиенти.
Фирмата предлага също и доставка на поръчките си срещу 60 лв.
Размер	        Единична цена	            Отстъпка от цената
90X130	        110 лв.             Над 30 броя – 5%/Над 60 броя – 8%
100X150	        140 лв.	            Над 40 броя – 6%/Над 80 броя – 10%
130X180	        190 лв.	            Над 20 броя – 7%/Над 50 броя – 12%
200X300	        250 лв.	            Над 25 броя – 9%/Над 50 броя – 14%
Ако поръчката надвишава 99 броя  – върху крайната цена се начисляват допълнителни 4% отстъпка
(след като се начисли цената за доставка, ако има такава).
При поръчка под 10 бр. на конзолата да бъде изписано "Invalid order"
Вход:
Потребителят въвежда 3 реда:
1.	Брой дограми – цяло число в интервала [0..1000];
2.	Вид на дограмите – текст "90X130" или "100X150" или "130X180" или "200X300";
3.	Начин на получаване – текст
•	С доставка - "With delivery"
•	Без доставка - "Without delivery"
Изход:
Извежда се едно число – стойността на поръчката, в следния формат:
o	"{Обща стойност на поръчката} BGN"
Резултатът да се форматира до втори знак след десетичната запетая.

*/