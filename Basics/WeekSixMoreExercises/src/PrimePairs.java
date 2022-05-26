import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstStart = Integer.parseInt(scanner.nextLine());
        int secondStart = Integer.parseInt(scanner.nextLine());
        int firstEnd = firstStart + Integer.parseInt(scanner.nextLine());
        int secondEnd = secondStart + Integer.parseInt(scanner.nextLine());
        int primeCheckNumber, divisibleCount;

        for (int i = firstStart; i <= firstEnd; i++) {
            primeCheckNumber = 2;
            divisibleCount = 0;
            while (primeCheckNumber <= i / 2) {
                if (i % primeCheckNumber == 0) {
                    divisibleCount++;
                    break;
                }
                primeCheckNumber++;
            }
            if (divisibleCount == 0 && i != 1) {
                for (int k = secondStart; k <= secondEnd; k++) {
                    primeCheckNumber = 2;
                    divisibleCount = 0;
                    while (primeCheckNumber <= k / 2) {
                        if (k % primeCheckNumber == 0) {
                            divisibleCount++;
                            break;
                        }
                        primeCheckNumber++;
                    }
                    if (divisibleCount == 0 && k != 1) {
                        System.out.printf("%d%d\n", i, k);
                    }
                }
            }
        }
    }
}
/*Напишете програма, която генерира и принтира на конзолата четирицифрени числа, в които първата и
втората двойка цифри образуват двуцифрени прости числа (пример за такова число 1723). Крайната
стойност до която трябва да се генерират двойките се определя от други 2 цифри, подадени като вход,
които определят с колко крайната стойност е по-голяма от началната.
Вход
От конзолата се четат четири реда:
•	На първия ред – началната стойност на първите първата двойка числа – цяло положително число в
диапазона [10… 90]
•	На втория ред – началната стойност на втората двойка числа – цяло положително число в диапазона
[10… 90]
•	На третия ред – разликата между началната и крайната стойност на  първата двойка числа – цяло
положително число в диапазона [1… 9]
•	На четвъртия ред – разликата между началната и крайната стойност на  втората двойка числа –
цяло положително число в диапазона [1… 9]
Изход:
Да се отпечатат на конзолата четирицифрените числа, в които първите две и вторите две цифри са
прости двуцифрени числа.
*/