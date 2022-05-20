import java.util.Scanner;

public class CatWalking02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesPerDay = Integer.parseInt(scanner.nextLine());
        int walksPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesPerDay = Integer.parseInt(scanner.nextLine());

        int totalMins = walksPerDay * minutesPerDay;
        int burnedCals = totalMins * 5;
        int neededBurnCals = caloriesPerDay / 2;

        if (neededBurnCals <= burnedCals ) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", burnedCals);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", burnedCals);
        }

    }
}
/*Деси трябва да разхожда своята котка ежедневно, но не може да прецени колко минути са досатъчни на ден.
Като знаете колко калории приема котката на ден, колко пъти и по колко минути Деси разхожда котката си,
напишете програма, която изчислява дали разходката е достатъчна. За всяка минута от разходката, котката гори по 5 калории.
Разходката е достатъчна, ако котката изграря 50% от приетите калории.
Вход
Входът се чете от конзолата и съдържа точно 3 реда:
•	На първия ред - минути разходка на ден - цяло число в интервала [1...50]
•	На втория ред - броят на разходките дневно - цяло число в интервала [1…10]
•	На третия ред - приетите от котката калории на ден – цяло число в интервала [100…4000]
Изход
Да се отпечата на конзолата един ред:
•	Ако изгорените калории през разходката са повече или равни на  50% от приетите през деня калории:
"Yes, the walk for your cat is enough. Burned calories per day: {общо изгорени калории от разходката}."
•	Ако  изгорените калории през разходката са по-малко от 50% от приетите през деня калории:
 "No, the walk for your cat is not enough. Burned calories per day: {общо изгорени калории от разходката}."
*/