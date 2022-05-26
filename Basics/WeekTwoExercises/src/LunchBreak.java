import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String showName = scanner.nextLine();
        int showRunTime = Integer.parseInt(scanner.nextLine());
        int breakTime =  Integer.parseInt(scanner.nextLine());
        double lunchTime = breakTime / 8.0;
        double relaxTime = breakTime / 4.0;
        double totalBreakTime = lunchTime + relaxTime;
        double timeLeft = Math.abs(breakTime - totalBreakTime);

        if (timeLeft >= showRunTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    showName, Math.ceil(timeLeft - showRunTime));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    showName, Math.ceil(showRunTime - timeLeft));
        }
    }
}

/*По време на обедната почивка искате да изгледате епизод от своя любим сериал.
Вашата задача е да напишете програма, с която ще разберете дали имате достатъчно време да изгледате епизода.
По време на почивката отделяте време за обяд и време за отдих.
Времето за обяд ще бъде 1/8 от времето за почивка, а времето за отдих ще бъде 1/4 от времето за почивка.
Вход
От конзолата се четат 3 реда:
1.	Име на сериал – текст
2.	Продължителност на епизод  – цяло число в диапазона [10… 90]
3.	Продължителност на почивката  – цяло число в диапазона [10… 120]
Изход
На конзолата да се изпише един ред:
•	Ако времето е достатъчно да изгледате епизода:
"You have enough time to watch {име на сериал} and left with {останало време} minutes free time."
•	Ако времето не Ви е достатъчно:
"You don't have enough time to watch {име на сериал}, you need {нужно време} more minutes."
Времето да се закръгли до най-близкото цяло число нагоре.
*/