import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int area = height * width;
        int totalCake = 0;
        String input = scanner.nextLine();

        while (!input.equals("STOP")) {

            Integer cake = Integer.parseInt(input);
            totalCake += cake;

            if (totalCake >= area) {
                break;
            }
            input = scanner.nextLine();
        }

        if (totalCake >= area) {
            System.out.printf("No more cake left! You need %d pieces more.", totalCake - area);
        } else {
            System.out.printf("%d pieces are left.", area - totalCake);
        }
    }
}
/*Поканени сте на 30-ти рожден ден, на който рожденикът черпи с огромна торта. Той обаче не знае колко парчета
могат да си вземат гостите от нея. Вашата задача е да напишете програма, която изчислява броя на парчетата,
които гостите са взели, преди тя да свърши. Ще получите размерите на тортата в сантиметри
(широчина и дължина – цели числа в интервала [1...1000]) и след това на всеки ред, до получаване на
командата "STOP" или докато не свърши тортата, броят на парчетата, които гостите вземат от нея.
Парчетата са квадратни с размер  1 см .
Да се отпечата на конзолата един от следните редове:
•	"{брой парчета} pieces are left." - ако стигнете до STOP и има останали парчета торта.
•	"No more cake left! You need {брой недостигащи парчета} pieces more."
*/