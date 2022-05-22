import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        boolean specialNum = num % i == 0 && num % j == 0 && num % k == 0 && num % l == 0;
                        if (specialNum) {
                            System.out.printf("%d%d%d%d ", i, j, k ,l);
                    }
                }
            }
        }
        }
    }
}
/*Да се напише програма, която чете едно цяло число N, въведено от потребителя, и генерира всички възможни
"специални" числа от 1111 до 9999. За да бъде "специално" едно число, то трябва да отговаря на следното
условие:
•	N да се дели на всяка една от неговите цифри без остатък.
Пример: при N = 16, 2418 е специално число:
•	16 / 2 = 8 без остатък
•	16 / 4 = 4 без остатък
•	16 / 1 = 16 без остатък
•	16 / 8 = 2 без остатък
Вход
Входът се чете от конзолата и се състои от едно цяло число в интервала [1…600000]
Изход
На конзолата трябва да се отпечатат всички "специални" числа, разделени с интервал
*/