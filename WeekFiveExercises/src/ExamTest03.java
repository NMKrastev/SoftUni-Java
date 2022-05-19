import java.util.Scanner;

public class ExamTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        String pack = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double pricePerDay = 0, totalPrice = 0;

        if (!city.equals("Bansko") && !city.equals("Borovets")
                && !city.equals("Varna") && !city.equals("Burgas")) {
            System.out.println("Invalid input!");
        } else if (!pack.equals("withEquipment") && !pack.equals("noEquipment")
                && !pack.equals("withBreakfast") && !pack.equals("noBreakfast")) {
            System.out.println("Invalid input!");
        } else if (days < 1) {
            System.out.println("Days must be positive number!");
        } else {

            switch (vip) {
                case "yes":
                    if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("withEquipment")) {
                        pricePerDay = 100 - 100 * 0.1;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("noEquipment")) {
                        pricePerDay = 80 - 80 * 0.05;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("withBreakfast")) {
                        pricePerDay = 130 - 130 * 0.12;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("noBreakfast")) {
                        pricePerDay = 100 - 100 * 0.07;
                        totalPrice = days * pricePerDay;
                    }
                    break;
                case "no":
                    if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("withEquipment")) {
                        pricePerDay = 100;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("noEquipment")) {
                        pricePerDay = 80;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("withBreakfast")) {
                        pricePerDay = 130;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("noBreakfast")) {
                        pricePerDay = 100;
                        totalPrice = days * pricePerDay;
                    }
                    break;
            }
            if (days > 7) {
                days -= 1;
                totalPrice = days * pricePerDay;
            }
            System.out.printf("The price is %.2flv! Have a nice time!", totalPrice);
        }
    }
}
/*Туристическа агенция има нужда от система за изчисляване на дължимата сума при резервация.
В зависимост от различните дестинации и различните пакети, цената е различна.
Цените за ден са следните:
Цена за ден	            Банско/Боровец	                            Варна/Бургас
	             с екипировка	    без екипировка	        със закуска	        без закуска
	            100лв.	            80лв	                130лв.	            100лв.
VIP отстъпка	10%	                5%	                    12%	                7%
Ако клиентът е заявил престой повече от 7 дни, получава единия ден безплатно.
Вход
От конзолата се четат 4 реда:
1.	Име на града - текст с възможности ("Bansko",  "Borovets", "Varna" или "Burgas")
2.	Вид на пакета - текст с възможности ("noEquipment",  "withEquipment", "noBreakfast" или "withBreakfast")
3.	Притежание на VIP отстъпка - текст с възможности  "yes" или "no"
4.	Дни за престой - цяло число в интервала [1 … 10000]
Изход
На конзолата се отпечатва 1 ред:
•	Когато потребителят е въвел всички данни правилно, отпечатваме:
"The price is {цената, форматирана до втория знак}lv! Have a nice time!"
•	Ако потребителят е въвел по-малко от 1 ден за престой, отпечатваме:
"Days must be positive number!"
•	Когато при въвеждането на града или вида на пакета се въведат невалидни данни, отпечатваме: "Invalid input!"
*/