import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int men = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int tables = Integer.parseInt(scanner.nextLine());
        boolean allCouples = false, tablesFull = false;
        int tablesCount = 0;

        for (int i = 1; i <= men; i++) {
            for (int j = 1; j <= women; j++) {

                System.out.printf("(%d <-> %d) ", i, j);
                tablesCount++;

                if (tablesCount == tables) {
                    tablesFull = true;
                    break;
                }
                if (i == men && j == women) {
                    allCouples = true;
                    break;
                }
            }
            if (tablesFull || allCouples) {
                break;
            }
        }
    }
}
/*Провокирани от сватбата си, Михаела и Иван решават да предоставят нова услуга на клиенти на ресторанта си,
а именно вечеря за запознанства - "Предизвикай Сватбата". Напишете програма, която отпечатва всички възможни
срещи на клиентите на ресторанта. При настаняване всеки мъж и всяка жена получават талончета с поредни номера
стартирайки от 1. Ако бъдат заети всички маси, програмата трябва да приключи. Всяка маса има две места.
Вход
От конзолата се четат точно 3 числа, всяко на отделен ред:
•	Броя клиенти мъже - цяло число в интервала [1...100]
•	Броя клиенти жени - цяло число в интервала [1...100]
•	Максималният брой маси - цяло число в интервала [1...100]
Изход
На конзолата се принтират на един ред, разделени с интервал всички срещи в следният формат:
•	({№ клиент} <-> {№ клиент}) ({№ клиент} <-> {№ клиент}) ...
*/