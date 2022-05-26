import java.util.Locale;
import java.util.Scanner;

public class GameNumberWars04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cardP1, cardP2, pointsP1 = 0, pointsP2 = 0, pointsDiff = 0;
        boolean isWinOne = false, isWinTwo = false;
        String winner = "";
        String nameOne = scanner.nextLine();
        String nameTwo = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("End of game")) {

            cardP1 = Integer.parseInt(input);
            String cardP2text = scanner.nextLine();
            cardP2 = Integer.parseInt(cardP2text);

            if (cardP1 == cardP2) {
                System.out.println("Number wars!");
                cardP1 = Integer.parseInt(scanner.nextLine());
                cardP2 = Integer.parseInt(scanner.nextLine());

                if (cardP1 > cardP2) {
                    winner = nameOne;
                    isWinOne = true;
                    break;
                } else if (cardP1 < cardP2) {
                    winner = nameTwo;
                    isWinTwo = true;
                    break;
                }
            }

            if (cardP1 > cardP2) {
                pointsP1 += (cardP1 - cardP2);
            } else if (cardP2 > cardP1) {
                pointsP2 += (cardP2 - cardP1);
            }

            input = scanner.nextLine();

        }

        if(isWinOne) {
            System.out.printf("%s is winner with %d points\n", winner, pointsP1);
        } else if (isWinTwo) {
            System.out.printf("%s is winner with %d points\n", winner, pointsP2);
        }else {
            System.out.printf("%s has %d points\n", nameOne, pointsP1);
            System.out.printf("%s has %d points\n", nameTwo, pointsP2);
        }

    }
}
/*"Numbers" е нова игра, която се играе с 36 карти (двойки, тройки, четворки, петици, шестици, седмици, осмици,
деветки и десетки от всички 4 бои). Правилата на играта са следните:
	Играе се от двама играчи, които започват с равен брой карти
	На всяко раздаване всеки един от тях дава по 1 карта:
o	Ако картата на първия играч е с по-голяма стойност от картата на втория играч, първият получава точки,
които са равни на разликата между картата на първия и картата на втория (например: първият дава тройка купа,
а вторият двойка каро -> първият печели, защото 3 > 2 и точките, които печели, са 3 – 2 = 1).
o	Ако картата на втория играч е с по-голяма стойност от картата на първия играч, вторият получава точки,
 които са равни на разликата между картата на втория и картата на първия (например: вторият дава осмица пика,
 а първият шестица спатия -> вторият печели, защото 8 > 6 и точките, които печели, са 8 – 6 = 2).
o	Ако картите, които дават двамата, са с еднаква стойност, тогава се получава "Number wars" и всеки един от
играчите трябва да даде по още една карта. Играчът, чиято карта е с по-голяма стойност, печели и играта
приключва(В този случай, няма да има еднакви карти).
	Освен при "Number wars", играта може да приключи и при команда "End of game". Тогава никой не печели и
играта приключва.
Вход
Първоначално се четат два реда:
•	Име на първия играч - текст
•	Име на втория играч - текст
След това, до получаване на команда "End of game", се четат многократно по два реда:
1.	Карта, която дава първият играч- цяло число в интервала [2…9]
2.	Карта, която дава вторият играч -  цяло число в интервала [2…9]
При еднакви карти на двамата играчи се прочитат нови два реда (карта, която дава първият и карта, която дава вторият.)
Изход
При случая, в който има "Number wars ", да се отпечата:
•	"Number wars!"
•	"{име на победителя} is winner with {брой натрупани точки} points"
При команда "End of game" да се отпечатат два реда:
•	"{име на първия играч} has {брой натрупани точки за първия играч} points"
•	"{име на втория играч} has {брой натрупани точки за втория играч} points"
*/