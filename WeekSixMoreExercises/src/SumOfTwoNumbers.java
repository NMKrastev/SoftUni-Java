import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numMagic = Integer.parseInt(scanner.nextLine());
        int count = 0;
        boolean isFound = false;

        for (int i = numOne; i <= numTwo; i++) {
            for (int j = numOne; j <= numTwo; j++) {

                    if (i + j == numMagic) {
                        count++;
                        System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j, i + j);
                        isFound = true;
                        break;
                    }
                    count++;
                if (isFound) {
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        if (!isFound) {
            System.out.printf("%d combinations - neither equals %d", count, numMagic);
        }
    }
}
/*Напишете програма която проверява всички възможни комбинации от двойка числа в интервала от две дадени числа.
На изхода се отпечатва, коя поред е комбинацията чиито сбор от числата е равен на дадено магическо число.
Ако няма нито една комбинация отговаряща на условието се печата съобщение, че не е намерено.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред – начало на интервала – цяло число в интервала [1...999]
•	Втори ред – край на интервала – цяло число в интервала [по-голямо от първото число...1000]
•	Трети ред – магическото число – цяло число в интервала [1...10000]
Изход
На конзолата трябва да се отпечата един ред, според резултата:
•	Ако е намерена комбинация чиито сбор на числата е равен на магическото число
o	"Combination N:{пореден номер} ({първото число} + {второ число} = {магическото число})"
•	Ако не е намерена комбинация отговаряща на условието
o	"{броят на всички комбинации} combinations - neither equals {магическото число}"
*/