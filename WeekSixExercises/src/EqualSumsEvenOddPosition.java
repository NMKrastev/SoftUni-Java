import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            String currentNum = "" + i;
            int oddNum = 0;
            int evenNum = 0;
            for (int j = 0; j < currentNum.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));

                if (j % 2 == 0) {
                    evenNum += currentDigit;
                } else {
                    oddNum += currentDigit;
                }
            }
            if (evenNum == oddNum){
                System.out.print(i + " ");
            }
        }
    }
}
/*Напишете програма, която чете от конзолата две шестцифрени цели числа в диапазона от 100000 до 300000.
Винаги първото въведено число ще бъде по малко от второто. На конзолата да се отпечатат на 1 ред разделени с
интервал всички числа, които се намират между двете, прочетени от конзолата числа и отговарят на следното условие:
•	сумата от цифрите на четни и нечетни позиции да са равни. Ако няма числа, отговарящи на условието на конзолата
не се извежда резултат.
*/