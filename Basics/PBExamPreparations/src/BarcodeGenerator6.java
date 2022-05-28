import java.util.Scanner;

public class BarcodeGenerator6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        int firstStartDigit = (firstNum / 1000) % 10;
        int secondStartDigit = (firstNum / 100) % 10;
        int thirdStartDigit = (firstNum / 10) % 10;
        int fourthStartDigit = firstNum % 10;

        int firstEndDigit = (secondNum / 1000) % 10;
        int secondEndDigit = (secondNum / 100) % 10;
        int thirdEndDigit = (secondNum / 10) % 10;
        int fourthEndDigit = secondNum % 10;

        for (int i = firstStartDigit; i <= firstEndDigit; i++) {
            for (int j = secondStartDigit; j <= secondEndDigit; j++) {
                for (int k = thirdStartDigit; k <= thirdEndDigit; k++) {
                    for (int l = fourthStartDigit; l <= fourthEndDigit; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }

                }

            }

        }
    }
}
/*Техниката в магазин за коледни украси се разваля. Артикулите, които съдържат четни числа в своя
баркод не могат да бъдат маркирани от касиерите. Вашата задача е, да напишете програма, която генерира
всички баркодове, които НЕ съдържат четни цифри в себе си.
Вход:
•	Две четирицифрени числа, които показват обхвата на баркодовете, които трябва да промените.
•	Първи ред – четирицифрено число – началото на обхвата. Цяло число в интервала [1000…9999]
•	Втори ред – четирицифрено число – края на обхвата. Цяло число в интервала [1000…9999]
Изход:
На конзолата трябва да се отпечатат всички "баркодове", които НЕ съдържат четна цифра в себе си,
разделени с интервал.
*/