import java.util.Scanner;

public class SumAndProduct06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int a = 1; a <= 9; a++) {
            for (int b = 9; b >= a; b--) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 9; d >= c; d--) {

                        if (((a + b + c + d) == (a * b * c * d)) && num % 10 == 5) {
                            System.out.printf("%d%d%d%d", a, b, c, d);
                            isFound = true;
                            break;
                        } else if (((a * b * c * d) / (a + b + c +d)) == 3 && num % 3 == 0) {
                            System.out.printf("%d%d%d%d", d, c, b, a);
                            isFound = true;
                            break;
                        }

                    }
                    if (isFound) {
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        if (!isFound) {
            System.out.println("Nothing found");
        }
    }
}
/*Да се напише програма, която проверява сумата и произведението на всички числа, които са комбинация от
четирите цифри a, b, c и d.
В проверката участва и още едно число - n, което се чете от конзолата.
За всяка комбинация четирите цифри a, b, c и d се променят по следния начин:
•	a се мени от 1 до 9
•	b се мени от 9 до а
•	c се мени от 0 до 9
•	d се мени от 9 до c
Ако сумата (a + b + c + d) е равна на произведението (a * b * c * d) и едновременно с това n завършва на 5,
трябва да се принтира числото abcd.
Ако разделим произведението (a * b * c * d) на сумата (a + b + c + d) и получим 3 (целочислено), и едновременно
с това n се дели на 3 без остатък, трябва да се принтира числото dcba.
Програмата трябва да принтира на конзолата само първата валидна комбинация.
Ако не се намери такова число abcd или dcba, трябва да се принтира "Nothing found".
Вход:
От конзолата се прочита 1 ред:
•	n - цяло число в интервала [100…1000]
Изход:
На конзолата се отпечатва 1 ред:
•	Ако се намери валидна комбинация:
o	"{number}", където {number} е комбинацията abcd или комбинацията dcba
•	Ако НЕ се намери такава комбинация:
o	"Nothing found"
*/