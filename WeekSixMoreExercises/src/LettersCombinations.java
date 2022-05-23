import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char startLetter = scanner.nextLine().charAt(0);
        char endLetter = scanner.nextLine().charAt(0);
        char missLetter = scanner.nextLine().charAt(0);
        int count = 0;

        for (char i = startLetter; i <= endLetter; i++) {

            for (char j = startLetter; j <= endLetter; j++) {

                for (char k = startLetter; k <= endLetter; k++) {

                    if (i != missLetter && j != missLetter && k != missLetter) {
                        count++;
                        sb.append(i);
                        sb.append(j);
                        sb.append(k);
                        sb.append(" ");
                    }
                }
            }

        }
        System.out.print(sb.toString());
        System.out.print(count);
    }
}
/*Напишете програма, която да принтира на конзолата всички комбинации от 3 букви в зададен интервал, като се пропускат комбинациите съдържащи
зададена от конзолата буква. Накрая трябва да се изпринтира броят на отпечатаните комбинации.
Вход
Входът се чете от конзолата и съдържа точно 3 реда:
Ред 1.	Малка буква от английската азбука за начало на интервала – от ‘a’ до ‚z’.
Ред 2.	Малка буква от английската азбука за край на интервала  – от първата буква до ‚z’.
Ред 3.	Малка буква от английската азбука – от ‘a’ до ‚z’ – като комбинациите съдържащи тази буквата се пропускат.
Изход
Да се отпечатат на един ред всички комбинации отговарящи на условието плюс броят им разделени с интервал.
*/