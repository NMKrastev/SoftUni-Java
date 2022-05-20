import java.util.Scanner;

public class FitnessCenter05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, backCount = 0, chestCount = 0, legsCount = 0,
                absCount = 0, proteinShakeCount = 0, proteinBarCount = 0,
        trainingCount = 0, buyCount = 0;

        int clients = Integer.parseInt(scanner.nextLine());

        while (count != clients) {

             count++;
            String input = scanner.nextLine();

            switch (input) {
                case "Back":
                    backCount++;
                    trainingCount++;
                    break;
                case "Chest":
                    chestCount++;
                    trainingCount++;
                    break;
                case "Legs":
                    legsCount++;
                    trainingCount++;
                    break;
                case "Abs":
                    absCount++;
                    trainingCount++;
                    break;
                case "Protein shake":
                    proteinShakeCount++;
                    buyCount++;
                    break;
                case "Protein bar":
                    proteinBarCount++;
                    buyCount++;
                    break;
            }

        }

        System.out.printf("%d - back\n", backCount);
        System.out.printf("%d - chest\n", chestCount);
        System.out.printf("%d - legs\n", legsCount);
        System.out.printf("%d - abs\n", absCount);
        System.out.printf("%d - protein shake\n", proteinShakeCount);
        System.out.printf("%d - protein bar\n", proteinBarCount);
        System.out.printf("%.2f%% - work out\n", ((double)trainingCount / clients) * 100);
        System.out.printf("%.2f%% - protein\n", ((double)buyCount / clients) * 100);

    }
}
/*Напишете програма, която да изчислява броя на посетителите в един фитнес център. В началото програмата
получава броя на посетителите на фитнеса и за всеки човек - дейността, която извършва във фитнеса.
На края програмата трябва да отпечата броят трениращи за всяка една дейност
("Back", "Chest", 'Legs", "Abs") и броят клиенти, закупили продукт ("Protein shake", "Protein bar").
Също така - процентът трениращи (спрямо общия брой посетители) и процентът на клиентите, закупили
продукт от фитнеса.
Вход
От конзолата се чете число, след това поредица от низове, всяко на отделен ред:
•	На първия ред – броят на посетителите във фитнеса – цяло число в интервала [1...1000]
•	За всеки един посетител на отделен ред – дейността във фитнеса – текст
("Back", "Chest", "Legs", "Abs", "Protein shake" или "Protein bar")
Изход
Да се отпечатат на конзолата 8 реда, които съдържат следната информация:
Ред 1 -	"{брой хора трениращи гръб} - back"
Ред 2 -	"{брой хора трениращи гърди} - chest"
Ред 3 -	"{брой хора трениращи крака} - legs"
Ред 4 -	"{брой хора трениращи коремни мускули} - abs"
Ред 5 -	"{брой хора закупили протеинов шейк} - protein shake"
Ред 6 -	"{брой хора закупили протеинов блок} - protein bar"
Ред 7 -	"{процент на хората дошли да тренират}% - work out"
Ред 8 -	"{процент на хората дошли да купят протеин}% - protein"
Всички проценти трябва да са форматирани до втората цифра след десетичния знак.
*/