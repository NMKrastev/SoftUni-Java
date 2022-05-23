import java.util.Locale;
import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char A = 'A';
        char lastSector = scanner.nextLine().toUpperCase().charAt(0);
        int rowsNum = Integer.parseInt(scanner.nextLine());
        int seatsNum = Integer.parseInt(scanner.nextLine());
        int seatsCount = 0, seatsNumEven = seatsNum;

        for (int i = A; i <= lastSector; i++) {

            for (int j = 1; j <= rowsNum; j++) {

                if (j % 2 == 0) {
                    seatsNumEven = seatsNum + 2;
                } else {
                    seatsNumEven =  seatsNum;
                }

                char a = 'a';

                for (int k = 1; k <= seatsNumEven; k++) {

                    System.out.printf("%s%d%s\n", A, j, a);
                    a++;
                    seatsCount++;
                }
            }
            rowsNum++;
            A++;
        }

        System.out.println(seatsCount);

    }
}
/*Младоженците искат да направят списък кой на кое място ще седи на сватбената церемония. Местата са разделени на
различни сектори. Секторите са главните латински букви като започват от A. Във всеки сектор има определен брой редове.
От конзолата се чете броят на редовете в първия сектор (A), като във всеки следващ сектор редовете се увеличават с 1.
На всеки ред има определен брой места - тяхната номерация е представена с малките латински букви. Броя на местата на
нечетните редове се прочита от конзолата, а на четните редове местата са с 2 повече.
Вход
От конзолата се четaт 3 реда:
•	Последния сектор от секторите - символ (B-Z)
•	Броят на редовете в първия сектор - цяло число (1-100)
•	Броят на местата на нечетен ред - цяло число (1-24)
Изход
Да се отпечата на конзолата всяко място на отделен ред по следния формат:
{сектор}{ред}{място}
Накрая трябва да отпечата броя на всички места.
*/