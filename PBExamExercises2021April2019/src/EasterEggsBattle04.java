import java.util.Scanner;

public class EasterEggsBattle04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        int eggsP1 = Integer.parseInt(scanner.nextLine());
        int eggsP2 = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();


        while (!input.equals("End")) {

            if (input.equals("one")) {
                eggsP2--;
                if (eggsP2 == 0) {
                    break;
                }
            } else if (input.equals("two")) {
                eggsP1--;
                if (eggsP1 == 0) {
                    break;
                }
            }

            input = scanner.nextLine();
            if (input.equals("End")) {
                isEnd = true;
            }

        }

        if (eggsP1 == 0) {
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggsP2);
        } else if (eggsP2 == 0) {
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggsP1);
        } else if (isEnd) {
            System.out.printf("Player one has %d eggs left.\n" +
                    "Player two has %d eggs left.", eggsP1, eggsP2);
        }

    }
}
/*На Великден семейството на Деси се събира и тя решава да организира "битка" между великденски яйца.
Правилата на "битката" са следните:
•	Участват двама играчи
•	Всеки от тях започва с определен брой яйца
•	При получаване на команда "one" -> първият играч печели => яйцата на втория намаляват с едно
•	При получаване на команда "two" -> вторият играч печели => яйцата на първия намаляват с едно
•	Играта приключва, ако някой от играчите остане без яйца или до получаване на команда "End"
Вход
Първоначално се четат два реда:
1.	Брой яйца, които има първият играч - цяло число в интервала [1 … 99]
2.	Брой яйца, които има вторият играч - цяло число в интервала [1 … 99]
След това до получаване на команда "End" се четe многократно един ред:
3.	Победител - текст - "one" или "two"
Изход
Ако първият играч остане без яйца:
•	"Player one is out of eggs. Player two has {брой останали яйца на втория играч} eggs left."
Ако вторият играч остане без яйца:
•	"Player two is out of eggs. Player one has {брой останали яйца на първия играч} eggs left."
При команда "End" да се отпечатат два реда:
•	"Player one has {брой останали яйца на първия играч} eggs left."
•	"Player two has {брой останали яйца на втория играч} eggs left."
*/