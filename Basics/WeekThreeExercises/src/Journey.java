import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        double moneySpent = 0;

        switch (season){
            case "summer":
                if (budget <= 100) {
                    moneySpent = budget * 0.30;
                    System.out.printf("Somewhere in Bulgaria\nCamp - %.2f", moneySpent);
                } else if ((budget > 100 && budget <= 1000)) {
                    moneySpent = budget * 0.40;
                    System.out.printf("Somewhere in Balkans\nCamp - %.2f", moneySpent);
                } else if (budget > 1000) {
                    moneySpent = budget * 0.90;
                    System.out.printf("Somewhere in Europe\nHotel - %.2f", moneySpent);
                }
                break;
            case "winter":
                if (budget <= 100) {
                    moneySpent = budget * 0.70;
                    System.out.printf("Somewhere in Bulgaria\nHotel - %.2f", moneySpent);
                } else if ((budget > 100 && budget <= 1000)) {
                    moneySpent = budget * 0.80;
                    System.out.printf("Somewhere in Balkans\nHotel - %.2f", moneySpent);
                } else if (budget > 1000) {
                    moneySpent = budget * 0.90;
                    System.out.printf("Somewhere in Europe\nHotel - %.2f", moneySpent);
                }
                break;
        }
    }
}
/*Бюджета определя дестинацията, а сезона определя колко от бюджета ще изхарчи.
Ако е лято ще почива на къмпинг, а зимата в хотел. Ако е в Европа, независимо от сезона ще
почива в хотел. Всеки къмпинг или хотел, според дестинацията, има собствена цена която
отговаря на даден процент от бюджета:
•	При 100лв. или по-малко – някъде в България
o	Лято – 30% от бюджета
o	Зима – 70% от бюджета
•	При 1000лв. или по малко – някъде на Балканите
o	Лято – 40% от бюджета
o	Зима – 80% от бюджета
•	При повече от 1000лв. – някъде из Европа
o	При пътуване из Европа, независимо от сезона ще похарчи 90% от бюджета.
На конзолата трябва да се отпечатат два реда.
•	Първи ред – "Somewhere in [дестинация]“ измежду "Bulgaria", "Balkans" и "Europe"
•	Втори ред – "{Вид почивка} – {Похарчена сума}"
o	Почивката може да е между "Camp" и "Hotel"
o	Сумата трябва да е закръглена с точност до вторият знак след запетаята.
*/