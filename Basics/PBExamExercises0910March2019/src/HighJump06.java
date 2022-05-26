import java.util.Scanner;

public class HighJump06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wantedHigh = Double.parseDouble(scanner.nextLine());
        double trainingHigh = wantedHigh - 30;
        int failJumpsCount = 0, totalJumpsCount = 0;
        boolean isFailed = false;

        while (trainingHigh <= wantedHigh) {

            double jump = Double.parseDouble(scanner.nextLine());

            if (jump <= trainingHigh) {
                failJumpsCount++;
                totalJumpsCount++;
                if (failJumpsCount == 3) {
                    isFailed = true;
                    break;
                }
            } else if (jump > trainingHigh) {
                trainingHigh += 5;
                failJumpsCount = 0;
                totalJumpsCount++;
            }
        }

        if (isFailed) {
            System.out.printf("Tihomir failed at %.0fcm after %d jumps.", trainingHigh, totalJumpsCount);
        } else {
            System.out.printf("Tihomir succeeded, he jumped over %.0fcm after %d jumps.", wantedHigh, totalJumpsCount);
        }
    }
}
/*Българският лекоатлет Тихомир Иванов започва тренировки за предстоящото европейско първенство по
лека атлетика на закрито в Глазгоу, Шотландия.
Вашата задача е да напишете софтуер, с който Иванов да следи своя прогрес и дали е достигнал желаните
резултати. В началото програмата получава желаната височина на летвата от Тихомир, той започва
тренировката си като поставя летвата на височина 30см по-ниско от целта. За всяка височина той има
право на 3 скока, като за да бъде един скок успешен, той трябва да бъде над височината на летвата.
При успешен скок (над летвата), височината й се вдига с 5 сантиметра. При три неуспешни скока на
една и съща височина, тренировката приключва с неуспех. При достигане на желаната височина и
нейното успешно прескачане, тренировката приключва с успех.
Вход
Входът е поредица от цели числа в интервала [100…300]:
•	На първия ред се прочита желаната от Тихомир Иванов височина в сантиметри
•	На всеки следващ ред до приключване на програмата се прочита височината от скока на Иванов
Изход
На конзолата трябва да се отпечата един ред:
•	Ако Тихомир не успее да преодолее желаната височина:
o	"Tihomir failed at {височина на летвата към момента на провала}cm after {брой скокове от началото на тренировката} jumps."
•	Ако Тихомир успее да преодолее височината:
o	"Tihomir succeeded, he jumped over {височина на прескочената последно летва}cm after {брой скокове за цялата тренировка} jumps."
*/