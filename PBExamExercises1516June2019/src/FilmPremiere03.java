import java.util.Scanner;

public class FilmPremiere03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        String pack = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        switch (movie) {
            case "John Wick":
                switch (pack) {
                    case "Drink":
                        totalPrice = tickets * 12;
                        break;
                    case "Popcorn":
                        totalPrice = tickets * 15;
                        break;
                    case "Menu":
                        totalPrice = tickets * 19;
                }
                break;
            case "Star Wars":
                switch (pack) {
                    case "Drink":
                        totalPrice = tickets * 18;
                        break;
                    case "Popcorn":
                        totalPrice = tickets * 25;
                        break;
                    case "Menu":
                        totalPrice = tickets * 30;
                }
                if (tickets >= 4) {
                    totalPrice = totalPrice - (totalPrice * 0.3);
                }
                break;
            case "Jumanji":
                switch (pack) {
                    case "Drink":
                        totalPrice = tickets * 9;
                        break;
                    case "Popcorn":
                        totalPrice = tickets * 11;
                        break;
                    case "Menu":
                        totalPrice = tickets * 14;
                }
                if (tickets == 2) {
                    totalPrice = totalPrice - (totalPrice * 0.15);
                }
                break;
        }
        System.out.printf("Your bill is %.2f leva.", totalPrice);
    }
}

/*За предстояща премиера на три известни продукции, местно кино ви наема да напишете софтуер, който да изчислява цената,
която клиентите трябва да заплатят, според филма и пакета, който са избрали.
	            John Wick	        Star Wars       	Jumanji
Напитка     	12 лв./бр.	        18 лв. /бр.     	9 лв. /бр.
Пуканки	        15 лв. /бр.     	25 лв. /бр.	        11 лв. /бр.
Меню	        19 лв. /бр.	        30 лв. /бр.	        14 лв. /бр.
Напишете програма, която изчислява цената, която трябва да се заплати, като имате в предвид следните отстъпки:
•	При избран филм "Star Wars" и закупени поне четири билета, има 30% семейна отстъпка.
•	При избран филм "Jumanji" и закупени точно два билета, има 15% отстъпка за двама.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред - прожекция - текст с възможности"John Wick", "Star Wars" или "Jumanji"
•	Втори ред - пакет за филм - текст  с възможности "Drink", "Popcorn" или "Menu"
•	Трети ред - брой билети - цяло число в интервала [1… 30]
Изход
На конзолата трябва да се отпечата един ред:
"Your bill is {крайна цена} leva."
Цената да бъде закръглена до втората цифра след десетичния знак.
*/