import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowerCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        if (flowerType.equals("Roses")) {
            totalPrice = flowerCount * 5;
            if (flowerCount > 80) {
                totalPrice = totalPrice * 0.9;
            }

        } else if (flowerType.equals("Dahlias")) {
            totalPrice = flowerCount * 3.80;
            if (flowerCount > 90) {
                totalPrice = totalPrice * 0.85;
            }
        } else if (flowerType.equals("Tulips")) {
            totalPrice = flowerCount * 2.80;
            if (flowerCount > 80) {
                totalPrice = totalPrice * 0.85;
            }
        } else if (flowerType.equals("Narcissus")) {
            totalPrice = flowerCount * 3.0;
            if (flowerCount < 120) {
                totalPrice = totalPrice + (totalPrice * 0.15);
            }
        } else if (flowerType.equals("Gladiolus")) {
            totalPrice = flowerCount * 2.50;
            if (flowerCount < 80) {
                totalPrice = totalPrice + (totalPrice * 0.20);
            }
        }

        if (totalPrice <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    flowerCount, flowerType, budget - totalPrice);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", totalPrice - budget);
        }
    }
}
/*цвете	                Роза	Далия	Лале	Нарцис	Гладиола
Цена на брой в лева	    5	    3.80	2.80	3	    2.50
Съществуват следните отстъпки:
•	Ако Нели купи повече от 80 Рози - 10% отстъпка от крайната цена
•	Ако Нели купи повече от 90  Далии - 15% отстъпка от крайната цена
•	Ако Нели купи повече от 80 Лалета - 15% отстъпка от крайната цена
•	Ако Нели купи по-малко от 120 Нарциса - цената се оскъпява с 15%
•	Ако Нели Купи по-малко от 80 Гладиоли - цената се оскъпява с 20%
"Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
*/