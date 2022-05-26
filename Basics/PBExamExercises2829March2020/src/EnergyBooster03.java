import java.util.Scanner;

public class EnergyBooster03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String setSize = scanner.nextLine();
        int setNumber = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        switch (fruit) {
            case "Watermelon":
                switch (setSize) {
                    case "big":
                        totalPrice = setNumber * 5 * 28.70;
                        break;
                    case "small":
                        totalPrice = setNumber * 2 * 56;
                        break;
                }
                break;
            case "Mango":
                switch (setSize) {
                    case "big":
                        totalPrice = setNumber * 5 * 19.60;
                        break;
                    case "small":
                        totalPrice = setNumber * 2 * 36.66;
                        break;
                }
                break;
            case "Pineapple":
                switch (setSize) {
                    case "big":
                        totalPrice = setNumber * 5 * 24.80;
                        break;
                    case "small":
                        totalPrice = setNumber * 2 * 42.10;
                        break;
                }
                break;
            case "Raspberry":
                switch (setSize) {
                    case "big":
                        totalPrice = setNumber * 5 * 15.20;
                        break;
                    case "small":
                        totalPrice = setNumber * 2 * 20;
                        break;
                }
                break;
        }

        if (totalPrice >= 400 && totalPrice <= 1000) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (totalPrice > 1000) {
            totalPrice = totalPrice - (totalPrice * 0.5);
        }

        System.out.printf("%.2f lv.", totalPrice);

    }
}
/*Сезона за изкачване на алпийски върхове започва и всички алпинисти, се запасяват с енергийни гелове за изкачването.
Фирма предлага малки и големи разфасовки с по 2 бр. и 5 бр. енергийни гела, като цената на един гел зависи от плодовете,
 от които е направен. В зависимост от размера на разфасовката, цената за брой енергиен гел е различна.
 От конзолата се четат плодовете, размерът на опаковката ((малка) 2 бр. или (голяма) 5 бр.), както и
 колко разфасовки са поръчани. Да се напише програма, която изчислява сумата, която трябва да се плати за поръчката.
	            Диня 	        Манго       	Ананас      	Малина
2 броя (small)	56 лв./бр.	    36.66 лв./бр.	42.10 лв./бр.	20 лв./бр.
5 броя (big)	28.70 лв./бр.	19.60 лв./бр.	24.80 лв./бр.	15.20 лв./бр.
При поръчки:
•	от 400 лв. до 1000 лв. включително има 15% отстъпка
•	над 1000 лв. има 50% отстъпка
Вход
От конзолата се четат 3 реда:
1.	Плод - текст с възможности: "Watermelon", "Mango", "Pineapple" или "Raspberry"
2.	Размерът на сета - текст с възможности: "small" или "big"
3.	Брой на поръчаните сетове - цяло число в интервала [1 … 10000]
Изход
На конзолата се отпечатва 1 ред:
•	Цената, която трябва да се заплати, форматирана до втория знак след десетичната запетая,
в следния формат:
"{цената} lv."
*/