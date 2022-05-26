import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());
        int totalItems = puzzles + dolls + teddyBears + minions + trucks;
        double totalMoney = (puzzles * 2.60) + (dolls * 3.00) + (teddyBears * 4.10) + (minions * 8.20) + (trucks * 2.00);
        double moneyLeftNeeded;
        double discount = 0;
        double rent = totalMoney * 0.1;
        totalMoney = totalMoney - rent;

        if (totalItems >= 50) {
            discount = totalMoney * 0.25;
            totalMoney = totalMoney - discount;
        }

        if (totalMoney >= vacationPrice) {
            moneyLeftNeeded = totalMoney - vacationPrice;
            System.out.printf("Yes! %.2f lv left.", moneyLeftNeeded);
        } else {
            moneyLeftNeeded = vacationPrice - totalMoney;
            System.out.printf("Not enough money! %.2f lv needed.", moneyLeftNeeded);
        }
    }
}
/*
•	Пъзел - 2.60 лв.
•	Говореща кукла - 3 лв.
•	Плюшено мече - 4.10 лв.
•	Миньон - 8.20 лв.
•	Камионче - 2 лв.
От конзолата се четат 6 реда:
1.	Цена на екскурзията - реално число в интервала [1.00 … 10000.00]
2.	Брой пъзели - цяло число в интервала [0… 1000]
3.	Брой говорещи кукли - цяло число в интервала [0 … 1000]
4.	Брой плюшени мечета - цяло число в интервала [0 … 1000]
5.	Брой миньони - цяло число в интервала [0 … 1000]
6.	Брой камиончета - цяло число в интервала [0 … 1000]
Изход
На конзолата се отпечатва:
•	Ако парите са достатъчни се отпечатва:
o	"Yes! {оставащите пари} lv left."
•	Ако парите НЕ са достатъчни се отпечатва:
o	"Not enough money! {недостигащите пари} lv needed."
*/